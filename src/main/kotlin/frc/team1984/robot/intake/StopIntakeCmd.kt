package frc.team1984.robot.intake

import edu.wpi.first.wpilibj.command.Command

class StopIntakeCmd : Command() {
    init {
        this.requires(Intake)
    }

    override fun execute() { Intake.stop() }
    override fun isFinished() = false
}