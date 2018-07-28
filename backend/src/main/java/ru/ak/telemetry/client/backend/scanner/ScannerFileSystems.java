package ru.ak.telemetry.client.backend.scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ak.telemetry.client.backend.entity.FileSystem;
import ru.ak.telemetry.client.backend.entity.OperatingSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author a.kakushin
 */
@Service
public class ScannerFileSystems {

    @Autowired
    OperatingSystem operatingSystem;

    public List<FileSystem> getList() {
        List<FileSystem> list = null;
        if (operatingSystem.getType().isLinux()) {
            list = getLinuxFileSystems();
        }
        return list;
    }

    private List<FileSystem> getLinuxFileSystems() {
        List<FileSystem> list = new ArrayList<>();

        ArrayList<String> output = OutputReader.getOutput("df");
        for (int i = 1; i < output.size(); i++) {
            FileSystem fileSystem = new FileSystem();

            String rowOutput = output.get(i);
            String[] parts;
            StringBuilder sb = new StringBuilder();
            for (int indexSymbol = 0; indexSymbol < rowOutput.length(); indexSymbol++) {
                if (rowOutput.charAt(indexSymbol) == ' ') {
                    if (rowOutput.charAt(indexSymbol - 1) == ' ') {
                        continue;
                    }
                }
                sb.append(rowOutput.charAt(indexSymbol));
            }
            parts = sb.toString().split(" ");

            fileSystem.setName(parts[0]);
            fileSystem.setTotal(Long.parseLong(parts[1]));
            fileSystem.setMountOn(parts[5]);
            fileSystem.setUsed(Long.parseLong(parts[2]));
            list.add(fileSystem);
        }
        return list;
    }

}
