package frc.team1984.robot.drivetrain

import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj.Solenoid
import edu.wpi.first.wpilibj.SpeedControllerGroup
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import frc.team1984.lib.Jawasystem
import frc.team1984.robot.OI
import frc.team1984.robot.RobotMap

object Drivetrain: Jawasystem() {

    private val leftSide = SpeedControllerGroup(CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless),
                                                CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless))
    private val rightSide = SpeedControllerGroup(CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless),
                                                 CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless))
    private val drive = DifferentialDrive(leftSide,
            rightSide)

    private val shifter = Solenoid(RobotMap.SHIFTER_SOLENOID)

    private val dtVals = DriveConsts.kDTVals

    init {
        //TODO: init motorcontrollers properties, Shuffleboard

    }

    override fun initDefaultCommand() {
        //TODO: Shuffleboard chooser for Arcade vs. Curvature :)
        defaultCommand = ArcadeDriveCmd({ OI.Con1.getLSY() }, { OI.Con1.getRSX() })
    }

    override fun reset() {
        stop()
        initDefaultCommand()
        shiftHigh()
        //prolly do something with SPMAXs here later
    }

    fun shiftHigh() = shifter.set(true)
    fun shiftLow() = shifter.set(false)

    fun arcadeDrive(speed: Double, rot: Double) {
        drive.arcadeDrive(speed, rot, false)
    }

    fun curvatureDrive(speed: Double, rot: Double) {
        val isQuickTurn = speed < DriveConsts.quickTurnThreshold
        drive.curvatureDrive(speed, rot, isQuickTurn)
    }

    fun set(l: Double, r: Double) {
        leftSide.set(l)
        rightSide.set(r)
    }

    fun stop() {
        drive.arcadeDrive(0.0, 0.0)
    }
}