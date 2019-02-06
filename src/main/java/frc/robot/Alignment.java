/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Grabber;

/**
 * Add your docs here.
 */
public class Alignment {

   private static PhotoelectricSensor sensorCenter = new PhotoelectricSensor(RobotMap.centerSensor);
   private static PhotoelectricSensor sensorLeft = new PhotoelectricSensor(RobotMap.leftSensor);
   private static PhotoelectricSensor sensorRight = new PhotoelectricSensor(RobotMap.rightSensor);
   

   public static void detectPosition() {
      // If a sensor is missing this entire thing will break

      if (sensorCenter.getValue()) {
         SmartDashboard.putString("Position", "Juuuussstt Right");
         Drivetrain.mecanumDrive(.1, 0, 0);
         Grabber.openGripper();
      } else if (sensorLeft.getValue()) {
         SmartDashboard.putString("Position", "Too far Right");
        Drivetrain.mecanumDrive(0, -.1, 0);
      } else if (sensorRight.getValue()) {
         SmartDashboard.putString("Position", "Too far Left");
        Drivetrain.mecanumDrive(0, .1, 0);
      } else {
         SmartDashboard.putString("Position", "No Data");

      }
   }

 

}

