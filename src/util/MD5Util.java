package util;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

// from https://blog.csdn.net/junmoxi/article/details/80841555
public class MD5Util {
    //盐，用于混交md5
    private static final String slat = "gjiowejgiowe#@1";
    public static String encrypt(String dataStr) {
        try {
            dataStr = dataStr + slat;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes(StandardCharsets.UTF_8));
            byte[] s = m.digest();
            String result = "";
            for (int i = 0; i < s.length; i++) {
                result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(encrypt("j23iojoigewjojwgeoiu3294tu32oijfewjdsilgjvwljgwe"));
    }
}