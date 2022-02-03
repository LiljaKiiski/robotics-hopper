// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.HopperSubsystem;

public class HopperComand extends CommandBase {
  public HopperSubsystem hopper;
  //Ball is leaving the hopper
  private boolean leaving;

  //Ball is inside the hopper
  private boolean ballInside;

  public HopperComand(HopperSubsystem hopper) {
    this.hopper = hopper;
    ballInside = false;
    leaving = false;

    addRequirements();
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    //Ball entering in
    if (hopper.getBreakbeam1()){
      ballInside = true;
      hopper.

    //Ball leaving hopper
    } if (hopper.getBreakbeam2()){
      leaving = true;

    //Ball is not leaving hopper or has left hopper
    } if (!hopper.getBreakbeam2()){

      //Ball has left hopper
      if (leaving){
        ballInside = false;
        leaving = false;
      }
    }

    //Run motor if ball is entering or leaving
    if (ballInside || leaving){
      hopper.setMotorSpeed(Constants.MOTOR_SPEED);

    //Otherwise no need to run motor
    } else {
      hopper.stopMotor();
    }
  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
