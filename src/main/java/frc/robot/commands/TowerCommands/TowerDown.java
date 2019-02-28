/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.TowerCommands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.Tower.TowerStates;

/**
 * Add your docs here.
 */
public class TowerDown extends InstantCommand {
  /**
   * Add your docs here.
   */
  public TowerDown() {
    super();
    requires(Robot.tower);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    if(Robot.tower.getTowerStage() == TowerStates.stage2) {
      Robot.tower.setTowerStage(TowerStates.stage1);
    } else if(Robot.tower.getTowerStage() == TowerStates.stage1) {
      Robot.tower.setTowerStage(TowerStates.stage0);
    }
  }

}
