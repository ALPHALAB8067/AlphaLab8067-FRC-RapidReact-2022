// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.StopCommandes;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Convoyeur;

public class StopConvoyeur extends CommandBase {

  private final Convoyeur m_convoyeur;

  public StopConvoyeur(Convoyeur convoyeur) {
    m_convoyeur = new Convoyeur();
    addRequirements(m_convoyeur);
  }

  @Override
  public void initialize() {
    m_convoyeur.stop();
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
