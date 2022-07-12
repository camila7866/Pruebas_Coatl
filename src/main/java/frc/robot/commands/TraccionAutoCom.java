package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Traccion;

public class TraccionAutoCom extends CommandBase {
  private final Traccion AuxTraccion;
  public TraccionAutoCom(Traccion Atraccion) {
    AuxTraccion = Atraccion;
    addRequirements(AuxTraccion);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {

  }
  
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
