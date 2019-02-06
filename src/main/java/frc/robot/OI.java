/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ArmCommands.*;
import frc.robot.commands.GrabberCommands.*;
import frc.robot.commands.StiltCommands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  private XboxController driveController;
  private XboxController operController;

  public OI() {
    driveController = new XboxController(RobotMap.driveController);
    operController = new XboxController(RobotMap.operController);

    JoystickButton aButton = new JoystickButton(operController, 1);
    aButton.whenPressed(new LowerStilts());

    JoystickButton bButton = new JoystickButton(operController, 2);
    bButton.whenPressed(new RaiseBackStilt());

    JoystickButton xButton = new JoystickButton(operController, 3);
    xButton.whenPressed(new RaiseFrontStilts());

    JoystickButton leftBumper = new JoystickButton(operController, 5);
    leftBumper.whenPressed(new RollerUp());

    JoystickButton rightBumper = new JoystickButton(operController, 6);
    rightBumper.whenPressed(new RollerDown());


  }

  public double getXSpeed() {
    return -driveController.getX(Hand.kLeft);
  }

  public double getYSpeed() {
    return driveController.getY(Hand.kLeft);
  }

  public double getRotation() {
    return driveController.getX(Hand.kRight);
  }
 
  public double getBackSpeed() {
    return operController.getY(Hand.kLeft);
  }

  public double getArmSpeed() {
    return operController.getY(Hand.kRight);
  }
}
