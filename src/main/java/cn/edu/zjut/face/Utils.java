package cn.edu.zjut.face;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {

   public static String base64FromFilePath(String path) {
        try {
            InputStream inputStream = new FileInputStream(path);
            if (inputStream == null) {
                return null;
            }
            byte[] bytes = IOUtils.toByteArray(inputStream);
            return Base64.encodeBase64String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
