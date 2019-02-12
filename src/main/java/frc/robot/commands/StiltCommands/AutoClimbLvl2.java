/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.StiltCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.DriveCommands.*;


public class AutoClimbLvl2 extends CommandGroup {
  /**
   * Add your docs here.
   */
  public AutoClimbLvl2() {
    addSequential(new LowerStiltsLvl2());
    addSequential(new StiltWheel(3));
    addSequential(new RaiseFrontStilts());
    addSequential(new DriveForward(20));
    addSequential(new RaiseBackStilt());
    addSequential(new DriveForward(10));
    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
