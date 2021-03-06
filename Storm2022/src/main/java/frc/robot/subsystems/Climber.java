// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  private PWMTalonSRX climber;
  //private WPI_TalonSRX climber;

  public Climber() {
    // Use addRequirements() here to declare subsystem dependencies.
    climber = new PWMTalonSRX(Constants.climberPort);
    //climber = new WPI_TalonSRX(Constants.climberPort);
  }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
  
    public void up() {
      climber.set(Constants.forwardclimber);
      System.out.println("Climber up");
    }
  
    public void down() {
        climber.set(Constants.backclimber);
        System.out.println("Climber down");
    }
  
    public void stop() {
        climber.set(0);
    }
  
  }