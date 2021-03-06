package org.usfirst.frc.team3786.robot.subsystems;

import org.usfirst.frc.team3786.robot.commands.shooting.ShooterCommand;
import org.usfirst.frc.team3786.robot.config.robot.RobotConfig;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This Class holds methods to control the shooter wheels
 * @author Manpreet Singh 2016
 */
public class Shooter extends Subsystem{
	
	private static Shooter instance;
	
	private static final double SHOOT_SPEED = -1;
	private static final double INTAKE_SPEED = .5;
	private DigitalInput haveBall;
	private boolean wheelsSpinning;
	
	private Talon shooterWheels;
		
	public Shooter() {
		shooterWheels = new Talon(RobotConfig.getInstance().getShooterWheels());
		haveBall = new DigitalInput(RobotConfig.getInstance().ballEngagementID());
	}
	
	public static Shooter getInstance() {
		if(instance == null)
			instance = new Shooter();
		return instance;
	}
	
	public void setSpeed(double speed){
		shooterWheels.set(speed);
	}
	
	/**
	 * Spin Shooter Wheels to full speed
	 * I don't know why i wrote this method, i just did 
	 */
	public void fullSpeedAhead() {
		shooterWheels.set(1);
	}
	
	/**
	 * @return DigitalInput object that holds data on the limit switch
	 */
	public DigitalInput checkForBall() {
		return haveBall;
	}
	
	public boolean wheelsSpinning() {
		return wheelsSpinning;
	}
	
	/**
	 * Spin the wheels to intake speed
	 */
	public void spinToIntakeSpeed() {
		shooterWheels.set(INTAKE_SPEED);
		wheelsSpinning = true;
	}
	
	/**
	 * Spin the wheels to intake speed
	 */
	public void spinToLowGoalSpeed() {
		shooterWheels.set(-INTAKE_SPEED);
		wheelsSpinning = true;
	}
	
	/**
	 * Spin the wheels to shoot speed
	 */
	public void spinToShootSpeed() {
		shooterWheels.set(SHOOT_SPEED);
		wheelsSpinning = true;
	}
	
	/**
	 * Stop the shooter wheels;
	 */
	public void STOP() {
		shooterWheels.set(0);
		wheelsSpinning = false;
	}
		
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ShooterCommand());
	}
}
