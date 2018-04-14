package ru.ak.telemetry.client.backend.entity;

/**
 * @author a.kakushin
 */
public class FileSystem {

    private String name;
    private String mountOn;
    private Long total;
    private Long used;
    private Long avail;
    private int percentUsed;

    public FileSystem() {
    }

    public FileSystem( String name, String mountOn, Long total, Long used) {
        this.name = name;
        this.mountOn = mountOn;
        this.total = total;
        setUsed(used);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMountOn() {
        return mountOn;
    }

    public void setMountOn(String mountOn) {
        this.mountOn = mountOn;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getUsed() {
        return used;
    }

    public void setUsed(Long used) {
        this.used = used;

        this.avail = this.total - this.used;
        this.percentUsed = (int) (this.used / (this.total * 1f) * 100);
    }

    public Long getAvail() {
        return avail;
    }

    public int getPercentUsed() {
        return percentUsed;
    }
}
