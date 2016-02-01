package org.usfirst.frc.team3786.robot.config.ui;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class TankDrive extends UIConfig{
    
	//*************Button Config*************
	
	private static final int SHOOT_BUTTON = 0;
	private static final int AIM_UP_BUTTON = 0;
	private static final int AIM_DOWN_BUTTON = 0;
	private static final int TRAVEL_AIM_BUTTON= 0;
	private static final int SHOOT_POSITION_BUTTON= 0;
	private static final int SHOOTER_WHEEL_SPEED_AXIS= 0;
	private static final int EXTEND_HOOK= 0;
	private static final int PULL_HOOK= 0;
	
	//******************END******************
	private Joystick leftStick, rightStick;
	
	public TankDrive() {
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
	}

	@Override
	public double getLeftDrive() {
		return leftStick.getY();
	}

	@Override
	public double getRightDrive() {
		return rightStick.getY();
	}

	@Override
	public Button shootButton() {
		return (new JoystickButton(rightStick, SHOOT_BUTTON));
	}

	@Override
	public Button aimUpButton() {
		return (new JoystickButton(rightStick, AIM_UP_BUTTON));
	}

	@Override
	public Button aimDownButton() {
		return (new JoystickButton(rightStick, AIM_DOWN_BUTTON));
	}

	@Override
	public Button travelAimButton() {
		return (new JoystickButton(rightStick, TRAVEL_AIM_BUTTON));
	}

	@Override
	public Button shootPositionButton() {
		return (new JoystickButton(leftStick, SHOOT_POSITION_BUTTON));
	}

	@Override
	public double getShooterWheelSpeed() {
		return leftStick.getRawAxis(SHOOTER_WHEEL_SPEED_AXIS);
	}

	@Override
	public Button extendHookButton() {
		return (new JoystickButton(leftStick, EXTEND_HOOK));
	}

	@Override
	public Button pullHookButton() {
		return (new JoystickButton(leftStick, PULL_HOOK));
	}
	
}

