// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Individuelles;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Convoyeur;
import frc.robot.subsystems.Shooter;

public class AvancerConvoyeur extends CommandBase {

  private final Convoyeur m_convoyeur;
  private final Shooter m_shooter;
  private final Timer m_timer;
  private boolean finish;
  
  public AvancerConvoyeur(Convoyeur convoyeur, Shooter shooter) {
    m_convoyeur = convoyeur;
    m_shooter = shooter;
    m_timer = new Timer();
    finish = false;
    addRequirements(m_convoyeur, m_shooter);
  }

  @Override
  public void initialize() { }

  @Override
  public void execute() {
    if (m_shooter.trouverVitesse() >= 100) {
      m_timer.reset();
      m_timer.start();
      while (m_timer.get() < 2) {
        m_convoyeur.avancerConvoyeur(0.25);
      }
      m_timer.stop();
      finish = true;
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_convoyeur.stop();
  }

  @Override
  public boolean isFinished() {
    return finish;
  }
}
