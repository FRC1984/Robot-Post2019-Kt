package frc.team1984.robot.hatchgrabber

import edu.wpi.first.wpilibj.Solenoid
import frc.team1984.lib.Jawasystem
import frc.team1984.robot.RobotMap

object HatchGrabber : Jawasystem() {

    private var solenoid = Solenoid(RobotMap.HATCH_SOLENOID)
    var extended = true
        set(field) {
            field = field
            extended = field
            solenoid.set(extended)
        }

    init {
        reset()
        defaultCommand = GrabHatchCmd()
    }

    override fun reset() {
        extended = true
    }
}