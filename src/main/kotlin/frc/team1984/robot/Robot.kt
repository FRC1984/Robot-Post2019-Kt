package frc.team1984.robot

import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.command.Scheduler
import frc.team1984.robot.drivetrain.Drivetrain
import frc.team1984.robot.hatchgrabber.HatchGrabber
import frc.team1984.robot.intake.Intake
import frc.team1984.robot.ramp.Ramp

class Robot : TimedRobot() {
    //TODO: Cameras, Shuffleboard, Maybe some motion stuff to get a simple distance auto made for learning purposes, slowly introduce vision or logging or something motion. LEDs sometime.
    companion object {
        val scheduler = Scheduler.getInstance()
        val driverStation = DriverStation.getInstance()
        val subsystemList = listOf(Drivetrain, Intake, Ramp, HatchGrabber)
        var scoreTarget = ScoreTarget.HIGH
    }

    override fun robotInit() {
        OI
        subsystemList.forEach { it.reset() }
        scoreTarget = ScoreTarget.LOW
    }

    override fun robotPeriodic() {
        scheduler.run()
    }

    override fun autonomousInit() {
        scheduler.removeAll()
    }
}

enum class ScoreTarget {
    HIGH,
    LOW
}