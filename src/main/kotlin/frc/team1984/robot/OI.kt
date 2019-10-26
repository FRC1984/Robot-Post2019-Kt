package frc.team1984.robot

import frc.team1984.lib.oi.JawaXboxController
import frc.team1984.robot.commandgroups.ScoreBallCmd
import frc.team1984.robot.commandgroups.SpitBallCmd
import frc.team1984.robot.drivetrain.Drivetrain
import frc.team1984.robot.intake.Intake
import frc.team1984.lib.util.commandify
import frc.team1984.robot.ramp.ManualBeltCmd
import frc.team1984.robot.hatchgrabber.DropHatchCmd
import frc.team1984.robot.intake.StopIntakeCmd

object OI {
    val Con1 = JawaXboxController(0)
    val Con2 = JawaXboxController(1)
    init {
        //Driver 1

        //Shifting
        Con1.lbButton.whenPressed(commandify { Drivetrain.shiftHigh() })
        Con1.rbButton.whenPressed(commandify { Drivetrain.shiftLow() })

        //Intake
        Con1.bButton.whenPressed(ScoreBallCmd())
        //Manual - Intake
        Con1.leftDPad.whenPressed(commandify { Intake.extended = false })
        Con1.rightDPad.whenPressed(commandify { Intake.extended = true })

        //Hatch
        Con1.aButton.toggleWhenPressed(DropHatchCmd()) // Grabber extended by default, only drops when A button toggled.



        //Driver 2

        //Intake
        Con2.aButton.whenActive(StopIntakeCmd())
        Con2.bButton.whenActive(SpitBallCmd()) // WARNING: PROBABLY SHOULDN'T USE SPITBALL WHILE BALL IN INTAKE

        //SCORE TARGET
        Con2.xButton.whenPressed(commandify { Robot.scoreTarget = ScoreTarget.LOW })
        Con2.yButton.whenPressed(commandify { Robot.scoreTarget = ScoreTarget.HIGH })

        //Belt
        Con2.downDPad.whenActive(ManualBeltCmd(1.0)) //Up Chute
        Con2.upDPad.whenActive(ManualBeltCmd(-1.0)) // Down Ramp
    }

}