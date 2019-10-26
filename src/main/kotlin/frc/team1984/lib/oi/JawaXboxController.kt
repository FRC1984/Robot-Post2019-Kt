@file:Suppress("unused")

package frc.team1984.lib.oi

import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj.buttons.JoystickButton
import frc.team1984.lib.util.applyDeadband

/**
 * Custom Xbox controller class with many convenience methods.
 * Extends WPI Xbox controller class.
 *
 * @param port Joystick port
 */
class JawaXboxController(port: Int) : XboxController(port) {
    // Buttons
    val aButton = JoystickButton(this, XboxMap.Button.A.id)
    val bButton = JoystickButton(this, XboxMap.Button.B.id)
    val xButton = JoystickButton(this, XboxMap.Button.X.id)
    val yButton = JoystickButton(this, XboxMap.Button.Y.id)
    val lbButton = JoystickButton(this, XboxMap.Button.LB.id)
    val rbButton = JoystickButton(this, XboxMap.Button.RB.id)
    val startButton = JoystickButton(this, XboxMap.Button.START.id)
    val selectButton = JoystickButton(this, XboxMap.Button.SELECT.id)
    val leftStickButton = JoystickButton(this, XboxMap.Button.LEFT_STICK.id)
    val rightStickButton = JoystickButton(this, XboxMap.Button.RIGHT_STICK.id)
    val lTrigger = JoystickButton(this, XboxMap.Axis.LT.id)
    val rTrigger = JoystickButton(this, XboxMap.Axis.RT.id)

    // D-Pad Buttons
    val upDPad = JoystickPOV(this, XboxMap.DPad.UP)
    val upRightDPad = JoystickPOV(this, XboxMap.DPad.UP_RIGHT)
    val rightDPad = JoystickPOV(this, XboxMap.DPad.RIGHT)
    val downRightDPad = JoystickPOV(this, XboxMap.DPad.DOWN_RIGHT)
    val downDPad = JoystickPOV(this, XboxMap.DPad.DOWN)
    val downLeftDPad = JoystickPOV(this, XboxMap.DPad.DOWN_LEFT)
    val leftDPad = JoystickPOV(this, XboxMap.DPad.LEFT)
    val upLeftDPad = JoystickPOV(this, XboxMap.DPad.UP_LEFT)

    fun getAxis(axis: XboxMap.Axis, inverted: Boolean = false) =
            applyDeadband(this.getRawAxis(axis.id) * if (inverted) -1 else 1, XboxMap.DEAD_BAND)

    //Axis
    val LSX: Double
        get() = this.getRawAxis(XboxMap.Axis.LEFT_X.id)
    val LSY: Double
        get() = this.getRawAxis(XboxMap.Axis.LEFT_Y.id)
    val RSX: Double
        get() = this.getRawAxis(XboxMap.Axis.RIGHT_X.id)
    val RSY: Double
        get() = this.getRawAxis(XboxMap.Axis.RIGHT_Y.id)
}