/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


public class DriveForward extends Command {
  private double targetDistance;
  private boolean initialized = false;

  public DriveForward(double distance) {
    requires(Robot.drivetrain);
    targetDistance = distance;
    Robot.drivetrain.resetDistance();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    SmartDashboard.putNumber("Target Distance", targetDistance);
    Robot.drivetrain.resetDistance();
		initialized = true;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(targetDistance > 0) {
      Robot.drivetrain.differentialDrive(.3, .3);
    } else {
      Robot.drivetrain.differentialDrive(-.3,-.3);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return initialized && (Math.abs(Robot.drivetrain.getDistance()) > Math.abs(targetDistance));
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrain.differentialDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
