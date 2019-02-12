/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommands.DriveTeleop;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  private static WPI_TalonSRX frontLeftMotor;
  private static WPI_TalonSRX frontRightMotor;
  private static WPI_TalonSRX rearLeftMotor;
  private static WPI_TalonSRX rearRightMotor;

  final static double defaultP = 2.0;                     //all these things may need to be changed
	final static double defaultI = 0.0006;
	final static double defaultD = -.025;
	final static double deadband = .1;
  final static double ticksPerInch = 4096 / (6 * Math.PI);

  private double startDistance;


  public Drivetrain() {
    frontLeftMotor = new WPI_TalonSRX(RobotMap.frontLeftMotor);
    frontRightMotor = new WPI_TalonSRX(RobotMap.frontRightMotor);
    rearLeftMotor = new WPI_TalonSRX(RobotMap.rearLeftMotor);
    rearRightMotor = new WPI_TalonSRX(RobotMap.rearRightMotor);
    
    frontRightMotor.follow(rearRightMotor);
		frontLeftMotor.follow(rearLeftMotor);

    startDistance = getRawDistance();
  }

  public void differentialDrive(double leftPercentage, double rightPercentage) {
    rearLeftMotor.set(ControlMode.PercentOutput, applyDeadband(leftPercentage, deadband));
		rearRightMotor.set(ControlMode.PercentOutput, applyDeadband(rightPercentage, deadband));
		
  }

  public void resetDistance() {
    startDistance = getRawDistance();
  }

  private double getRawDistance() {
		SmartDashboard.putNumber("Left Ticks", rearLeftMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Right Ticks", rearRightMotor.getSelectedSensorPosition(0));
		double total = 0;
		total += (rearLeftMotor.getSelectedSensorPosition(0) / ticksPerInch);
		total += (rearRightMotor.getSelectedSensorPosition(0) / ticksPerInch);
		return total / 2.0;
  }

  public double getDistance() {
		return (getRawDistance() - startDistance);
	}
  
  protected static double applyDeadband(double value, double deadband) {
		if (Math.abs(value) > deadband) {
			if (value > 0.0) {
				return (value - deadband) / (1.0 - deadband);
			} else {
				return (value + deadband) / (1.0 - deadband);
			}
		} else {
			return 0.0;
    }
  }
 
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new DriveTeleop());
  }
}
