package com.analuciabolico.file.v1.core.services;

import com.analuciabolico.file.v1.core.enums.TypeFileEnum;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PathsService {
    private final Environment env;

    public PathsService(Environment env) {
        this.env = env;
    }

    private String getDirectoryInput() {
        return env.getProperty("directory.input.name");
    }

    private String getDirectoryOutput() {
        return env.getProperty("directory.output.name");
    }

    private String getLinux() {
        return env.getProperty("directory.linux.variable");
    }

    private String getWindows() {
        return env.getProperty("directory.windows.variable");
    }

    private String getOs() {
        return System.getProperty("os.name");
    }

    public String getPathAbsoluteInput() {
        String os = this.getOs();
        String url = os.equalsIgnoreCase("Linux") ?
                System.getenv(this.getLinux()) :
                System.getenv(this.getWindows());

        return url + this.getDirectoryInput();
    }

    public String getPathAbsoluteOutput() {
        String os = this.getOs();
        String url = os.equalsIgnoreCase("Linux") ?
                System.getenv(this.getLinux()) :
                System.getenv(this.getWindows());

        return url + this.getDirectoryOutput();
    }

    public String formatNameFile(String name, TypeFileEnum typeFileEnum) {
        return typeFileEnum.getKey().equals(TypeFileEnum.DAT.getKey()) ?
                String.format("%s/%s", this.getPathAbsoluteInput(), name) :
                String.format("%s/%s", this.getPathAbsoluteOutput(), name) ;
    }
}
