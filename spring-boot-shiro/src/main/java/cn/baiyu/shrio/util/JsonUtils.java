package cn.baiyu.shrio.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import org.springframework.core.io.ClassPathResource;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

/**
 * @auther baiyu
 * @date 2019/10/3
 */
public class JsonUtils {
    public JsonUtils(){}

    public static <T> T readJsonFromClassPath(String path, Type type) throws IOException{
        ClassPathResource resource = new ClassPathResource(path);
        if (resource.exists()){
            return JSON.parseObject(resource.getInputStream(), StandardCharsets.UTF_8, type, new Feature[]{Feature.AutoCloseSource, Feature.AllowComment, Feature.AllowSingleQuotes, Feature.UseBigDecimal});
        }  else {
            throw new IOException();
        }
    }

    public static void writeFile(String filePath, String sets) throws IOException{
        FileWriter fw = new FileWriter(filePath);
        PrintWriter out = new PrintWriter(fw);
        out.write(sets);
        out.println();
        fw.close();
        out.close();
    }
}
