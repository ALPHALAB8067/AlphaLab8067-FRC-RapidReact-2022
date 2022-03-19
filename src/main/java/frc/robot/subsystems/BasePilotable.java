// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BasePilotable extends SubsystemBase {
  
  WPI_TalonSRX moteurGauche1;
  WPI_VictorSPX moteurGauche2;
  WPI_TalonSRX moteurDroite1;
  WPI_VictorSPX moteurDroite2;

  private final DifferentialDrive chassisBasePilotable;

  public BasePilotable() {
    moteurGauche1 = new WPI_TalonSRX(Constants.PORT_MOTEUR_GAUCHE1);
    moteurGauche2 = new WPI_VictorSPX(Constants.PORT_MOTEUR_GAUCHE2);
    moteurDroite1 = new WPI_TalonSRX(Constants.PORT_MOTEUR_DROITE1);
    moteurDroite2 = new WPI_VictorSPX(Constants.PORT_MOTEUR_DROITE2);

    moteurDroite1.setInverted(InvertType.InvertMotorOutput);
    moteurDroite2.follow(moteurDroite1);
    moteurDroite2.setInverted(InvertType.FollowMaster);

    moteurGauche1.setInverted(InvertType.None);
    moteurGauche2.follow(moteurGauche1);
    moteurGauche2.setInverted(InvertType.FollowMaster);

    chassisBasePilotable = new DifferentialDrive(moteurGauche1, moteurDroite1);
  }

  @Override
  public void periodic() {
    
  }

  public void deplacementAutonome(double vitesseAvantArriere, double vitesseRotation) {
    chassisBasePilotable.arcadeDrive(vitesseAvantArriere, vitesseRotation);
  }

  public void conduiteArcadeAvecManette(double manette_axeLY_AvantArriere, double manette_axeLX_Rotation) {
    chassisBasePilotable.arcadeDrive(manette_axeLY_AvantArriere, manette_axeLX_Rotation);
  }

  public void stop() {
    chassisBasePilotable.stopMotor();
  }

}
