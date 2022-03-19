// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class DescendreClimber extends CommandBase {

  private final Climber m_climber;
  
  public DescendreClimber(Climber climber) {
    m_climber = climber;
    addRequirements(m_climber);
  }

  @Override
  public void initialize() {
    m_climber.descendreClimber(0.25);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    m_climber.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
