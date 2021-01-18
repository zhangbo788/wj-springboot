package top.zbawq.utils;

import java.util.Random;

public class StringUtils {
    public static String getRandString(int len) {
        String allChar="abcdefghigklmnopqistuvwxyz";
        StringBuffer string = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i <len ; i++) {
            int i1 = random.nextInt(allChar.length());
            string.append(allChar.charAt(i1));
        }
        return string.toString();
    }


}
