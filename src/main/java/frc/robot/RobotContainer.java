package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.TraccionCom;
import frc.robot.subsystems.Traccion;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
  private final Traccion rc_Traccion = new Traccion();
  private final TraccionCom rc_TraccionCom = new TraccionCom(rc_Traccion);
  public static XboxController Control0 = new XboxController(0);
  public RobotContainer() {
    configureButtonBindings();
    rc_Traccion.setDefaultCommand(rc_TraccionCom);
  }

  private void configureButtonBindings() {}

  public Command getAutonomousCommand() {
    return rc_TraccionCom;
  }
}
