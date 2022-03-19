// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.StopCommandes;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class StopClimber extends CommandBase {

  private final Climber m_climber;

  public StopClimber() {
    m_climber = new Climber();
    addRequirements(m_climber);
  }

  @Override
  public void initialize() {
    m_climber.stop();
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
