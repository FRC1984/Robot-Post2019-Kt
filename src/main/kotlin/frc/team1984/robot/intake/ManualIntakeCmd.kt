package frc.team1984.robot.intake

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.OI
import frc.team1984.robot.intake.Intake

class ManualIntakeCmd : Command() {
    init {
        this.requires(Intake)
        this.isInterruptible = true
    }

    override fun execute() {
        Intake.set(OI.Con2.LSY, OI.Con2.RSY)
    }

    override fun isFinished() = false

    override fun end() { Intake.stop() }
}