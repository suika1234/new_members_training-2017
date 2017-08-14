package org.firstinspires.ftc.teamcode.Tutorial;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="Autonomous_Tutorial")
@Disabled

/**
 * Created by Student on 8/12/2017.
 */
public class Autonomous_Tutorial extends LinearOpMode {
    private DcMotor LeftMotor;
    private DcMotor rightMotor;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        LeftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        LeftMotor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        /*the robot's power is 0.5, it will go 48 inches forward, with a 3 second timeout
        before going to its next move */
        encoderDrive(0.5, 48, 48, 3);
        encoderDrive(0.7, -30, 30, 4);
        encoderDrive(0.5, 40, -40, 2);
        // set the power to 0.7, turn 30 inches to the left, with a 4 second timeout
        // set the power to 0.5, turn 40 inches to the right, with a 2 second timeout

        encoderDrive(0.5, 48, 48, 3);

        /*
        arcadeDrive(0.5,0);
        runtime.reset();
        while (opModeIsActive()&&(runtime.seconds())<4.0)){
            telemetry.addData("Path", "1: Drive forward for 4 seconds", runtime.seconds());
            telemetry.update();

            arcadeDrive(-0.5,0);
            runtime.reset();
            while (opModeIsActive()&&(runtime.seconds())<6.0)){
                telemetry.addData("Path", "1:Drive backward for 6 seconds", runtime.seconds());
                telemetry.update();
            }
            */


        idle();

    }

    public void arcadeDrive(double power, double turn) {
        double leftPower = Range.clip(power + turn, -1, 1);
        double rightPower = Range.clip(power - turn, -1, 1);

        LeftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);
    }

    public void encoderDrive(double speed, double leftInches, double rightInches,
                             double timeoutS) throws InterruptedException {
        int newLeftTarget;
        int newRightTarget;
        if (opModeIsActive()) {
            newLeftTarget = LeftMotor.getCurrentPosition() * (int) (leftInches * 1440);
            newRightTarget = rightMotor.getCurrentPosition() * (int) (rightInches * 1140);
            LeftMotor.setTargetPosition(newLeftTarget);
            rightMotor.setTargetPosition(newRightTarget);

            LeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            LeftMotor.setPower(speed);
            rightMotor.setPower(speed);

            while (opModeIsActive() && (runtime.seconds() < timeoutS) &&
                    (LeftMotor.isBusy() && rightMotor.isBusy())) {
                idle();
            }
        }
    }
}