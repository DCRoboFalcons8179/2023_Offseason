# Installation of FRC Development Utilities

This will guide you through the installation of all utilities needed to get stared with FRC programming.

## 1. WPILib

Latest release is available [here on GitHub](https://github.com/wpilibsuite/allwpilib/releases/latest).

Download and extract/run the respective file for your operating system (note linux users do not run with `sudo`).
Run the installer, and select `Start`.
On the next screen, it will ask you if you want to install everything or only the tools. Select `Everything` and then click `Install for this User`.
Next, WPILib will want you to install VS Code. There are two ways to do this.
1. The easiest way to go about this is to use the "WPI VS Code" which will be installed separately from any existing installation of VS Code (the reason WPI needs a its own installation of VS Code is purely for licensing purposes and has no impact on performance). To use the "WPI VS Code", select "Download for this computer only". Once the installer downloads VS Code, select "Next".
2. If you have an existing installation of VS Code and don't want to install more, you can select "Skip and don't use VS Code (NOT RECOMMENDED)". This will just install the necessary dependencies. After this is finished, you will need to open the VS Code installation you want to use, and install all the `*.vsix` files from `~/wpilib/<year>/vsCodeExtensions/`. Alternatively, if you don't wish to use VS Code, no further action is needed (much if not all of the functionality provided by the WPILib extension is simply wrapped execution of Gradle tasks, so you will just need to make sure you have Gradle installed).
The installer will now install all the necessary dependencies. Once complete, select "Finish".

Note that there should be a directory at `~/wpilib/<year>`. There are a couple of things to notice here.
1. All the documentation lives here, for the specific version of the installation you have. This will not be a big deal until competition, where you are in the pit without internet and need to find something...
2. The JDK (java development kit) was installed here as well. As of WPILib 2023.4.3, they install `openjdk` build `17.0.5`.
3. Take a look in the `tools` directory here. It is 100% worth the time to explore the documentation on these. My personal favorites are as follows:
	- Shuffleboard
	-  Glass
	-  SysId
	-  PathWeaver 
		- this is the WPI version of [PathPlanner](https://github.com/mjansen4857/pathplanner) which has some added benefits

## 2. NI Driver Station

Available only on Windows 10/11.
This tool suite contains the FRC Driver Station and RIO/Radio configuration utilities.

The latest release of this is [here](https://www.ni.com/en-us/support/downloads/drivers/download.frc-game-tools.html#479842).
Simply download, and run the executable installer.

## 3. Vendor Libraries

There are a number of third-party vendors that provide hardware such as motor controllers, and sensors to FRC teams for use in competition. The two biggest players in this market are CTRE (who are most well known for the Talon and Victor motor controllers along with a slew of random sensors) and REV (most notable for the NEO and new control system, although support for the control system components is primarily bundled in the WPI framework, and manual configuration of it is rarely necessary). There are also other vendors, such as Kauai Labs (who make the [navX](https://www.andymark.com/products/navx2-mxp-robotics-navigation-sensor), [software](https://pdocs.kauailabs.com/navx-mxp/software/roborio-libraries/java/)). Although WPILib has some functionality for each of these vendors built in, there is much more functionality available in the vendor's libraries, which can be integrated into a robot program via Gradle (or rather, through WPILib's [GradleRIO tool](https://github.com/wpilibsuite/GradleRIO), which also houses tasks and configurations for deployment to the NI RoboRIO).

### CTR Electronics Phoenix Framework

Download and install the Phoenix Framework Installer [here](https://store.ctr-electronics.com/software/). Note that Phoenix Tuner (the tool for managing CTRE devices) is also available here, as well as the firmware for the CTRE hardware (note that the firmware is installed with the framework, but this is the place to get newer versions).

Note the link to the JSON files at the bottom. These contain pointers to a handful of Maven repositories that have all of the software libraries needed to work with the CTRE products. These will need to be added to each new WPILib robot project.

### REV

The REV Suite has a similar structure. The main REV software products page is [here](https://www.revrobotics.com/software/). The REV hardware client is similar to Phoenix Tuner, and used to manage REV devices. the SPARK MAX firmware is here as well. The JSON files are a couple of clicks away, listed under Java API.

