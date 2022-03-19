// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Groupes;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.commands.Individuelles.ActiverShooter;
import frc.robot.commands.Individuelles.AvancerConvoyeur;
import frc.robot.subsystems.Convoyeur;
import frc.robot.subsystems.Shooter;

public class LancerBalle extends ParallelRaceGroup {

  private final Shooter m_shooter;
  private final Convoyeur m_convoyeur;
  private final ActiverShooter m_activerShooter;
  private final AvancerConvoyeur m_avancerConvoyeur;
  
  public LancerBalle(Shooter shooter, Convoyeur convoyeur) {

    m_shooter = shooter;
    m_convoyeur = convoyeur;
    m_activerShooter = new ActiverShooter(m_shooter);
    m_avancerConvoyeur = new AvancerConvoyeur(m_convoyeur, m_shooter);
    
    addCommands(m_activerShooter, m_avancerConvoyeur);
  }
}
