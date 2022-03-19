// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RamasseurRoues extends SubsystemBase {

  private final WPI_TalonSRX m_moteurRamasseurRoues;

  public RamasseurRoues() {
    m_moteurRamasseurRoues = new WPI_TalonSRX(Constants.PORT_MOTEUR_RAMASSEUR_ROUES);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void tournerRouesRamasseur(double vitesse) {
    m_moteurRamasseurRoues.set(vitesse);
  }

  public void tournerRouesSensInverseRamasseur(double vitesse) {
    m_moteurRamasseurRoues.set(-vitesse);
  }

  public void stop() {
    m_moteurRamasseurRoues.stopMotor();
  }

}
