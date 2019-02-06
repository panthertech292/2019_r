/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveTeleop;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  private WPI_TalonSRX frontLeftMotor;
  private WPI_TalonSRX frontRightMotor;
  private WPI_TalonSRX rearLeftMotor;
  private WPI_TalonSRX rearRightMotor;

  private static MecanumDrive drive;

  final static double deadband = 0.1;

  public Drivetrain(){
    frontLeftMotor = new WPI_TalonSRX(RobotMap.frontLeftMotor);
    frontRightMotor = new WPI_TalonSRX(RobotMap.frontRightMotor);
    rearLeftMotor = new WPI_TalonSRX(RobotMap.rearLeftMotor);
    rearRightMotor = new WPI_TalonSRX(RobotMap.rearRightMotor);
    drive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
  }

  public static void mecanumDrive(double ySpeed, double xSpeed, double rotation) {
    drive.driveCartesian(applyDeadband(xSpeed, deadband), applyDeadband(ySpeed, deadband), applyDeadband(rotation, deadband));
  }

  protected static double applyDeadband(double value, double deadband) {{
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
  }
 
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new DriveTeleop());
  }
}
