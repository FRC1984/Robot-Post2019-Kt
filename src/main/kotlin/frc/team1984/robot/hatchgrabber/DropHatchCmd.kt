package frc.team1984.robot.hatchgrabber

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.hatchgrabber.HatchGrabber.extended

class DropHatchCmd : Command() {
    init {
        this.requires(HatchGrabber)
    }

    override fun execute() { extended = false }

    override fun isFinished() = false
}