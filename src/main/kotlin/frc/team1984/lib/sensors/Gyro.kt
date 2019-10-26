package frc.team1984.lib.sensors

import edu.wpi.first.wpilibj.ADXRS450_Gyro

object Gyro : ADXRS450_Gyro() {
    val ang = ((getAngle()%360+360)%360)
}