// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystem.Arm;

public class RobotContainer {

    // Subsystems
    private static final Arm arm = new Arm(true);

    // Joysticks
    private static final Joystick gamepad = new Joystick(Constants.UI.GAMEPAD_PORT);

    // IMU
    //...

    // Vision System
    //...

    public RobotContainer() {
        configureAutonomousCommands();
        configureButtonBindings();
        configureDefaultCommands();
        configureDashboardCommands();
    }

    private void configureDefaultCommands() {
    }

    private void configureDashboardCommands() {
    }

    private void configureAutonomousCommands() {
    }

    private void configureButtonBindings() {
        (new JoystickButton(gamepad, Constants.UI.A)).onTrue(new InstantCommand(() -> arm.injectSetpoint(Constants.ARM.HIGH_TGT), arm));
    }

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }
}
