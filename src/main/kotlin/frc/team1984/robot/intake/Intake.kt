package frc.team1984.robot.intake

import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.Solenoid
import edu.wpi.first.wpilibj.Spark
import frc.team1984.lib.Jawasystem
import frc.team1984.robot.Robot.Companion.scoreTarget
import frc.team1984.robot.RobotMap
import frc.team1984.robot.ScoreTarget
import frc.team1984.robot.ramp.ManualIntakeCmd

object Intake : Jawasystem() {
    val outerSpark = Spark(RobotMap.OUTER_INTAKE_PORT)
    val innerSpark = Spark(RobotMap.INNER_INTAKE_PORT)

    val solenoid = Solenoid(RobotMap.INTAKE_SOLENOID)
    var extended = false
        set(field) {
            field = field
            extended = field
            solenoid.set(field)
        }


    val ballSwitch = DigitalInput(RobotMap.INTAKE_BALL_SWITCH)
    var hasBall = false
        get() {
            field = !ballSwitch.get()
            return field
        }

    init {
        reset()
        defaultCommand = ManualIntakeCmd()
    }

    override fun reset() {
        stop()
        //extended = false - don't do this anymore because unsafe, ball could be crushed. Leave solenoid where the last command told it to be.
    }

    fun run(spitting: Boolean = false) {
        var outerSpeed = -1.0
        var innerSpeed = -1.0
        //Normal Operation
        if (hasBall) {
            //Reverse inner wheels if intake out and target low, or if intake in and target high. Otherwise, inner wheels continue inwards.
            if (extended && scoreTarget == ScoreTarget.LOW) {
                innerSpeed = 1.0
            } else if (!extended && scoreTarget == ScoreTarget.HIGH) {
                innerSpeed = 1.0
            }
        }

        //Spit Ball
        if(spitting) {
            if(hasBall) {
                outerSpeed = -1.0
                innerSpeed = 1.0
            }
        }
        outerSpark.set(outerSpeed)
        innerSpark.set(innerSpeed)
    }

    fun set(outerSpeed: Double, innerSpeed: Double) {
        outerSpark.set(outerSpeed)
        innerSpark.set(innerSpeed)
    }

    fun stop() {
        outerSpark.set(0.0)
        innerSpark.set(0.0)
    }
}