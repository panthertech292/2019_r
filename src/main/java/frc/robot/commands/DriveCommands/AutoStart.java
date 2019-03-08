/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.DriveCommands;
import  frc.robot.subsystems.*;
import frc.robot.Robot;
import frc.robot.commands.ArmCommands.*;
import frc.robot.commands.GrabberCommands.*;
import frc.robot.commands.TowerCommands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStart extends CommandGroup {
  /**
   * Add your docs here.
   */
  public AutoStart() {
    addSequential(new TowerStage2());
    addParallel(new OpenGripper());
    addSequential(new SetArm(Robot.arm.getHatch2height()));

    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

  }
}
