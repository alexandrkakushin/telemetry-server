package ru.ak.telemetry.client.backend.entity;

import org.springframework.stereotype.Component;

/**
 * @author a.kakushin
 */
@Component
public class OperatingSystem {

    private String arch;
    private Type type;
    private String version;

    public OperatingSystem() {
    }

    public OperatingSystem(String arch, Type type, String version) {
        this.arch = arch;
        this.type = type;
        this.version = version;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public enum Type {
        UBUNTU,
        DEBIAN,
        FEDORA,
        CENTOS,
        RHEL,
        MINT,
        ARCH,
        GENTOO,
        ASTRASE,
        ASTRACE,
        ALTLINUX,
        OPENSUSE,
        ORACLE,

        SOLARIS,
        MACOS,

        WINDOWS,

        OTHER;

        public boolean isLinux() {
            return
                    this != WINDOWS
                    && this != SOLARIS
                    && this != MACOS
                    && this != OTHER;
        }
    }

}
