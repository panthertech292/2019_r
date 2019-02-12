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
public class Grabber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static DoubleSolenoid gripper;
  private static DoubleSolenoid roller;

  public Grabber() {
    gripper = new DoubleSolenoid(RobotMap.gripperin, RobotMap.gripperout);
    roller = new DoubleSolenoid(RobotMap.rollerin, RobotMap.rollerout);
  }

  public void closeGripper() {
    gripper.set(Value.kReverse);
  }

  public void openGripper() {
    gripper.set(Value.kForward);
  }

  public void rollerUp() {
    roller.set(Value.kForward);
  }

  public void rollerDown() {
    roller.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
