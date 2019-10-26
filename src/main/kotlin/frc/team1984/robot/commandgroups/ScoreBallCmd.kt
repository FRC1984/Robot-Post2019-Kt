package frc.team1984.robot.commandgroups

import edu.wpi.first.wpilibj.command.CommandGroup
import frc.team1984.robot.ramp.RunBeltCmd
import frc.team1984.robot.intake.RunIntakeCmd

class ScoreBallCmd : CommandGroup() {
    init {
        this.addSequential(IntakeBallCmd())
        //Both Run Cmds determine direction themselves :)
        this.addParallel(RunIntakeCmd())
        this.addParallel(RunBeltCmd())
    }
}