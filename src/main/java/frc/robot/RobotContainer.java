// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.Groupes.LancerBalle;
import frc.robot.commands.Individuelles.CommandeAutonome;
import frc.robot.commands.Individuelles.ConduiteArcadeAvecManette;
import frc.robot.subsystems.BasePilotable;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Convoyeur;
import frc.robot.subsystems.Ramasseur;
import frc.robot.subsystems.RamasseurRoues;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  private final BasePilotable m_basePilotable;
  private final ConduiteArcadeAvecManette m_conduiteArcadeAvecManette;
  private final Joystick m_manettePilote;

  private final Convoyeur m_convoyeur;
  private final Shooter m_shooter;
  private final LancerBalle m_lancerBalle;
  private final JoystickButton m_bouton1;

  private final Ramasseur m_ramasseur;
  private final RamasseurRoues m_ramasseurRoues;

  private final Climber m_climber;

  private final CommandeAutonome m_commandeAutonome;

  public RobotContainer() {
    m_basePilotable = new BasePilotable();
    m_manettePilote = new Joystick(Constants.PORT_MANETTE);
    m_conduiteArcadeAvecManette = new ConduiteArcadeAvecManette(m_basePilotable, m_manettePilote);
    m_basePilotable.setDefaultCommand(m_conduiteArcadeAvecManette);

    m_convoyeur = new Convoyeur();
    m_shooter = new Shooter();
    m_lancerBalle = new LancerBalle(m_shooter, m_convoyeur);
    m_bouton1 = new JoystickButton(m_manettePilote, Constants.NUMERO_BOUTON_1);

    m_ramasseur = new Ramasseur();
    
    m_ramasseurRoues = new RamasseurRoues();

    m_climber = new Climber();

    m_commandeAutonome = new CommandeAutonome(m_basePilotable);

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    m_bouton1.whenPressed(m_lancerBalle);
  }

  public Command getAutonomousCommand() {
    return m_commandeAutonome;
  }
}
