/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.TowerCommands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class TowerStage1 extends InstantCommand {
  /**
   * Add your docs here.
   */
  public TowerStage1() {
    super();
    requires(Robot.tower);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    if(Robot.tower.getTower1() && Robot.tower.getTower2()) {
      Robot.tower.tower1Down();
    } else if (!Robot.tower.getTower1() && !Robot.tower.getTower2()){
      Robot.tower.tower1Up();
    }
  }

}
