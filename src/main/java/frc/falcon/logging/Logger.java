package frc.falcon.logging;

import java.util.ArrayList;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Logger extends SubsystemBase {

    public class Entry {

        private String name;
        private DoubleSupplier valuePtr;

        public Entry(String name, DoubleSupplier valuePtr) {
            this.name = name;
            this.valuePtr = valuePtr;
        }

        public String getName() {
            return this.name;
        }

        public double getValue() {
            return this.valuePtr.getAsDouble();
        }

        public DoubleSupplier getValuePtr() {
            return this.valuePtr;
        }

    }

    private static Logger instance;

    private ArrayList<Entry> entries;
    private boolean preventNew = false;

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void addDataElement(String name, DoubleSupplier valuePtr) {
        if (!this.preventNew) {
            var entry = new Entry(name, valuePtr);
            this.entries.add(entry);
        } else {
            // TODO print error
        }
    }

    public void preventNewElements() {
        this.preventNew = true;
        initDashboard();
    }

    private Logger() {
        this.entries = new ArrayList<Entry>();
        CommandScheduler.getInstance().registerSubsystem(this);
    }

    @Override
    public void periodic() {
        // TODO write to file
    }

    private void initDashboard() {
        var tab = Shuffleboard.getTab("Logging");
        for (var entry : this.entries) {
            tab.add(entry.getName(), entry.getValuePtr());
        }
    }
    
}
