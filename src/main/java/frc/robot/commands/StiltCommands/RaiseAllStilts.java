/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.StiltCommands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class RaiseAllStilts extends InstantCommand {
  /**
   * Add your docs here.
   */
  public RaiseAllStilts() {
    super();
    requires(Robot.stilts);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.stilts.raiseBackStilt();
    Robot.stilts.raiseFrontStilts();
  }

}
