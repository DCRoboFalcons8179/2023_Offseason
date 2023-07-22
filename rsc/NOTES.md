# 22 July 2023

## Plan

1. Check [[INSTALL]] on individual/Team Machines
2. Collaboration (what is in place?)
	1. Setup [GitHub](https://github.com) org
	2. Go over Git presentation
	3. [CI Workflows](https://github.com/edurso/workflows)
3. Project Structure TL;DR
	1. FRC Control System Presentation
	2. Gradle Tasks
4. Robot Application 
	1. Structure
		1. Go over other control system/software-overview presentations?
	2. Reusable Code (y2y)
		1. [My Example](https://github.com/frc-862/lightning)
		2. Should also do some kind of logging, integrated options often are not sufficient
	3. Build a Few Subsystems
	4. WPILib Tools
		1. Shuffleboard
		2. [PathPlanner](https://github.com/mjansen4857/pathplanner)
		3. Glass
	5. Vision Processing
		1. Why you shouldn't do it on the RIO: [RoboRIO Specs](https://www.ni.com/docs/en-US/bundle/roborio-20-specs/page/specs.html)

## Subsystem Development Notes

- Subsystem classes should contain the actuator objects, and all functions to manipulate these actuators
- Command classes should contain tasks on a subsystem/group of subsystem basis, should call actuating functions
- Would recommend abstracting `Robot.java` and `RobotContainer.java` for a easy to use structure you can recycle
- Plan how subsystems should interact with each other - every subsystem can only be doing one thing at a time
	- In a command, if a subsystem only used in a read-only fashion, do not add it as a requirement to the command
- Use NetworkTables