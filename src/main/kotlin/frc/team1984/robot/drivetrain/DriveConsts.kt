package frc.team1984.robot.drivetrain

import frc.team1984.lib.motion.util.DTVals
import frc.team1984.lib.motion.util.PIDVAVals
import frc.team1984.lib.motion.util.PIDVals

object DriveConsts {
    const val WHEEL_RADIUS = 3.0 / 12.0 // Inches
    const val TICKS_PER_REV = 4096 // CTRE MagEncoder Ticks/Rev

    const val kMaxVel = 10.0
    const val kMaxAccel = kMaxVel /2
    const val kMaxJerk = 120.0

    var quickTurnThreshold = 0.15 // Speed required for Curvature quickTurn.

    val kPIDVAPF = PIDVAVals(
            kP = 0.3,
            kI = 0.0,
            kD = 0.0,
            kV = 1 / kMaxVel,
            kA = 0.0
    )

    val kPIDVals = PIDVals(
            kP = 0.3,
            kI = 0.0,
            kD = 0.0
    )

    val kDTVals = DTVals(
            wheelRad = WHEEL_RADIUS,
            encTickPerRev = TICKS_PER_REV
    )
}