package org.firstinspires.ftc.teamcode.examples;

/* Example of writing encoders
 *
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

/* Tetrix encoders have 1440 ticks per revolution
 * Andymark encoders have 1120 ticks per revolution
 */

@Autonomous(name="Test: Encoders", group="Test")
public class Encoders extends LinearOpMode {
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    private final int TICKS_PER_ROTATION = 1120;
    private final int WHEEL_DIAMETER = 4;   //Inches
    private final int BOT_DIAMETER = 15;    //Inches
    private final double kP = 10.00436;

    @Override
    public void runOpMode() throws InterruptedException {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        driveToPosition(45);

        turnToPosition(20);

        idle();
    }

    public void driveToPosition(double position) {
        double rotations = position / (WHEEL_DIAMETER * Math.PI);
        double[] power = {1, 1};
        double[] error = {rotations * TICKS_PER_ROTATION, rotations * TICKS_PER_ROTATION};

        resetEncoders();

        while(Math.abs(leftMotor.getCurrentPosition()) < Math.abs(rotations * TICKS_PER_ROTATION) && Math.abs(rightMotor.getCurrentPosition()) < Math.abs(rotations * TICKS_PER_ROTATION)) {
            error[0] = rotations * TICKS_PER_ROTATION - leftMotor.getCurrentPosition();
            error[1] = rotations * TICKS_PER_ROTATION - rightMotor.getCurrentPosition();

            power[0] = Range.clip(error[0] * kP, -1, 1);
            power[1] = Range.clip(error[1] * kP, -1, 1);

            leftMotor.setPower(power[0]);
            rightMotor.setPower(power[1]);
        }

        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

    public void turnToPosition(double angle) {
        resetEncoders();

        double rotations = angle / 180 * 3.9;
        double power = 1;
        double error = rotations * TICKS_PER_ROTATION;

        resetEncoders();

        while(Math.abs(leftMotor.getCurrentPosition()) < Math.abs(rotations * TICKS_PER_ROTATION)) {
            error = rotations * TICKS_PER_ROTATION - leftMotor.getCurrentPosition();

            power = Range.clip(error * kP, -1, 1);

            leftMotor.setPower(power);
            rightMotor.setPower(0.0);
        }

        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

    public int[] getPosition() {
        return new int[] {
                leftMotor.getCurrentPosition(),
                rightMotor.getCurrentPosition()
        };
    }

    public void resetEncoders() {
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
}
