package frc.robot;

public class Constants {

    public Constants() throws Exception {
        throw new Exception("Cannot instantiate Constants class");
    }
    
    public class CAN {

        public CAN() throws Exception {
        throw new Exception("Cannot instantiate Constants/CAN class");
    }

        public static final int ARM_ID = 1;

    }

    public class PID {

        public PID() throws Exception {
            throw new Exception("Cannot instantiate Constants class");
        }

        public static final double ARM_KP = 0d;
        public static final double ARM_KI = 0d;
        public static final double ARM_KD = 0d;
        public static final double ARM_PERIOD = 0d;

    }

    public class UI {

        public UI() throws Exception {
            throw new Exception("Cannot instantiate Constants class");
        }

        public static final int GAMEPAD_PORT = 0;

        public static final int A = 0;
        public static final int B = 0;
        public static final int X = 0;
        public static final int Y = 0;
    }

    public class ARM {

        public ARM() throws Exception {
            throw new Exception("Cannot instantiate Constants class");
        }

        public static final double HIGH_TGT = 42d;
        public static final double DEFAULT_SETPOINT = 0d;

    }

}
