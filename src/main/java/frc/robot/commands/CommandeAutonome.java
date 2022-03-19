// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.BasePilotable;

public class CommandeAutonome extends CommandBase {

  private final BasePilotable m_basePilotable;
  private final Timer timer;
  private boolean finish;
  
  public CommandeAutonome(BasePilotable base) {
    finish = false;
    m_basePilotable = base;
    timer = new Timer();
    addRequirements(m_basePilotable);
  }

  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    while(timer.get() < Constants.AUTO_TEMPS_RECULER) {
      m_basePilotable.deplacementAutonome(Constants.AUTO_VITESSE_RECULER, 0);
    }

    
    finish = true;
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return finish;
  }
}
