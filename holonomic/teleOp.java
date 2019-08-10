package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="holonomic")

public class teleOp extends OpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
    public DcMotor intake;


    @Override
    public void init() {

        frontLeft = hardwareMap.dcMotor.get("motor_4");
        frontRight = hardwareMap.dcMotor.get("motor_1");
        backRight = hardwareMap.dcMotor.get("motor_2");
        backLeft = hardwareMap.dcMotor.get("motor_3");
        intake = hardwareMap.dcMotor.get("motor_5");

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

    }
    @Override
    public void loop() {
        //nitty gritty way of using holonomic logic
        frontLeft.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x);
        frontRight.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x);
        backLeft.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x);
        backRight.setPower(-gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x);
    }
}
