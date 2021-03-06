// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Individuelles;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RamasseurRoues;

public class TournerRouesSensInverseRamasseur extends CommandBase {
  
  private final RamasseurRoues m_ramasseurRoues;

  public TournerRouesSensInverseRamasseur(RamasseurRoues ramasseurRoues) {
    m_ramasseurRoues = ramasseurRoues;
    addRequirements(m_ramasseurRoues);
  }

  @Override
  public void initialize() {
    m_ramasseurRoues.tournerRouesSensInverseRamasseur(0.5);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    m_ramasseurRoues.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
