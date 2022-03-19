// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  private final CANSparkMax m_moteurShooter1;
  //private final CANSparkMax m_moteurShooter2;
  private final RelativeEncoder m_encodeur;
  
  public Shooter() {
    m_moteurShooter1 = new CANSparkMax(Constants.PORT_MOTEUR_SHOOTER1, MotorType.kBrushless);
    //m_moteurShooter2 = new CANSparkMax(Constants.PORT_MOTEUR_SHOOTER2, MotorType.kBrushless);
    //m_moteurShooter2.follow(m_moteurShooter1);
    m_encodeur = m_moteurShooter1.getEncoder();
  }

  @Override
  public void periodic() {}

  public void activerShooter(double vitesse) {
    m_moteurShooter1.set(vitesse);
   // m_moteurShooter2.set(vitesse);
  }

  public double trouverVitesse() {
    return m_encodeur.getVelocity();
   }

  public void stop() {
    m_moteurShooter1.stopMotor();
   // m_moteurShooter2.stopMotor();
  }
}
