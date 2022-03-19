// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Convoyeur extends SubsystemBase {

  private final Spark m_moteurConvoyeur;
  private final DigitalInput m_limitSwitchConvoyeur;
  
  public Convoyeur() {
    m_moteurConvoyeur = new Spark(Constants.PORT_MOTEUR_CONVOYEUR);
    m_limitSwitchConvoyeur = new DigitalInput(0);
  }

  @Override
  public void periodic() {
  }

  public void avancerConvoyeur(double vitesse) {
    m_moteurConvoyeur.set(vitesse);
  }

  public void reculerConvoyeur(double vitesse) {
    m_moteurConvoyeur.set(-vitesse);
  }

  public boolean detecterBallon() {
    return m_limitSwitchConvoyeur.get();
  }

  public void stop() {
    m_moteurConvoyeur.stopMotor();
  }

}
