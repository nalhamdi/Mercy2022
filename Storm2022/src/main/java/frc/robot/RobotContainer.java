// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ClimberDown;
import frc.robot.commands.ClimberUp;
import frc.robot.commands.DownArm;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Intakein;
import frc.robot.commands.Intakeout;
import frc.robot.commands.UpArm;
import frc.robot.subsystems.ArcadeDrive;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController.Button;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //public static Climber climber;

  public static Arm m_arm = new Arm();
  public static UpArm m_uparm = new UpArm(m_arm);
  public static DownArm m_downarm = new DownArm(m_arm);
  public static Intake intake = new Intake();
  public static Intakein intakein = new Intakein(intake);
  public static Intakeout intakeout = new Intakeout(intake);
  public static Climber climber = new Climber();
  public static ClimberUp climberup = new ClimberUp(climber);
  public static ClimberDown climberdown = new ClimberDown(climber);
  public static ArcadeDrive arcadeDrive = new ArcadeDrive();
  XboxController Controller1 = new XboxController(0);
  //public static Intake intake;
  //public static ArcadeDrive arcadeDrive;

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    arcadeDrive.setDefaultCommand(new RunCommand(() -> arcadeDrive.arcadedrive(
      Controller1.getRawAxis(1),
      -Controller1.getRawAxis(0)), arcadeDrive));
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
new JoystickButton(Controller1, Button.kLeftBumper.value)
  .whileHeld(new DownArm(m_arm));
new JoystickButton(Controller1, Button.kRightBumper.value)
  .whileHeld(new UpArm(m_arm));
new JoystickButton(Controller1, Button.kY.value)
  .whileHeld(new ClimberUp(climber));
new JoystickButton(Controller1, Button.kX.value)
  .whileHeld(new ClimberDown(climber));
new JoystickButton(Controller1, Button.kB.value)
  .whileHeld(new Intakeout(intake));
new JoystickButton(Controller1, Button.kA.value)
  .whileHeld(new Intakein(intake));


        // SmartDashboard Buttons
        // SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        // SmartDashboard.putData("ClimberUp", new ClimberUp());
        // SmartDashboard.putData("ClimberDown", new ClimberDown());
        // SmartDashboard.putData("IntakeBall", new IntakeBall());
        // SmartDashboard.putData("OuttakeBall", new OuttakeBall());
        // SmartDashboard.putData("UPARM", new UPARM());
        // SmartDashboard.putData("down arm", new downarm());

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
