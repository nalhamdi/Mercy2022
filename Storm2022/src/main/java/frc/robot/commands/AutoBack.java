// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArcadeDrive;

public class AutoBack extends CommandBase {
  /** Creates a new AutoBack. */
  private final ArcadeDrive arcadeDrive;
  public AutoBack(ArcadeDrive arcadeDrive) {
  this.arcadeDrive = arcadeDrive;
  addRequirements(this.arcadeDrive);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    this.arcadeDrive.backward();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.arcadeDrive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
