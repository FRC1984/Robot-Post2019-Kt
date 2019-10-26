package frc.team1984.robot.intake

import edu.wpi.first.wpilibj.command.InstantCommand
import frc.team1984.robot.intake.Intake.extended

class IntakeInCmd : InstantCommand() {

    init {
        this.requires(Intake)
    }

    override fun initialize() { extended = false }
}