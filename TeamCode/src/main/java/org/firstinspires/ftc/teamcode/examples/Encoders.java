package org.firstinspires.ftc.teamcode.examples;

/* Example of writing encoders
 *
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/* Tetrix encoders have 1440 ticks per revolution
 * Andymark encoders have 1120 ticks per revolution
 */

@Autonomous(name="Test: Encoders")
@Disabled
public class Encoders extends LinearOpMode {

    /* Initialize variables */
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private ElapsedTime     runtime = new ElapsedTime();

    /* Measurements */
    static final double     COUNTS_PER_MOTOR_REV    = 1440 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);

    @Override
    public void runOpMode() throws InterruptedException {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        idle();
    }

    /*
         *  Method to perform a relative move, based on encoder counts.
         *  Encoders are not reset as the move is based on the current position.
         *  Move will stop if any of three conditions occur:
         *  1) Move gets to the desired position
         *  2) Move runs out of time
         *  3) Driver stops the opmode running.
         */
    public void encoderDrive(double speed,
                             double leftInches, double rightInches,
                             double timeoutS) throws InterruptedException {
        int newLeftTarget;
        int newRightTarget;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftTarget = leftMotor.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newRightTarget = rightMotor.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            leftMotor.setTargetPosition(newLeftTarget);
            rightMotor.setTargetPosition(newRightTarget);

            // Turn On RUN_TO_POSITION
            leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            leftMotor.setPower(Math.abs(speed));
            rightMotor.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (leftMotor.isBusy() && rightMotor.isBusy())) {

                // Allow time for other processes to run.
                idle();
            }

            // Stop all motion;
            leftMotor.setPower(0);
            rightMotor.setPower(0);

            // Turn off RUN_TO_POSITION
            leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
        }
    }
}
