/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.*;

/**
 * Handles communication with an Arduino connected via USB
 */
public class Arduino extends Subsystem {
  private SerialPort serial;
  private DriverStation ds;
  private boolean connected;

  public Arduino() {
    connected = connect();
    ds = DriverStation.getInstance();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new UpdateArduino());
  }

  /**
   * Updates information going to/from the Arduino
   */
  public void update() {
    if (ds.isDSAttached()) {
      write("c");
    } else {
      write("n");
    }

    if (ds.getAlliance() == DriverStation.Alliance.Blue) {
      write("b");
    } else {
      write("r");
    }

    if (ds.isDisabled()) {
      write("d");
    } else if (ds.isAutonomous()) {
      write("a");
    } else if (ds.isOperatorControl()) {
      write("t");
    } else {
      
    }
  }

  private void write(String s) {
    if (!connected) {
      connected = connect();
    }

    try {
      serial.writeString(s);
    } catch(Exception e) {
      connected = false;
    }
  }

  private boolean connect() {
    try {
      serial = new SerialPort(19200, SerialPort.Port.kUSB1);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}