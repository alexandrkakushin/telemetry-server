package ru.ak.telemetry.client.backend.entity;

import lombok.Data;

/**
 * @author a.kakushin
 */
@Data
public class FileSystem {

    private String name;
    private String mountOn;
    private Long total;
    private Long used;
    private Long avail;
    private int percentUsed;

    public FileSystem() {}

    public FileSystem(String name, String mountOn, Long total, Long used, Long avail) {
        this();
        
        this.name = name;
        this.mountOn = mountOn;
        this.total = total;
        this.used = used;
        this.avail = avail;
        
        setPercentUsed();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMountOn(String mountOn) {
        this.mountOn = mountOn;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setUsed(Long used) {
        this.used = used;

        this.avail = this.total - this.used;
        this.percentUsed = (int) (this.used / (this.total * 1f) * 100);
    }

    public void setAvail(Long avail) {
        this.avail = avail;

        this.used = this.total - this.avail;
        this.percentUsed = (int) (this.used / (this.total * 1f) * 100);
    }



    private void setPercentUsed() {
        
        this.percentUsed = 100 - (int) (this.avail / this.total) * 100;

    }
}
