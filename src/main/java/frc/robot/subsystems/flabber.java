// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechConstants;

public class flabber extends SubsystemBase {
  /** Creates a new flabber. */
  WPI_VictorSPX a_flabber;
  public flabber() {
    a_flabber = new WPI_VictorSPX(MechConstants.aFlabber);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void flabberRun(double speed){
    a_flabber.set(speed);
  }
  public void flabberStop(){
    a_flabber.set(0);
  }
}
