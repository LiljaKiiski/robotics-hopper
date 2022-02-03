// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.HopperSubsystem;

public class HopperComand extends CommandBase {
  public HopperSubsystem hopper;
  private boolean ballInside;

  public HopperComand(HopperSubsystem hopper) {
    this.hopper = hopper;
    ballInside = false;
  
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
    }

    //Ball has left - previous state true, now false
    if (hopper.beam2PreviousState && !hopper.getBreakbeam2()){
      ballInside = false;
    }

    if (ballInside){
      hopper.setMotorSpeed(Constants.MOTOR_SPEED);
    } else {
      hopper.stopMotor();
    }

    //Update states
    hopper.beam1PreviousState = hopper.getBreakbeam1();
    hopper.beam2PreviousState = hopper.getBreakbeam2();
  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
