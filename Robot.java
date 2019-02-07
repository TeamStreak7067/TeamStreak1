/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7067.robot;

import org.usfirst.frc.team7067.robot.commands.ArcadeDrive;
import org.usfirst.frc.team7067.robot.subsystems.DriveBase;
import org.usfirst.frc.team7067.robot.commands.MoveBackElevator;
import org.usfirst.frc.team7067.robot.commands.MoveFrontElevator;
import org.usfirst.frc.team7067.robot.commands.PidTest;
import org.usfirst.frc.team7067.robot.subsystems.BackElevator;
import org.usfirst.frc.team7067.robot.subsystems.FrontElevator;
import org.usfirst.frc.team7067.robot.subsystems.Comptest;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.usfirst.frc.team7067.robot.EncoderTest;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI oi;

	public static DriveBase drivebase;
	public static BackElevator backelevator;
	public static FrontElevator frontelevator;
	public static EncoderTest e1;
	public static ArcadeDrive c;
	public static MoveBackElevator moveback;
	public static MoveFrontElevator movefront;
	public static PidTest pidT1;
	public static Comptest comptest;
	public static Compressor comp;
	public TalonSRX talon;
	


	@Override
	public void robotInit() {
		
		talon = new TalonSRX(4);
		drivebase = new DriveBase();
		backelevator = new BackElevator();
		frontelevator = new FrontElevator() ;
		e1= new EncoderTest(talon, 1);
		e1.setPIDSourceType(PIDSourceType.kDisplacement);
		comptest = new Comptest();
		comp = new Compressor(0);
		CameraServer.getInstance().startAutomaticCapture();
		oi = new OI();

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		c = new ArcadeDrive();
		moveback = new MoveBackElevator();
	//	movefront = new MoveFrontElevator();
		pidT1 = new PidTest();
		comp.setClosedLoopControl(true);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		talon.setSelectedSensorPosition(0, 0, 10); 
		talon.getSensorCollection().setQuadraturePosition(0, 10);
		
		}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("e1", e1.pidGet());
		
	}
 
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
