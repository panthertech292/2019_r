/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * Add your docs here.
 */
public class Stilts extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static Solenoid backStilt12;
  private static Solenoid backStilt8;
  private static Solenoid frontStilts8;
  private static Solenoid frontStilts12;
  private static WPI_TalonSRX backWheel;

 
  public Stilts(){
   backStilt12 = new Solenoid(RobotMap.backStilt12);
   backStilt8 = new Solenoid(RobotMap.backStilt8);
   frontStilts12 = new Solenoid(RobotMap.frontStilts12);
   frontStilts8 = new Solenoid(RobotMap.frontStilts8);
   backWheel = new WPI_TalonSRX(RobotMap.backWheel);
  }

  public static void lowerStilts(){
    backStilt12.set(false);
    backStilt8.set(false);
    frontStilts12.set(false);
    frontStilts8.set(false);
  }

  public static void raiseFrontStilts(){
    frontStilts12.set(true);
    frontStilts8.set(true);
  }

  public static void raiseBackStilt(){
    backStilt12.set(true);
    backStilt8.set(true);
  }

  public static void runBackWheel(double percent){
		backWheel.set(percent);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
