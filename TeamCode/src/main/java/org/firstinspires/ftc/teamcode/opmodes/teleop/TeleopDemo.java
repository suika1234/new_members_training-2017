package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/* Different things you can utilize in a teleop program
 *
 */
@TeleOp(name="Test: TeleopDemo", group="Test")

public class TeleopDemo extends OpMode {

    /* Declare OpMode members. */
    //Examples:
    // private DcMotor leftMotor;
    // private DcMotor rightMotor;
    // private Servo arm;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* eg: Initialize the hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names assigned during the robot configuration
         * step (using the FTC Robot Controller app on the phone).
         */

        //Example:
        //drivetrain = new Drivetrain(hardwareMap.dcMotor.get("left"), hardwareMap.dcMotor.get("right"));
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        //Example:
        //drivetrain.stop();

    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        //Example:
        /* if(gamepad1.x) {
            drivetrain.stop();
        } */

    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {

    }
}
