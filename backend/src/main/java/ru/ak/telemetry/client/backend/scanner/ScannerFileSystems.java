package ru.ak.telemetry.client.backend.scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ak.telemetry.client.backend.entity.FileSystem;
import ru.ak.telemetry.client.backend.entity.OperatingSystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
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

        } else if (operatingSystem.getType() == OperatingSystem.Type.WINDOWS) {
            list = getWindowsFileSystems();
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

    private List<FileSystem> getWindowsFileSystems() {
        List<FileSystem> list = new ArrayList<>();

        for (Path root : FileSystems.getDefault().getRootDirectories()) {

            FileSystem fileSystem = new FileSystem();
            fileSystem.setMountOn(root.toString());

            try {
                FileStore fileStore = Files.getFileStore(root);
                fileSystem.setTotal(fileStore.getTotalSpace());
                fileSystem.setAvail(fileStore.getUsableSpace());
                
                fileSystem.setName(fileStore.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }

            list.add(fileSystem);
        }

        return list;
    }
}
