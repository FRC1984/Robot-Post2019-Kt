package frc.team1984.robot.commandgroups

import edu.wpi.first.wpilibj.command.CommandGroup
import frc.team1984.robot.intake.IntakeOutCmd
import frc.team1984.robot.intake.RunIntakeCmd
import frc.team1984.robot.intake.Intake

class IntakeBallCmd : CommandGroup() {
    init {
        this.addParallel(IntakeOutCmd())
        this.addParallel(RunIntakeCmd())
    }

    override fun isFinished() = Intake.hasBall
    override fun end() = Intake.stop()
}