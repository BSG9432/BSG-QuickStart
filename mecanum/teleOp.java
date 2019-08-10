package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.TeleOp;
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Mecanum Tele-Op")
public class teleOp extends OpMode {
    public DcMotor frontRight;
    public DcMotor backRight;
    public DcMotor frontLeft;
    public DcMotor backLeft;

    public void init() {

        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");

        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
    @Override
    public void loop() {
        double G1rightStickY = gamepad1.right_stick_y;
        double G1leftStickY = -gamepad1.left_stick_y;

        //STRAFE CODE BELOW
        //x axis to right -> 1
        //x axis to left -> -1
        //strafe right
        if(gamepad1.right_stick_x > .1){
            frontRight.setPower(gamepad1.right_stick_x);
            backRight.setPower(-gamepad1.right_stick_x);
            frontLeft.setPower(gamepad1.right_stick_x);
            backLeft.setPower(-gamepad1.right_stick_x);
        }
        //strafe left
        else if(gamepad1.right_stick_x < .1){
            frontRight.setPower(gamepad1.right_stick_x);
            backRight.setPower(-gamepad1.right_stick_x);
            frontLeft.setPower(gamepad1.right_stick_x);
            backLeft.setPower(-gamepad1.right_stick_x);
        }
        else {
            frontRight.setPower(G1rightStickY);
            backRight.setPower(G1rightStickY);
            frontLeft.setPower(G1leftStickY);
            backLeft.setPower(G1leftStickY);

        }

        //Right Side
        if (Math.abs(gamepad1.right_stick_y) > .1) {
            frontRight.setPower(gamepad1.right_stick_y);
            backRight.setPower(gamepad1.right_stick_y);
        } else {
            frontRight.setPower(0);
            backRight.setPower(0);
        }

        //Left Side
        if (Math.abs(gamepad1.left_stick_y) > .1) {
            frontLeft.setPower(-gamepad1.left_stick_y);
            backLeft.setPower(-gamepad1.left_stick_y);
        } else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }



    }
}
