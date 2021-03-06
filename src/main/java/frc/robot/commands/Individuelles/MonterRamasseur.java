// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Individuelles;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Ramasseur;

public class MonterRamasseur extends CommandBase {
  private final Ramasseur m_ramasseur;

  public MonterRamasseur(Ramasseur ramasseur) {
    m_ramasseur = ramasseur;
    addRequirements(ramasseur);
  }

  @Override
  public void initialize() {
    m_ramasseur.monterRamasseur(0.35);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    m_ramasseur.stop();
  }

  @Override
  public boolean isFinished() {
    return m_ramasseur.limiteMonterRamasseur();
  }
}
