package frc.team1984.robot.ramp

import edu.wpi.first.wpilibj.Spark
import frc.team1984.lib.Jawasystem
import frc.team1984.robot.RobotMap

object Ramp : Jawasystem() {

    val beltSpark = Spark(RobotMap.BELT_MOTOR_PORT)

    var targetHigh = true // Determines belt direction!

    init {
        reset()
    }

    override fun reset() {
        stop()
    }

    fun runBelt(speed: Double = -1.0) {
        beltSpark.set(if(targetHigh && speed == -1.0) speed else -speed)
    }

    fun stop() {
        beltSpark.set(0.0)
    }
}