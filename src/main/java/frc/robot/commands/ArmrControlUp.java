// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.SpeedConstants;
import frc.robot.subsystems.armSubsystem;

public class ArmrControlUp extends CommandBase {
  /** Creates a new armrControl. */
  //private armSubsystem a_armUP = new armSubsystem();
  private final armSubsystem a_armUP;

  public ArmrControlUp(armSubsystem armSub) {
    a_armUP = armSub;
    addRequirements(a_armUP);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("setting arm speed to ");
    System.out.println(SpeedConstants.aArmSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    a_armUP.intakeUp();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("arm is up");
   a_armUP.intakeArmStop();

  

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
   return a_armUP.getstatusUp() == false;
  }

}
