// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ArmrControlDown;
import frc.robot.commands.ArmrControlUp;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.armSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.OIConstants;
import frc.robot.Constants.SpeedConstants;
// import frc.robot.subsystems.driveSubsystem;
import frc.robot.subsystems.shooterSubsystem;
import frc.robot.subsystems.transitionSubsystem;
import frc.robot.subsystems.intakeSubsystem;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import frc.robot.commands.armrControl;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // private final driveSubsystem a_robotDrive = new driveSubsystem();
  private final shooterSubsystem a_shooter = new shooterSubsystem();
  private final intakeSubsystem a_rollerIntake = new intakeSubsystem();
  private final armSubsystem a_arm = new armSubsystem();
  private final transitionSubsystem a_transition = new transitionSubsystem();

  // private DigitalInput armSwitchDown = new DigitalInput(MechConstants.aArmDownSwitch);
  // private DigitalInput armSwitchUp = new DigitalInput(MechConstants.aArmUpSwitch);
  
  //private final Command a_armrCommand = new armrControl(a_arm, armSwitchUp);
  private final ExampleSubsystem m_exampleSubsystem =  new ExampleSubsystem();
  private final ExampleCommand a_autoCommand = new ExampleCommand(m_exampleSubsystem);


  XboxController a_driverController = new XboxController(OIConstants.aDriverControllerPort);
  XboxController a_operatorController = new XboxController(OIConstants.aOperatorControllerPort);

  // WPI_VictorSPX a_arm = new WPI_VictorSPX(MechConstants.aArmPort);



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    a_robotDrive.setDefaultCommand(
      new RunCommand(() -> a_robotDrive.arcadeDrive(
        a_driverController.getRightTriggerAxis()
           - a_driverController.getLeftTriggerAxis(),
        a_driverController.getLeftX()
      ), a_robotDrive));
  
    //   SmartDashboard.putData(a_robotDrive);
    //   a_robotDrive.displayEncoderValues();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(a_driverController, Button.kRightBumper.value)
    .whenPressed(() -> a_shooter.shooterRun(SpeedConstants.aHighShootSpeed))
    .whenReleased(() -> a_shooter.shooterRun(0.0));

    new JoystickButton(a_driverController, Button.kX.value)
    .whenPressed(() -> a_rollerIntake.intakeRun(SpeedConstants.aRollerSpeed))
    .whenReleased(() -> a_rollerIntake.intakeRun(0.0));

    new JoystickButton(a_driverController, Button.kA.value)
    .whenPressed(new ArmrControlUp(a_arm))
    .whenReleased(() -> a_arm.intakeArmStop());

    new JoystickButton(a_driverController, Button.kB.value)
    .whenPressed(new ArmrControlDown(a_arm))
    .whenReleased(() -> a_arm.intakeArmStop());

    new JoystickButton(a_driverController, Button.kY.value)
    .whenPressed(() -> a_transition.transitionRun(SpeedConstants.aTransitionSpeed))
    .whenReleased(() -> a_transition.transitionStop());

    
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return a_autoCommand;
  }
}