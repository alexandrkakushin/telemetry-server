package ru.ak.telemetry.client.backend.scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author a.kakushin
 */
public class OutputReader {

    public static ArrayList<String> getOutput(String command) {
        ArrayList<String> output = new ArrayList<>();        
        try {
            Process process = Runtime.getRuntime().exec(command);
            InputStream stdout = process.getInputStream();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
            String line;
            while ((line = reader.readLine()) != null) {
                output.add(line);
            }
        } catch (IOException ex) {
            System.out.println("Error read output");            
        }
        return output;
    }

    public static String getOutputCommand(String commandText) {
        ArrayList<String> output = OutputReader.getOutput(commandText);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < output.size(); i++) {
            sb.append(output.get(i)).append("\n");
        }

        return sb.toString();
    }
}
