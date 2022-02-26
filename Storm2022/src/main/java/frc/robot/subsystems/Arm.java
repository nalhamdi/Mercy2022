// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {

  private PWMVictorSPX arm;
  /** Creates a new Arm. */
  public Arm() {
    arm = new PWMVictorSPX(Constants.armPort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void forward() {
    arm.set(Constants.forwardarm);
    System.out.println("Arm forward");
  }

  public void backward() {
      arm.set(Constants.backarm);
      System.out.println("Arm backward");
  }

  public void stop() {
      arm.set(0);
  }

}
