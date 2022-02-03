// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HopperSubsystem extends SubsystemBase {
  private TalonFX motor;
  private DigitalInput breakbeam;

  public HopperSubsystem() {
    motor = new TalonFX(0);
    breakbeam = new DigitalInput(7);
  }

  public boolean getBreakbeam(){
    return breakbeam.get();
  }

  public void setMotorSpeed(double speed){
    motor.set(ControlMode.PercentOutput, speed);
  }

  public void stopMotor(){
    setMotorSpeed(0);
  }

  @Override
  public void periodic() {

  }
}