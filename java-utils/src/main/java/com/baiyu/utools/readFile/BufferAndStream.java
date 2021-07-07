package com.baiyu.utools.readFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * class Name:
 *
 * @author yx
 * @description :
 * @date 2021/6/30
 */
public class BufferAndStream {

    public void read(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
            }
        }

        // or

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
            }
            // line is not visible here.
        }
    }

    /**
     * java 8
     * @param path
     * @throws IOException
     */
    public void readByStream(String path) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(System.out::println);
        }
    }
}
