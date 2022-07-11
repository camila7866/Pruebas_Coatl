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

  public void Velocity_Control(double x_right, double y_right, double x_left, double y_left){
    double k, k_aux, k_abs;
    if (x_right>=-0.2 && x_right<=0.2 && y_right>=-0.2 && y_right<=0.2){
      if(x_left>=-0.2 && x_left<=0.2 && y_left>=0.2 && y_left<=0.2){
        this.Velocity(0, 0, 0, 0);
      }
      /*
      else {
        k = Math.sqrt((Math.pow(x_left, 2))+(Math.pow(y_left, 2)));
        k_aux = 1-k;
        k_abs = Math.abs(k_aux);
        if (x_left<0){
          if (y_left<0){
            //this.Velocity(-1, -k_abs, -1, -k_abs);
            front_right.set(ControlMode.PercentOutput, -1);
            front_left.set(ControlMode.PercentOutput, -k_abs);
            rear_right.set(ControlMode.PercentOutput, -1);
            rear_left.set(ControlMode.PercentOutput, -k_abs);
          }
          else {
            //this.Velocity(1, k_abs, 1, k_abs);
            front_right.set(ControlMode.PercentOutput, 1);
            front_left.set(ControlMode.PercentOutput, k_abs);
            rear_right.set(ControlMode.PercentOutput, 1);
            rear_left.set(ControlMode.PercentOutput, k_abs);
          }
        }
        else {
          if (y_left<0){
            //this.Velocity(-k_abs, -1, -k_abs, -1);
            front_right.set(ControlMode.PercentOutput, -k_abs);
            front_left.set(ControlMode.PercentOutput, -1);
            rear_right.set(ControlMode.PercentOutput, -k_abs);
            rear_left.set(ControlMode.PercentOutput, -1);
          }
          else {
            //this.Velocity(k_abs, 1, k_abs, 1);
            front_right.set(ControlMode.PercentOutput, k_abs);
            front_left.set(ControlMode.PercentOutput, 1);
            rear_right.set(ControlMode.PercentOutput, k_abs);
            rear_left.set(ControlMode.PercentOutput, 1);
          }
        }
      }
      */
    }
    else {
      k = Math.sqrt((Math.pow(x_right, 2))+(Math.pow(y_right, 2)));
      k_aux = 1-k;
      k_abs = Math.abs(k_aux);
      if (x_right<0){
        if (y_right<0){
          this.Velocity(-1, -k_abs, -1, -k_abs);
        }
        else {
          this.Velocity(1, k_abs, 1, k_abs);
        }
      }
      else {
        if (y_right<0){
          this.Velocity(-k_abs, -1, -k_abs, -1);
        }
        else {
          this.Velocity(k_abs, 1, k_abs, 1);
        }
      }
      //this.Velocity(y_right-x_right, y_right+x_right, y_right+x_right, y_right-x_right);
      /*
      front_right.set(ControlMode.PercentOutput, y_right-x_right);
      front_left.set(ControlMode.PercentOutput, y_right+x_right);
      rear_right.set(ControlMode.PercentOutput, y_right+x_right);
      rear_left.set(ControlMode.PercentOutput, y_right-x_right);
      */
      /*
      double m, m1, m2;
      if (x_right==0){
        m=1;
      }
      else {
        m = y_right/x_right;
      }
      m1 = Math.abs(Math.tan(22.5));
      m2 = Math.abs(Math.tan(67.5));
      if (m>-m1 && m<m1){
        //this.Velocity(-x_right, x_right, x_right, -x_right);
        front_right.set(ControlMode.PercentOutput, -x_right);
        front_left.set(ControlMode.PercentOutput, +x_right);
        rear_right.set(ControlMode.PercentOutput, +x_right);
        rear_left.set(ControlMode.PercentOutput, -x_right);
      }
      else {
        if (m>=-m2 && m<=m2){
          k = Math.abs(Math.sqrt((Math.pow(x_right, 2))+(Math.pow(y_right, 2))));
          if (x_right<0){
            if (y_right<0){
              //this.Velocity(0, -k, -k, 0);
              front_right.set(ControlMode.PercentOutput, 0);
              front_left.set(ControlMode.PercentOutput, -k);
              rear_right.set(ControlMode.PercentOutput, -k);
              rear_left.set(ControlMode.PercentOutput, 0);
            }
            else {
              //this.Velocity(k, 0, 0, k);
              front_right.set(ControlMode.PercentOutput, k);
              front_left.set(ControlMode.PercentOutput, 0);
              rear_right.set(ControlMode.PercentOutput, 0);
              rear_left.set(ControlMode.PercentOutput, k);
            }
          }
          else {
            if (y_right<0){
              //this.Velocity(-k, 0, 0, -k);
              front_right.set(ControlMode.PercentOutput, -k);
              front_left.set(ControlMode.PercentOutput, 0);
              rear_right.set(ControlMode.PercentOutput, 0);
              rear_left.set(ControlMode.PercentOutput, -k);
            }
            else {
              //this.Velocity(0, k, k, 0);
              front_right.set(ControlMode.PercentOutput, 0);
              front_left.set(ControlMode.PercentOutput, k);
              rear_right.set(ControlMode.PercentOutput, k);
              rear_left.set(ControlMode.PercentOutput, 0);
            }
          }
        }
        else {
          //this.Velocity(y_right, y_right, y_right, y_right);
          front_right.set(ControlMode.PercentOutput, y_right);
          front_left.set(ControlMode.PercentOutput, y_right);
          rear_right.set(ControlMode.PercentOutput, y_right);
          rear_left.set(ControlMode.PercentOutput, y_right);
        }
      }
      */
    }
  }
  public void Velocity (double v_front_right, double v_front_left, double v_rear_right, double v_rear_left){
    front_right.set(ControlMode.PercentOutput, v_front_right);
    front_left.set(ControlMode.PercentOutput, v_front_left);
    rear_right.set(ControlMode.PercentOutput, v_rear_right);
    rear_left.set(ControlMode.PercentOutput, v_rear_left);
  }

  @Override
  public void simulationPeriodic() {
  }
}
