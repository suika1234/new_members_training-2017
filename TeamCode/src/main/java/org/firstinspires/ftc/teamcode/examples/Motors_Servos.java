package org.firstinspires.ftc.teamcode.examples;

/* Example of writing motors & servos
 *
 */

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Test: Motors_Servos")
@Disabled
public class Motors_Servos extends OpMode {

    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private Servo servo;

    @Override
    public void init() {
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        servo = hardwareMap.servo.get("arm");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);
        servo.setDirection(Servo.Direction.FORWARD);

    }
    @Override
    public void start() {
        leftMotor.setPower(0.0);
        rightMotor.setPower(0.0);
        servo.setPosition(0.0);

    }
    @Override
    public void loop() {

    }
}



