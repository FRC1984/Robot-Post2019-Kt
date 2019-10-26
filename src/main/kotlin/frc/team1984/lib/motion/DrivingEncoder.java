package frc.team1984.lib.motion;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DrivingEncoder {
    private WPI_TalonSRX enc;
    private int invert;

    public DrivingEncoder(WPI_TalonSRX srx) {
        enc = srx;
        invert = 1;
    }

    public void setInverted(boolean i) {
        if (i)
            invert = -1;
        else
            invert = 1;
    }

    public int getRawValue() {
        return enc.getSelectedSensorPosition(0) * invert;
    }

    public int getRawVelocity() {
        return enc.getSelectedSensorVelocity(0) * invert;
    }

    public double getVelocity() {
        return ((getRawVelocity() / 3.0) / 4096) * (2 * Math.PI * (3.0 / 12.0));
    }

    /**
     * Reads the encoder on a
     *
     * @return
     */
    public double getDistance() {
        return ((getRawValue() / 3.0) / 4096) * (2 * Math.PI * (3.0 / 12.0)) / 2.5;
    }

    public void resetEncoder() {
        enc.setSelectedSensorPosition(0, 0, 0);
    }

}
