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

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * Add your docs here.
 */
public class Stilts extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static DoubleSolenoid backStilt12;
  private static DoubleSolenoid backStilt8;
  private static DoubleSolenoid frontStilts8;
  private static DoubleSolenoid frontStilts12;
  private static WPI_TalonSRX backWheel;

 
  public Stilts(){
   backStilt12 = new DoubleSolenoid(RobotMap.backStilt12in, RobotMap.backStilt12out);
   backStilt8 = new DoubleSolenoid(RobotMap.backStilt8in, RobotMap.backStilt8out);
   frontStilts12 = new DoubleSolenoid(RobotMap.frontStilts12in, RobotMap.frontStilts12out);
   frontStilts8 = new DoubleSolenoid(RobotMap.frontStilts8in, RobotMap.frontStilts8out);
   backWheel = new WPI_TalonSRX(RobotMap.backWheel);
  }

  public void lowerStiltsLvl3(){
    backStilt12.set(Value.kReverse);
    backStilt8.set(Value.kReverse);
    frontStilts12.set(Value.kReverse);
    frontStilts8.set(Value.kReverse);
  }

  public void lowerStiltsLvl2() {
    backStilt8.set(Value.kReverse);
    frontStilts8.set(Value.kReverse);
  }

  public void raiseFrontStilts(){
    frontStilts12.set(Value.kForward);
    frontStilts8.set(Value.kForward);
  }

  public void raiseBackStilt(){
    backStilt12.set(Value.kForward);
    backStilt8.set(Value.kForward);
  }

  public void runBackWheel(double percent){
		backWheel.set(percent);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
