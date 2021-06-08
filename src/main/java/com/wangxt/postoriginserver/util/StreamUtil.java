package com.wangxt.postoriginserver.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 *
 * Stream帮助类
 * @author wangxt
 * @date 2021/06/07 16:36
 */
public class StreamUtil {

    /**
     *
     * inputStream to string
     * @author wangxt
     * @date 2021/6/7 16:36
     * @return string
     */
    public static String inputStream2Str(InputStream in) throws Exception {
        int bufferSize = 1024;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[bufferSize];
        int count;
        while ((count = in.read(data, 0, bufferSize)) != -1) {
            outStream.write(data, 0, count);
        }

        return outStream.toString();
    }
}
