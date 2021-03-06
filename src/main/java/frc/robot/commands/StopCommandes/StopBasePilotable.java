// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.StopCommandes;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BasePilotable;

public class StopBasePilotable extends CommandBase {

  private final BasePilotable m_basePilotable;

  public StopBasePilotable(BasePilotable base) {
    m_basePilotable = base;
    addRequirements(m_basePilotable);
  }

  @Override
  public void initialize() {
    m_basePilotable.stop();
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
