package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Traccion extends SubsystemBase {
  private final TalonFX rear_left = new TalonFX(1);
  private final TalonFX rear_right = new TalonFX(2);
  private final TalonFX  front_left = new TalonFX(3);
  private final TalonFX front_right = new TalonFX(4);

  public Traccion() {
    front_left.setInverted(true);
    rear_left.setInverted(true);
  
    front_right.setNeutralMode(NeutralMode.Brake);
    front_left.setNeutralMode(NeutralMode.Brake);
    rear_right.setNeutralMode(NeutralMode.Brake);
    rear_left.setNeutralMode(NeutralMode.Brake);
  }
  
  @Override
  public void periodic() {
  }

  public void Drive_Joysticks (double x_r, double y_r, double x_l, double y_l){
    boolean SetZero = x_r>=-0.2 && x_r<=0.2 && y_r>=-0.2 && y_r<=0.2 && x_l>=-0.2 && x_l<=0.2 && y_l>=-0.2 && y_l<=0.2;
    boolean SetJoystickRight = (x_r<-0.2 || x_r>0.2) || (y_r<-0.2 || y_r>0.2);
    boolean SetJoystickLeft = (x_l<-0.2 || x_l>0.2) || (y_l<-0.2 || y_l>0.2);
    double k, k_abs;
    if (SetZero){
      this.Velocity(0, 0, 0, 0);
    }
    if (SetJoystickRight){
      double m, m1, m2;
      if (x_r==0){
        m = 1;
      }
      else {
        m = y_r/x_r;
      }
      m1 = Math.abs(Math.tan(22.5));
      m2 = Math.abs(Math.tan(67.5));
      if (m>-m1 && m<m1){
        this.Velocity(-x_r, x_r, x_r, -x_r);
      }
      else {
        if (m>=-m2 && m<=m2){
          k = Math.abs(Math.sqrt((Math.pow(x_r, 2))+(Math.pow(y_r, 2))));
          if (x_r<0){
            if (y_r<0){
              this.Velocity(0, -k, -k, 0);
            }
            else {
              this.Velocity(k, 0, 0, k);
            }
          }
          else {
            if (y_r<0){
              this.Velocity(-k, 0, 0, -k);
            }
            else {
              this.Velocity(0, k, k, 0);
            }
          }
        }
        else {
          this.Velocity(y_r, y_r, y_r, y_r);
        }
      }
    }
    if (SetJoystickLeft){
      k = Math.sqrt((Math.pow(x_l, 2))+(Math.pow(y_l, 2)));
      k_abs = Math.abs(k);
      if (x_l<0){
        if (y_l<0){
          this.Velocity(-1, -k_abs, -1, -k_abs);
        }
        else {
          this.Velocity(1, k_abs, 1, k_abs);
        }
      }
      else {
        if (y_l<0){
          this.Velocity(-k_abs, -1, -k_abs, -1);
        }
        else {
          this.Velocity(k_abs, 1, k_abs, 1);
        }
      }
    }
  }

  public void Velocity (double v_front_right, double v_front_left, double v_rear_right, double v_rear_left){
    front_right.set(ControlMode.PercentOutput, v_front_right);
    front_left.set(ControlMode.PercentOutput, v_front_left);
    rear_right.set(ControlMode.PercentOutput, v_rear_right);
    rear_left.set(ControlMode.PercentOutput, v_rear_left);
  }

  public void Viborita (){}

  @Override
  public void simulationPeriodic() {
  }
}
