package com.tests.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ResourceLoader {

    public static InputStream getResources(String path) throws IOException {

        InputStream inputStream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);

        if(Objects.nonNull(inputStream)){

            return inputStream;

        }

        return Files.newInputStream(Path.of(path));

    }

}
