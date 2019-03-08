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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.GrabberCommands.*;
import frc.robot.commands.StiltCommands.*;
import frc.robot.commands.TowerCommands.*;

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
    aButton.whileHeld(new RollerIn());

    JoystickButton bButton = new JoystickButton(operController, 2);
    bButton.whileHeld(new RollerOut());

    JoystickButton leftBumper = new JoystickButton(operController, 5);
    leftBumper.whenPressed(new RollerUp());

    JoystickButton rightBumper = new JoystickButton(operController, 6);
    rightBumper.whenPressed(new RollerDown());

    JoystickButton xButton = new JoystickButton(operController, 3);
    xButton.whenPressed(new OpenGripper());

    JoystickButton yButton = new JoystickButton(operController, 4);
    yButton.whenPressed(new CloseGripper());

    JoystickButton start = new JoystickButton(operController, 8);
    start.whenPressed(new TowerUp());

    JoystickButton back = new JoystickButton(operController, 7);
    back.whenPressed(new TowerDown());

    JoystickButton driveA = new JoystickButton(driveController, 1);
    driveA.whenPressed(new AutoClimbLvl2());

    JoystickButton driveB = new JoystickButton(driveController, 2);
    driveB.whenPressed(new AutoClimbLvl3());

    JoystickButton driveX = new JoystickButton(driveController, 3);
    driveX.whenPressed(new RaiseAllStilts());

    JoystickButton driveY = new JoystickButton(driveController, 4);       //for testing: remove later
    driveY.whenActive(new LowerStiltsLvl2());

  }

  public double getLeftSpeed() {
    return -driveController.getY(Hand.kLeft);
  }

  public double getRightSpeed() {
    return driveController.getY(Hand.kRight);
  }

  public double getArmSpeed() {                 
    return operController.getY(Hand.kRight);
  }

  public double getWheelSpeed() {
    return operController.getY(Hand.kLeft);
  }



}
