/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Tower extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static DoubleSolenoid tower1;
  private static DoubleSolenoid tower2;

  public enum TowerStates {
    stage0, stage1, stage2;
  }

  private TowerStates towerState;

  public Tower() {
    tower1 = new DoubleSolenoid(RobotMap.tower1pcm, RobotMap.tower1in, RobotMap.tower1out);
    tower2 = new DoubleSolenoid(RobotMap.tower2pcm, RobotMap.tower2in, RobotMap.tower2out);
    towerState = TowerStates.stage1;
  }

  public void tower1Up() {
    tower1.set(Value.kForward);
  }

  public void tower2Up() {
    tower2.set(Value.kReverse);
  }

  public void tower1Down() {
    tower1.set(Value.kReverse);
  }

  public void tower2Down() {
    tower2.set(Value.kForward);
  }

  public boolean getTower1() {
    return (tower1.get() == Value.kForward);
  }

  public boolean getTower2() {
    return (tower2.get() == Value.kForward);
  }

  public void setTowerStage(TowerStates state) {
    towerState = state;
    if (towerState == TowerStates.stage0) {
      tower1Down();
      tower2Down();
    } else if (towerState == TowerStates.stage1) {
      tower1Up();
      tower2Down();
    } else if (towerState == TowerStates.stage2) {
      tower1Up();
      tower2Up();
    }

  }

  public TowerStates getTowerStage() {
    return towerState;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
