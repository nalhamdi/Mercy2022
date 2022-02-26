// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.AutoBack;

public class ArcadeDrive extends SubsystemBase {
  /** Creates a new ArcadeDrive. */
  private final PWMVictorSPX leftFrontDriveMotor = new PWMVictorSPX(Constants.kLeftMotorFrontPort);
  private final PWMVictorSPX leftRearDriveMotor = new PWMVictorSPX(Constants.kLeftMotorRearPort);
  private final PWMVictorSPX rightFrontDriveMotor = new PWMVictorSPX(Constants.kRightMotorFrontPort);
  private final PWMVictorSPX rightRearDriveMotor = new PWMVictorSPX(Constants.kRightMotorRearPort); 
  private final MotorControllerGroup m_leftMotors =
  new MotorControllerGroup(leftFrontDriveMotor, leftRearDriveMotor);
  private final MotorControllerGroup m_rightMotors =
      new MotorControllerGroup(rightFrontDriveMotor,rightRearDriveMotor);
  private final DifferentialDrive arcadedrive = new DifferentialDrive(m_leftMotors, m_rightMotors);
  private final ADXRS450_Gyro m_gyro = new ADXRS450_Gyro();
  public ArcadeDrive() {
rightFrontDriveMotor.setInverted(true);
rightRearDriveMotor.setInverted(true);

}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadedrive(double x_axis, double y_axis) {
    if(x_axis<.15 && x_axis>-.15) {
              x_axis=0;
          }
          if(y_axis<.15 && x_axis>-.15){
              y_axis=0;
          }
    arcadedrive.tankDrive(y_axis, x_axis, true);
    SmartDashboard.putNumber("Joystick X_axis", x_axis);

    System.out.println("x-axis: " + x_axis);
    System.out.println("y-axis: " + y_axis);

  }

public void forward() {
  arcadedrive.tankDrive(Constants.forwardArcadeDrive, Constants.forwardArcadeDrive, true);
  System.out.println("Driving forward");
}

public void backward() {
    arcadedrive.tankDrive(Constants.backArcadeDrive, Constants.backArcadeDrive, true);
    System.out.println("Driving backwards");
}

public void stop() {
    arcadedrive.tankDrive(0, 0, true);
    System.out.println("STAHP!");
  }
}
