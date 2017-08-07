package org.firstinspires.ftc.teamcode.opmodes.subsystems;

/* Example of a Drivetrain class
 * Keep in mind that this is only one way of organizing your code
 * I just personally prefer to keep the some of measurements/methods in subsystems,
 * so that it is not as messy later on when we add more things in the code
 */
public class Drivetrain {

    /* Declare measurements of the robot */
    //Example:
    //private final int WHEEL_DIAMETER = 4;   //Inches
    //private final int BOT_DIAMETER = 15;    //Inches

    /* Declare the members in the drivetrain */
    //Example:
    //private DcMotor leftMotor;
    //private DcMotor rightMotor;



    // This is called a constructor. The things in the parenthesis are called the parameters.
    // Depending on what your robot can do, you can add in the parameters to suit the robot as needed.
    // For example, we have 2 motors to operate the four wheels on the robot.
    // Therefore, we would pass 2 DcMotor in the parameters for public Drivetrain() { }

    public Drivetrain(/* DcMotor leftMotor, DcMotor rightMotor */) {
        //this.leftMotor = leftMotor;
        //this.rightMotor = rightMotor;

        //this.leftMotor.setDirection(DcMotor.Direction.FORWARD);
        //this.rightMotor.setDirection(DcMotor.Direction.REVERSE);

        //leftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //rightDriveMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //You can create several methods, or the actions, for the robots to do here.
    //Creating a method can save you time. Instead of rewriting the things that goes in these methods
    //for each autonomous or teleop that you do, you can replace it by simply writing a method.

    //this is the driving method for the robot
    //Hint, you would want to pass parameters in arcadeDrive()
    public void arcadeDrive() {

    }

    //if you're using encoders, you can use this method to reset it.

    public void resetEncoders() {
        //Example:
        //leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    //this can use to stop the robot once the robot has reached its objectives
    public void stop() {
        //If you want the robot to stop, you would need to set all of its power to 0
        //Example:
        //leftMotor.setPower(0);
        //rightMotor.setPower(0);
    }
}
