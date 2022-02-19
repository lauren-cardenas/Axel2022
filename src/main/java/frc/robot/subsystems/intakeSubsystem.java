// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechConstants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class intakeSubsystem extends SubsystemBase {
  /** Creates a new intakeSubsystem. */
  WPI_VictorSPX a_rollerIntake;

  public intakeSubsystem() {
    a_rollerIntake = new WPI_VictorSPX(MechConstants.aRollerPort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void intakeRun(double speed){
    System.out.println("setting roller speed to ");
    System.out.println(speed);
    a_rollerIntake.set(speed);
  }
}
