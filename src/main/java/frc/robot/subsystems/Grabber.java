/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Grabber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static Solenoid gripper;
  private static Solenoid roller;

  public Grabber() {
    gripper = new Solenoid(RobotMap.gripper);
    roller = new Solenoid(RobotMap.roller);
  }

  public static void closeGripper() {
    gripper.set(false);
  }

  public static void openGripper() {
    gripper.set(true);
  }

  public static void rollerUp() {
    roller.set(true);
  }

  public static void rollerDown() {
    roller.set(false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
