// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Individuelles;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BasePilotable;

public class ConduiteArcadeAvecManette extends CommandBase {

  private BasePilotable m_basePilotable;
  private Joystick m_manettePilote;
  
  public ConduiteArcadeAvecManette(BasePilotable base, Joystick manette) {
    m_basePilotable = base;
    m_manettePilote = manette;
    addRequirements(m_basePilotable);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_basePilotable.conduiteArcadeAvecManette(-m_manettePilote.getRawAxis(1), 
    m_manettePilote.getRawAxis(2));
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
