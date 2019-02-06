/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.robot.commands.*;

/**
 * Add your docs here.
 */
public class Arduino extends Subsystem {
  I2C i2c;
  DriverStation ds;

  public Arduino() {
    i2c = new I2C(I2C.Port.kOnboard, 1);
    ds = DriverStation.getInstance();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new UpdateArduino());
  }

  /**
   * Updates information going to/from the Arduino
   * 
   * @return true on success
   */
  public boolean update() {
    boolean failed = false;
    byte[] data = new byte[1];

    /**
     * Byte 0 bitfield
     * 0x80 DS Connected
     * 0x40 Alliance (red = 0, blue = 1)
     * 0x20 Autonomous
     * 0x10 Teleop
     * 0x08
     * 0x04
     * 0x02
     * 0x01
     */
    data[0] = (byte) 0;
    data[0] |= (ds.isDSAttached() ? 0x80 : 0x00);
    data[0] |= (ds.getAlliance() == DriverStation.Alliance.Blue ? 0x40 : 0x00);
    data[0] |= (ds.isAutonomous() ? 0x20 : 0x00);
    data[0] |= (ds.isOperatorControl() ? 0x10 : 0x00);

    failed |= i2c.writeBulk(data);

    return !failed;
  }
  
  @Override
  public void initSendable(SendableBuilder builder) {
    super.initSendable(builder);
    builder.addBooleanProperty("Connected", () -> !i2c.addressOnly(), null);
  }
}