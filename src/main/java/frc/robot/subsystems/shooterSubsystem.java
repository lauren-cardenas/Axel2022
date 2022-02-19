// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechConstants;
import frc.robot.Constants.SpeedConstants;

public class shooterSubsystem extends SubsystemBase {
  /** Creates a new shooterSubsystem. */
  WPI_TalonFX a_shooter;

  public shooterSubsystem() {
    a_shooter = new WPI_TalonFX(MechConstants.aShooterPort1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void shooterRun(double speed){
    System.out.println("setting shooter speed to ");
    System.out.println(speed);
    if(speed == SpeedConstants.aHighShootSpeed){
      System.out.println("Shooting high.");
    } else if(speed == SpeedConstants.aLowShootSpeed){
      System.out.println("Shooting low.");
    } else {
      System.out.println("Shooter off");
    }
    
    a_shooter.set(speed);
  }
}
