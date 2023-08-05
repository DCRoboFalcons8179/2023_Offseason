package frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
	
	private final WPI_TalonFX motor;
	private double setpoint;
	private boolean dashSetpoint;

	// Define PID controller
	private final PIDController motorController;

	private final ShuffleboardTab armTab;
	private final NetworkTable armNetworkTable;
	private final NetworkTableEntry setpointEntry;
	
	public Arm(boolean dashSetpoint) {

		motor = new WPI_TalonFX(Constants.CAN.ARM_ID);
		setpoint = Constants.ARM.DEFAULT_SETPOINT; // initial setpoint
		motorController = new PIDController(Constants.PID.ARM_KP, Constants.PID.ARM_KI, Constants.PID.ARM_KD, Constants.PID.ARM_PERIOD);
		
		armTab = Shuffleboard.getTab("Arm");
		armNetworkTable = NetworkTableInstance.getDefault().getTable("arm");

		setpointEntry = armNetworkTable.getEntry("setpoint");

		this.dashSetpoint = dashSetpoint;

		CommandScheduler.getInstance().registerSubsystem(this);

		initDashboard();
		initLogs();

	}

	public double getCurrentPos() {
		return this.motor.getSelectedSensorPosition();
		// TODO return desired units
	}

	public double getSetpoint() {
		return this.setpoint;
	}

	public void injectSetpoint(double target) {
		this.setpoint = target;
	}

	@Override
	public void periodic() {

		if (this.dashSetpoint) {
			this.injectSetpoint(this.setpointEntry.getDouble(this.setpoint));
		}

		var current = this.getCurrentPos();

		// Assumes units on current and setpoint are identical
		var output = motorController.calculate(current, this.setpoint);

		motor.set(ControlMode.PercentOutput, output);
	}

	private void initDashboard() {
		this.armTab.addDouble("Arm Encoder (deg)", this::getCurrentPos);
		this.armTab.addDouble("Setpoint", this::getSetpoint);
	}

	private void initLogs() {
		// TODO implement
	}

}
