package frc.team1984.robot.ramp

import edu.wpi.first.wpilibj.command.Command

class RunBeltCmd : Command() {
    init {
        this.requires(Ramp)
        this.isInterruptible = true
    }

    override fun execute() {
        Ramp.runBelt()
    }

    override fun isFinished() = false
    override fun end() = Ramp.stop()
}