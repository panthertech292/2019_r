/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Arm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static WPI_TalonSRX armMotor1;
  private static WPI_TalonSRX armMotor2;
  private static SpeedControllerGroup armMotors;
  private static Solenoid brake;


  public Arm() {
    armMotor1 = new WPI_TalonSRX(RobotMap.armMotor1);
    armMotor2 = new WPI_TalonSRX(RobotMap.armMotor2);
    armMotors = new SpeedControllerGroup(armMotor1, armMotor2);
    brake = new Solenoid(RobotMap.brake);
  }

  public static void armControl(double percent) {
    armMotors.set(percent);
  }

  public static void engageBrake() {
    brake.set(true);
  }

  public static void releaseBrake() {
    brake.set(false);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
