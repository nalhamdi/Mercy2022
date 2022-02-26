// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

/** Add your docs here. */
public class JoystickAnalogButton {
    GenericHID m_joystick;
    int m_axisNumber;
    private double THRESHOLD = 0.5;

    public JoystickAnalogButton(GenericHID joystick, int axisNumber) {
        m_joystick =  joystick;
        m_axisNumber = axisNumber;
    }
    public JoystickAnalogButton(GenericHID joystick, int axisNumber, double threshold) {
        m_joystick = joystick;
        m_axisNumber = axisNumber;
        THRESHOLD = threshold;
    }
    public void setThreshold(double threshold){
        THRESHOLD = threshold;
    }
    public double getThreshold(){
      return THRESHOLD;
    }
    
  
    public boolean get() {
      if(THRESHOLD < 0){
        return m_joystick.getRawAxis(m_axisNumber) < THRESHOLD;    //Return true if axis value is less than negative threshold
      } else {
        return m_joystick.getRawAxis(m_axisNumber) > THRESHOLD;    //Return true if axis value is greater than positive threshold
      }
    }
}
