package frc.team1984.robot.drivetrain

import edu.wpi.first.wpilibj.command.Command
import frc.team1984.robot.drivetrain.Drivetrain

class CurvatureDriveCmd(val xSpeed: () -> Double, val xRotation: () -> Double) : Command(){

    init {
        this.requires(Drivetrain)
    }
    override fun execute() {
        Drivetrain.curvatureDrive(xSpeed(), xRotation())
    }

    override fun isFinished(): Boolean = false
    override fun end() = Drivetrain.reset()
}