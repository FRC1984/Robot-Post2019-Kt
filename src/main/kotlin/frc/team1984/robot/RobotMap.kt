package frc.team1984.robot

object RobotMap {
    //CAN Device IDs
    const val L1_SPMAX_ID = 3
    const val L2_SPMAX_ID = 4
    const val R1_SPMAX_ID = 1
    const val R2_SPMAX_ID = 2

    //PWM
    //INTAKE
    const val OUTER_INTAKE_PORT = 0
    const val INNER_INTAKE_PORT = 1

    //BELT
    const val BELT_MOTOR_PORT = 3

    //MISC - PWM
    const val COMPRESSOR_SPIKE_PORT = 4

    //DIO
    const val INTAKE_BALL_SWITCH = 0
    const val RAMP_BALL_SWITCH = 1
    const val PRESSURE_SWITCH = 2

    //PCM
    const val HATCH_SOLENOID = 7
    const val SHIFTER_SOLENOID = 2
    const val INTAKE_SOLENOID = 1
}