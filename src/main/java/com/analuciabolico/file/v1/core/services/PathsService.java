package com.analuciabolico.file.v1.core.services;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PathsService {
    private final Environment env;

    public PathsService(Environment env) {
        this.env = env;
    }

    public String getDirectory() {
        return env.getProperty("directory.input.name");
    }

    public String getLinux() {
        return env.getProperty("directory.linux.variable");
    }

    public String getWindows() {
        return env.getProperty("directory.windows.variable");
    }

    public String getPathAbsolute() {
        String linux = this.getLinux();
        String windows = this.getWindows();
        String directory = this.getDirectory();

        String os = System.getProperty("os.name");
        String url = os.equalsIgnoreCase("Linux") ? System.getenv(linux) : System.getenv(windows);

        return url + directory;
    }
}
