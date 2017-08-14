import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Student on 8/14/2017.
 */
@TeleOp(name="Teleop_Tutorial")
public class Teleop_Practice extends OpMode {

    private Servo arm;
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    public void init(){
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        arm = hardwareMap.servo.get("arm");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void start(){

    }

    public void loop(){

    }
    public void stop(){

    }

}
