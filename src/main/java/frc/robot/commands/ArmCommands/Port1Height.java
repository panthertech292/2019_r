/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class Port1Height extends Command {
  private boolean goDown = false;
  public Port1Height() {
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.arm.releaseBrake();
    if (Robot.arm.getHeight() > Robot.arm.getPort1height()) {
      goDown = true;
    } else {
      goDown = false;
    }
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (goDown) {
      Robot.arm.armControl(Robot.arm.downSpeed);
    }
    else {
      Robot.arm.armControl(Robot.arm.upSpeed);
    }
     
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
     if (goDown) {
      return Robot.arm.getHeight() <= Robot.arm.getPort1height();
    } else {
      return Robot.arm.getHeight() >= Robot.arm.getPort1height();
    }
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
   // Robot.arm.engageBrake();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
