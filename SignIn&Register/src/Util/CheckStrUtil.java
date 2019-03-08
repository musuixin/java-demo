package Util;

        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class CheckStrUtil {
    static Pattern p1 = Pattern.compile("\\s*|\\t|\\r|\\n");
    public static String getStringNoBlank(String str) {
        if(str!=null && !"".equals(str)) {
            Matcher m = p1.matcher(str);
            String strNoBlank = m.replaceAll("");
            return strNoBlank;
        }else {
            return str;
        }
    }
}

