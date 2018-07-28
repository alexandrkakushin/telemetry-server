package ru.ak.telemetry.client.backend.entity;

import lombok.Data;

/**
 * @author a.kakushin
 */
@Data
public class Cpu {

    private int load;

    public Cpu() {
    }

    public Cpu(int load) {
        this.load = load;
    }
}
