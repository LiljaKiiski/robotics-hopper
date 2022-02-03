// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HopperSubsystem extends SubsystemBase {
  private TalonSRX motor;

  //Breakbeams
  private DigitalInput breakbeam1;
  private DigitalInput breakbeam2;
  public boolean beam1PreviousState;
  public boolean beam2PreviousState;

  //Ultrasonic
  private Ultrasonic ultrasonic;

  public HopperSubsystem() {
    motor = new TalonSRX(0);
    breakbeam1 = new DigitalInput(7);
    breakbeam2 = new DigitalInput(8); 
    beam1PreviousState = false;
    beam2PreviousState = false;

    ultrasonic = new Ultrasonic(1, 2);
    Ultrasonic.setAutomaticMode(true);
  }

  public boolean getBreakbeam1(){
    return breakbeam1.get();
  }

  public boolean getBreakbeam2(){
    return breakbeam2.get();
  }

  public double getUltrasonicDistance(){
    return ultrasonic.getRangeInches();
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