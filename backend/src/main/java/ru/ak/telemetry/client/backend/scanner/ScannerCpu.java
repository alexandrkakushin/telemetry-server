package ru.ak.telemetry.client.backend.scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ak.telemetry.client.backend.entity.Cpu;
import ru.ak.telemetry.client.backend.entity.OperatingSystem;

import java.util.ArrayList;

/**
 * @author a.kakushin
 */
@Service
public class ScannerCpu {

    @Autowired
    OperatingSystem operatingSystem;

    public Cpu get() {
        Cpu cpu = null;
        if (operatingSystem.getType().isLinux()) {
            cpu = getLinuxCpu();
        }
        return cpu;
    }

    private Cpu getLinuxCpu() {
        int[] total2 = new int[2];
        int[] idle2 = new int[2];

        for (int i = 0; i < 2; i++) {
            try {
                if (i==1) {
                    Thread.sleep(500);
                }
            } catch (InterruptedException ex) {
                return null;
            }
            ArrayList<String> output = OutputReader.getOutput("cat /proc/stat");
            for (String line : output) {
                if (line.startsWith("cpu")) {
                    // calc load
                    String[] parts = line.split(" ");
                    if (parts.length == 11) {
                        int user    = Integer.parseInt(parts[1]);
                        int nice    = Integer.parseInt(parts[2]);
                        int system  = Integer.parseInt(parts[3]);
                        int idle    = Integer.parseInt(parts[4]);
                        int iowait  = Integer.parseInt(parts[5]);
                        int irq     = Integer.parseInt(parts[6]);
                        int softirq = Integer.parseInt(parts[7]);
                        int steal   = Integer.parseInt(parts[8]);

                        total2[i] = user + nice + system + irq + softirq + steal + idle + iowait;
                        idle2[i] = idle + iowait;
                    }
                    break;
                }
            }
        }

        int totald = total2[1] - total2[0];
        int idled = idle2[1] - idle2[0];

        return new Cpu((int) Math.round((totald - idled) / (1D * totald) * 100));
    }
}
