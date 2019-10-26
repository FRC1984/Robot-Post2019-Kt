package frc.team1984.lib.motion.pid

import frc.team1984.lib.motion.util.PIDVals
import kotlinx.coroutines.*

class JawaPIDController(
        private val pidVals: PIDVals, //PID Value Data Class
        private val K_DT: Double = 0.02, // 50Hz periodic loop
        private val sourceFun: () -> Double,
        private val sinkFun: (Double) -> Unit
) {
    var isEnabled = false //Is controller enabled
    var maxSpeed: Double? = null //Max speed while increasing
    var minSpeed: Double? = null //Basically max speed while decreasing
    var error = 0.0 //
    var lastError = 0.0 //Error from last run
    var setpoint: Double = 0.0
    var i = 0.0
    var d = 0.0
    var output = 0.0
    var lastOutput = 0.0

    /**
     * Enables controller and launches coroutine
     */
    fun launch() = GlobalScope.launch {
            while (isEnabled) {
                error = setpoint - sourceFun()
                i += (error * K_DT)
                d = (error - lastError) / K_DT

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

                sinkFun(output)

                lastError = error

                //Wait 20ms (50Hz, Speed of Periodic Loops)
                delay((K_DT * 1000).toLong())
            }
        }


    fun enable() {
        isEnabled = true
        launch()
    }

    fun disable() {
        isEnabled = false
        reset()
    }

    fun reset() {
        error = 0.0
        lastError = 0.0
        setpoint = 0.0
        i = 0.0
        d = 0.0
    }
}