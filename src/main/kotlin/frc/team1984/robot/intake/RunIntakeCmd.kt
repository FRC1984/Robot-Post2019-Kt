package frc.team1984.robot.intake

import edu.wpi.first.wpilibj.command.Command

class RunIntakeCmd : Command() {
    init {
        this.requires(Intake)
        this.isInterruptible = true
    }

    override fun execute() {
        Intake.run()
    }

    override fun isFinished(): Boolean = false

}