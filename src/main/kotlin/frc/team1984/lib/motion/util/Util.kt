package frc.team1984.lib.motion.util

import kotlin.math.abs

/**
 * Data structure for PID Values
 *
 * @param kP Proportional Gain
 * @param kI Integral Gain
 * @param kD Derivative Gain
 */
data class PIDVals(
        var kP: Double = 0.0,
        var kI: Double = 0.0,
        var kD: Double = 0.0
)

/**
 * Data structure for Drivetrain Hardware Specifications
 *
 * @param wheelRad Radius of wheels read by Encoder
 * @param encTickPerRev Encoder Ticks per Revolution
 */

data class DTVals(
        var wheelRad: Double = 0.0,
        var encTickPerRev: Int = 0
)

data class PIDVAVals(
        var kP: Double = 0.0,
        var kI: Double = 0.0,
        var kD: Double = 0.0,
        var kF: Double = 0.0,
        var kV: Double = 0.0,
        var kA: Double = 0.0
)

fun onTarget(target: Double, current: Double, tolerance: Double): Boolean =
        abs(abs(target) - abs(current)) <= tolerance

fun limit(value: Double, limit: Double) = if (abs(value) > abs(limit)) limit else value
