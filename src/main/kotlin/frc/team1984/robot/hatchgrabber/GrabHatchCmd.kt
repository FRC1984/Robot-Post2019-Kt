package frc.team1984.robot.hatchgrabber

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.hatchgrabber.HatchGrabber.extended

class GrabHatchCmd : Command() {
    init {
        this.requires(HatchGrabber)
    }

    override fun execute() { extended = true }

    override fun isFinished() = false

}