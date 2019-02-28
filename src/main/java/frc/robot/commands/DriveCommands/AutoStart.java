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
    addSequential(new SetArm(Robot.arm.getHatch2height()));
    addSequential(new OpenGripper());
    // these will run in order.

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
