/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7067.robot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.usfirst.frc.team7067.robot.EncoderTest;

import edu.wpi.first.wpilibj.PIDSourceType;
/**
 * Add your docs here.
 */
public class PIDHelper {
    
	private double kP, kI, kD;
    private double setPoint, error, prevError, integral, deriv;
    private TalonSRX talon;
    private PIDSourceType type;

	public PIDHelper(double kP, double kI, double kD, double setPoint) {
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.setPoint = setPoint;
		this.error = Double.MAX_VALUE;
		this.prevError = 0;
		this.integral = 0;
		this.deriv = 0;
	}

	public double update(double current, double interval) {
		this.error = this.setPoint - current;
		this.deriv = (this.error - this.prevError) / interval;
		this.integral = (this.error + this.prevError) * interval / 2;
		this.prevError = this.error;
		return this.kP * this.error + this.kI * this.integral + this.kD * this.deriv;
	}
	public double getError(){
		return this.error;
    }
      public PIDSourceType getPIDSourceType() 
    {
		return type;
	}
    public double getEpidVal(){
        if (type.equals(PIDSourceType.kRate))
        return talon.getSelectedSensorVelocity(); 
    return talon.getSelectedSensorPosition();
    }
}

