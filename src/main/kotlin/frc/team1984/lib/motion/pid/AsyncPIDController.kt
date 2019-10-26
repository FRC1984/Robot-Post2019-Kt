package frc.team1984.lib.motion.pid

import frc.team1984.lib.motion.util.PIDVals
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AsyncPIDController(private val pidVals: PIDVals) { //PID Value Data Class)
    var isEnabled = false //Is controller enabled
    var maxSpeed: Double? = null //Max speed while increasing
    var minSpeed: Double? = null //Basically max speed while decreasing
    var error = 0.0 //
    var lastError = 0.0 //Error from last run
    var i = 0.0
    var d = 0.0
    var output = 0.0
    var lastOutput = 0.0

    fun getOutput(current: Double, setpoint: Double): Double {
        error = setpoint - current
        i += (error)
        d = (error - lastError)

        output = pidVals.kP * error +
                pidVals.kI * i +
                pidVals.kD * d

        if (maxSpeed != null) {
            if (output > maxSpeed!!) {
                output = maxSpeed!!
            }
        }

        if (minSpeed != null) {
            if (output < minSpeed!!) {
                output = minSpeed!!
            }
        }

        lastError = error
        return output
    }

    fun disable() {
        isEnabled = false
        reset()
    }

    fun reset() {
        error = 0.0
        lastError = 0.0
        i = 0.0
        d = 0.0
    }
}