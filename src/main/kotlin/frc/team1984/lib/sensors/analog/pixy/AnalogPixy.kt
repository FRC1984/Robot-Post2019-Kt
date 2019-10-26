package frc.team1984.lib.sensors.analog.pixy

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard.putNumber
import edu.wpi.first.wpilibj.AnalogInput
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard


class Pixy(port: Int) : AnalogInput(port) {
    private var mod: Double = 0.0

    fun get(): Double {
        var value = value.toDouble()
        if (value > mod)
            value -= mod
        else
            value = 1300.0
        return value

    }

    fun displayOnDashboard() {
//        Shuffleboard.
    }


}