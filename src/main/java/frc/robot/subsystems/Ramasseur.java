// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Ramasseur extends SubsystemBase {

  private final WPI_TalonSRX m_moteurRamasseurDroite;
  private final WPI_VictorSPX m_moteurRamasseurGauche;
  
  public Ramasseur() {
    m_moteurRamasseurDroite = new WPI_TalonSRX(Constants.PORT_MOTEUR_RAMASSEUR_DROITE);
    m_moteurRamasseurGauche = new WPI_VictorSPX(Constants.PORT_MOTEUR_RAMASSEUR_GAUCHE);

    m_moteurRamasseurGauche.follow(m_moteurRamasseurDroite);

    m_moteurRamasseurDroite.setInverted(InvertType.InvertMotorOutput);
    m_moteurRamasseurGauche.setInverted(InvertType.None);
    
  }

  @Override
  public void periodic() {
    
  }

  public void monterRamasseur(double vitesse) {
    m_moteurRamasseurGauche.set(vitesse);
    m_moteurRamasseurDroite.set(vitesse);
  }

  public void descendreRamasseur(double vitesse) {
    m_moteurRamasseurGauche.set(-vitesse);
    m_moteurRamasseurDroite.set(-vitesse);
  }

  public void stop() {
    m_moteurRamasseurGauche.stopMotor();
    m_moteurRamasseurDroite.stopMotor();
  }

}
