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
public class Tower extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static Solenoid tower1;
  private static Solenoid tower2;

  public Tower() {
    tower1 = new Solenoid(RobotMap.tower1);
    tower2 = new Solenoid(RobotMap.tower2);
  }

  public static void tower1Up() {
    tower1.set(true);
  }

  public static void tower2Up() {
    tower2.set(true);
  }

  public static void tower1Down() {
    tower1.set(false);
  }

  public static void tower2Down() {
    tower2.set(false);
  }

  public static boolean getTower1() {
    return tower1.get();
  }

  public static boolean getTower2() {
    return tower2.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
