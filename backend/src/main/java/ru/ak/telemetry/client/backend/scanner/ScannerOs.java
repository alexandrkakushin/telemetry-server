package ru.ak.telemetry.client.backend.scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ak.telemetry.client.backend.entity.OperatingSystem;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

/**
 * @author a.kakushin
 */
@Service
public class ScannerOs {

    @Autowired
    OperatingSystem operatingSystem;

    @PostConstruct
    public void init() {
        initOperatingSystem();
    }

    private void initOperatingSystem() {
        String arch = "x86_64";
        String type = null;
        String version = null;
        OperatingSystem.Type typeOs = null;

        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("linux")) {
            ArrayList<String> output = OutputReader.getOutput("lsb_release -a");
            for (String line : output) {
                if (line.contains("Distributor ID")) {
                    type = line.substring(16);

                } else if (line.contains("Release")) {
                    version = line.substring(9);
                }
            }
            typeOs = OperatingSystem.Type.valueOf(type.toUpperCase());

        } else if (osName.contains("windows")) {
            typeOs = OperatingSystem.Type.WINDOWS;
            version = System.getProperty("os.version");
        }

        operatingSystem.setArch(arch);
        operatingSystem.setType(typeOs);
        operatingSystem.setVersion(version);
    }
}
