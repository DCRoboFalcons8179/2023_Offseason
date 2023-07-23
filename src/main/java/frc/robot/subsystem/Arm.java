package frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
	
	private final WPI_TalonFX motor;
	private double setpoint;

	// Define PID controller
	private final PIDController motorController;

	public Arm() {

		motor = new WPI_TalonFX(Constants.CAN.ARM_ID);
		setpoint = 0; // initial setpoint
		motorController = new PIDController(Constants.PID.ARM_KP, Constants.PID.ARM_KI, Constants.PID.ARM_KD, Constants.PID.ARM_PERIOD);
		
	}

	private double getCurrentPos() {
		// query motor sensor (encoder?) for value
		return 0d;
	}

	public void injectSetpoint(double target) {
		this.setpoint = target;
	}

	@Override
	public void periodic() {
		var current = this.getCurrentPos();
		motor.set(ControlMode.PercentOutput, motorController.calculate(current, setpoint));
	}
}
