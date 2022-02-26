
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  private PWMVictorSPX intake;
  public Intake() {
    intake = new PWMVictorSPX(Constants.intakePort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void in() {
    intake.set(Constants.forwardintake);
    System.out.println("Intake in");
  }

  public void out() {
      intake.set(Constants.backintake);
      System.out.println("Intake out");
  }

  public void stop() {
      intake.set(0);

}}

