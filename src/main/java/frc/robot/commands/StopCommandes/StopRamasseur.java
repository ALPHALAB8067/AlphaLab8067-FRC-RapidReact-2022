// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.StopCommandes;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Ramasseur;

public class StopRamasseur extends CommandBase {

  private final Ramasseur m_ramasseur;

  public StopRamasseur(Ramasseur ramasseur) {
    m_ramasseur = ramasseur;
    addRequirements(m_ramasseur);
  }

  @Override
  public void initialize() {
    m_ramasseur.stop();
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
