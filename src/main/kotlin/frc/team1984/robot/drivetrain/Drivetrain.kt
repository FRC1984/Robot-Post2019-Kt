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

    private val leftSide = SpeedControllerGroup(CANSparkMax(RobotMap.L1_SPMAX_ID, CANSparkMaxLowLevel.MotorType.kBrushless),
                                                CANSparkMax(RobotMap.L2_SPMAX_ID, CANSparkMaxLowLevel.MotorType.kBrushless))
    private val rightSide = SpeedControllerGroup(CANSparkMax(RobotMap.R1_SPMAX_ID, CANSparkMaxLowLevel.MotorType.kBrushless),
                                                 CANSparkMax(RobotMap.R2_SPMAX_ID, CANSparkMaxLowLevel.MotorType.kBrushless))
    private val drive = DifferentialDrive(leftSide,
                                          rightSide)

    private val shifter = Solenoid(RobotMap.SHIFTER_SOLENOID) // True = High Gear, False = Low Gear :)

    private val dtVals = DriveConsts.kDTVals // For Pathfinder at some point

    init {
        //TODO: init motorcontrollers properties, Shuffleboard

    }

    override fun initDefaultCommand() {
        //TODO: Shuffleboard chooser for Arcade vs. Curvature :)
        defaultCommand = ArcadeDriveCmd({ OI.Con1.LSY }, { OI.Con1.RSX })
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