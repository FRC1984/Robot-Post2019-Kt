package frc.team1984.lib.sensors

import edu.wpi.first.wpilibj.Relay
import edu.wpi.first.wpilibj.DigitalOutput
import frc.team1984.lib.Jawasystem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Deprecated("Removed in favor of traditional Subsystem during 2019 PostSeason Rewrite.")
class PressureSwitch(relayPort: Int, switchPort: Int) : Jawasystem() {
    private val comp = Relay(relayPort)
    private val switch = DigitalOutput(switchPort)

    var isEnabled = false
        set(input) {
            field = input
            if(!isEnabled) comp.set(Relay.Value.kOff)
        }

    fun run() { // For testing
            if(!switch.get()) this.comp.set(Relay.Value.kForward) else this.comp.set(Relay.Value.kOff)
    }
/*    fun launch() {
        GlobalScope.launch {
                while(isEnabled) {
                    run()
                }
            delay((Consts.K_DT * 1000).toLong())
        }
    }*/

    override fun reset() {}
//    override fun brownOut() = reset()

}