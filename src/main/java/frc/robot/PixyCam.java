/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class PixyCam {

    private AnalogInput pixyCam;
    private DigitalInput camera;

    public PixyCam(int x, int y) {
        pixyCam = new AnalogInput(x);
        camera = new DigitalInput(y);
    }

    public double getValue() {
        return pixyCam.getAverageVoltage();
    }

    public boolean camera() {
        return camera.get();
    }

    public void detectTape() {
        SmartDashboard.putNumber("Voltage", getValue());
        if (getValue() >= 0 && getValue() <= 0.825) {
            SmartDashboard.putString("Tape", "Left");
        } else if (getValue() >= 0.826 && getValue() < 1.65) {
            SmartDashboard.putString("Tape", "Left Center");
        } else if (getValue() == 1.65) {
            SmartDashboard.putString("Tape", "Center");
        } else if (getValue() > 1.66 && getValue() <= 2.475) {
            SmartDashboard.putString("Tape", "Right Center");
        } else if (getValue() > 2.476 && getValue() <= 3.3) {
            SmartDashboard.putString("Tape", "Right");
        } else {


            
            SmartDashboard.putString("Tape", "Wrong");
        }
    }

}
