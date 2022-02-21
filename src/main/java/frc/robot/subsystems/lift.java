// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechConstants;

public class lift extends SubsystemBase {
  /** Creates a new lift. */
  WPI_VictorSPX a_lift;
  public lift() {

  a_lift = new WPI_VictorSPX(MechConstants.aLiftPort);
}

@Override
public void periodic() {
  // This method will be called once per scheduler run
}
public void liftRun(double speed){

  a_lift.set(speed);
}
public void liftStop(){
  a_lift.set(0);
}
}
