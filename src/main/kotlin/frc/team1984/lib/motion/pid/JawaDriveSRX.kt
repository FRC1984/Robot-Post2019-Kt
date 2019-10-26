package frc.team1984.lib.motion.pid

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import frc.team1984.lib.motion.util.DTVals



class JawaDriveSRX(deviceNumber: Int, dtVals: DTVals) : WPI_TalonSRX(deviceNumber) {

    private var invert = 1 // Only changed if needed

    private val r = dtVals.wheelRad
    private val ticksPerRev = dtVals.encTickPerRev

    var pidId = 0 // Is only set if needed

    fun getRawVal() = getSelectedSensorPosition(pidId) * invert

    fun getRawVel() = getSelectedSensorVelocity(pidId) * invert

    fun getVel(): Double {
        return getRawVel() *
                2 * Math.PI * r / //Wheel Circumference
                (ticksPerRev * 3) // x3 because encoder on motor shaft, not drive shaft. Could change.
    }

    fun getDistance(): Double {
        return getRawVal() *
                2 * Math.PI * r / //Wheel Circumference
                (ticksPerRev * 3) // x3 because encoder on motor shaft, not drive shaft. Could change.

    }

    fun reset() {
        setSelectedSensorPosition(0, pidId, 0)
    }
}