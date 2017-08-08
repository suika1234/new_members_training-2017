package org.firstinspires.ftc.teamcode.examples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Example of an autonomous mode, driving by time
 */

public class AutoByTime extends LinearOpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;

    private ElapsedTime runtime  = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        leftMotor = hardwareMap.dcMotor.get("left_motor");
        rightMotor = hardwareMap.dcMotor.get("right_motor");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        leftMotor.setPower(0);
        rightMotor.setPower(0);

        waitForStart();

        //Drive forward for 3 seconds
        leftMotor.setPower(0.5);
        rightMotor.setPower(0.5);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            telemetry.addData("Path", "Leg 1: Drive forward for 3 seconds", runtime.seconds());
            telemetry.update();
            idle();
        }

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
        idle();
    }
}
