package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.Traccion;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TraccionCom extends CommandBase {
  private final Traccion aux_Traccion;

  public TraccionCom(Traccion aux1_Traccion) {
    aux_Traccion = aux1_Traccion;
    addRequirements(aux_Traccion);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    aux_Traccion.Velocity_Control(RobotContainer.Control0.getRightX(), RobotContainer.Control0.getRightY(), RobotContainer.Control0.getLeftX(), RobotContainer.Control0.getLeftY());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
