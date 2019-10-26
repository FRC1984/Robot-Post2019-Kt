package frc.team1984.robot.drivetrain

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.drivetrain.Drivetrain

class ArcadeDriveCmd(val speedFun: () -> Double, val rotFun: () -> Double) : Command() {
    init {
        this.requires(Drivetrain)
    }
    override fun execute() {
        Drivetrain.arcadeDrive(speedFun(), rotFun())
    }

    override fun isFinished()  = false
    override fun end() = Drivetrain.reset()
}