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
  
  private final WPI_TalonSRX moteurGauche1;
  private final WPI_VictorSPX moteurGauche2;
  private final WPI_TalonSRX moteurDroite1;
  private final WPI_VictorSPX moteurDroite2;
  
   private static AHRS gyro = new AHRS(SPI.Port.kMXP);

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
    
      SmartDashboard.putNumber("Position actuelle Gyro: ", gyro.getAngle());
    
  }

  public void deplacementAutonome(double vitesseAvantArriere, double vitesseRotation) {
    chassisBasePilotable.arcadeDrive(vitesseAvantArriere, vitesseRotation);
  }

  public void conduiteArcadeAvecManette(double manette_axeLY_AvantArriere, double manette_axeLX_Rotation) {
    chassisBasePilotable.arcadeDrive(manette_axeLY_AvantArriere, manette_axeLX_Rotation);
  }

  //Ajout de conduite avec Tank pour mode autonome
   public void conduiteTankAvecManette( double manette_axeLY_coteGauche, double  manette_axeRX_coteDroite) {
    m_chassisBasePilotable.arcadeDrive(manette_axeLY_coteGauche, manette_axeRX_coteDroite);
  }

  
  
  public void stop() {
    chassisBasePilotable.stopMotor();
  }

}
