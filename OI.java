/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7067.robot;

import org.usfirst.frc.team7067.robot.commands.MoveFrontElevator;
import org.usfirst.frc.team7067.robot.commands.PidTest;
import org.usfirst.frc.team7067.robot.subsystems.FrontElevator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static final double DeadZone = 0.15;

	Joystick DriveJoystick = new Joystick(RobotMap.joystick.value);
	Joystick RoeiJoystick = new Joystick(RobotMap.roeiJoystick.value);
	JoystickButton autoButton1 = new JoystickButton(DriveJoystick, 4);

	public OI(){
		
		autoButton1.toggleWhenPressed(new PidTest());
	}
	public double getY() {
		if (Math.abs(DriveJoystick.getY()) < DeadZone) 
		{
			return 0.0;
		} 
		else 
		{
			return DriveJoystick.getY();
		}
	}
	
	public double getZ() {
		if (Math.abs(DriveJoystick.getZ()) < DeadZone) 
		{
			return 0.0;
		} 
		else 
		{
			return DriveJoystick.getZ();
		}
	}
	
	public Joystick getJoystick() {
		return DriveJoystick;
	}
	public Joystick getRoeiJoystick(){
		return RoeiJoystick;
	}
}
