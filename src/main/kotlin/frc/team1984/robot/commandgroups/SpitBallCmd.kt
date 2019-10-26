package frc.team1984.robot.commandgroups

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.intake.IntakeInCmd
import frc.team1984.robot.intake.Intake

class SpitBallCmd : Command() {
    init {
        this.isInterruptible = false
    }

    override fun execute() {
        IntakeInCmd() // Intake in to spit - WARNING: PROBABLY SHOULDN'T USE SPITBALL UNTIL BALL IS THROUGH INTAKE!
        Intake.run(true) // let intake know we spitting
    }
    override fun isFinished() = false

}