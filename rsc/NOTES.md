# 22 July 2023

## Plan

1. Check [[INSTALL]] on individual/Team Machines
2. Collaboration (what is in place?)
	1. Setup [GitHub](https://github.com) org
	2. Go over Git presentation
	3. [CI Workflows](https://github.com/edurso/workflows)
3. Project Structure TL;DR
	1. Gradle Tasks
4. Robot Application 
	1. Structure
	2. Reusable Code (y2y)
		1. [My Example](https://github.com/frc-862/lightning)
	3. Build a Few Subsystems
		1. Lambdas
	4. WPILib Tools
		1. Shuffleboard
		2. Glass
		3. [PathPlanner](https://github.com/mjansen4857/pathplanner)
	5. Vision Processing

## Subsystem Development Notes

- Subsystem classes should contain the actuator objects, and all functions to manipulate these actuators
- Command classes should contain tasks on a subsystem/group of subsystem basis, should call actuating functions
- Would recommend abstracting `Robot.java` and `RobotContainer.java` for a easy to use structure you can recycle
- Plan how subsystems should interact with each other - every subsystem can only be doing one thing at a time
	- In a command, if a subsystem only used in a read-only fashion, do not add it as a requirement to the command
- Use NetworkTables
- 