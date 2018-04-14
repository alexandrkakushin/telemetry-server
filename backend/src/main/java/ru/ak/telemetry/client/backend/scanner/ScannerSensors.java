package ru.ak.telemetry.client.backend.scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ak.telemetry.client.backend.entity.OperatingSystem;
import ru.ak.telemetry.client.backend.entity.Sensor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author a.kakushin
 */
@Service
public class ScannerSensors {

    @Autowired
    OperatingSystem operatingSystem;

    public List<Sensor> getList() {
        List<Sensor> sensors = new ArrayList<>();
        if (operatingSystem.getType().isLinux()) {
            sensors = getUbuntuSensors();
        }
        return sensors;
    }

    private List<Sensor> getUbuntuSensors() {
        List<Sensor> sensors = new ArrayList<>();
        String DIR_HWMON = "/sys/class/hwmon";

        for (File fileAdapter : new File(DIR_HWMON).listFiles()) {
            for (String nameSensor : getNameSensors(fileAdapter)) {
                sensors.add(getSensor(fileAdapter, nameSensor));
            }
        }
        return sensors;
    }

    private List<String> getNameSensors(File adapter) {
        List<String> result = new ArrayList<>();
        for (File fileSensor : adapter.listFiles()) {
            String shortFileName = fileSensor.getName();
            if (shortFileName.contains("_label")) {
                String nameSensor = shortFileName.substring(
                        0, shortFileName.indexOf("_label"));
                result.add(nameSensor);
            }
        }
        return result;
    }

    private Sensor getSensor(File adapter, String nameSensor) {
        String absoluteFileSensor = adapter.getAbsoluteFile() + "/" + nameSensor;
        float divider = 1000;

        Sensor sensor = new Sensor();

        // label
        File sensorLabel = new File(absoluteFileSensor + "_label");
        if (sensorLabel.exists()) {
            if (sensorLabel.getName().contains("fan")) {
                //unitValue = Sensor.Unit.RPM;
                divider = 1;

            } else if (sensorLabel.getName().contains("todo_sensor")) {
                //unitValue = Sensor.Unit.VOLT;

            } else if (sensorLabel.getName().contains("temp")) {
                //unitValue = Sensor.Unit.CELSIUS;
            }

            sensor.setName(readFile(sensorLabel));
        }

        // input
        File sensorInput = new File(absoluteFileSensor + "_input");
        if (sensorInput.exists()) {
            try {
                float valueFromFile = Float.parseFloat(readFile(sensorInput));
                sensor.setTopValue(valueFromFile / divider);
            } catch (NumberFormatException | NullPointerException ex) {
                sensor.setTopValue(Float.NaN);
            }
        }

        File sensorMax = new File(absoluteFileSensor + "_max");
        File sensorMin = new File(absoluteFileSensor + "_min");
        File sensorCrit = new File(absoluteFileSensor + "_crit");

        if (sensorMin.exists() && sensorMax.exists()) {
            sensor.setUpperValue(Float.parseFloat(readFile(sensorMax)) / divider);
            sensor.setLowValue(Float.parseFloat(readFile(sensorMin)) / divider);
            sensor.setLowType(Sensor.TypeValue.MIN);
            sensor.setUpperType(Sensor.TypeValue.MAX);

        } else if (sensorMax.exists() && sensorCrit.exists()) {
            sensor.setLowValue(Float.parseFloat(readFile(sensorMax)) / divider);
            sensor.setUpperValue(Float.parseFloat(readFile(sensorCrit)) / divider);
            sensor.setLowType(Sensor.TypeValue.HIGH);
            sensor.setUpperType(Sensor.TypeValue.CRIT);
        }

        return sensor;
    }

    private static String readFile(File sensorFile) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sensorFile));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException ex) {
            System.err.println("Cannot read sensors file");
        }
        return stringBuilder.toString();
    }
}
