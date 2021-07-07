package com.baiyu.utools.readFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;

/**
 * class Name:
 *
 * @author yx
 * @description :
 * @date 2021/6/30
 */
public class LibUtils {

    public void read(String path) throws IOException {
        LineIterator it = FileUtils.lineIterator(new File(path), "UTF-8");
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                // do something with line
            }
        } finally {
            LineIterator.closeQuietly(it);
        }

    }
}
