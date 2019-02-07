/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7067.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public enum RobotMap {
	
	joystick(0),
	roeiJoystick(1),
	RightSideFront(9),
	RightSideBack(8),
	LeftSideFront(6),
	LeftSideBack(7),
	FrontElevatorMotor(4),
	BackElevatorMotor(2),
	Compressor(0);
	
	
	public final int value;
	
	RobotMap(int value){
		this.value = value;
	}
}
