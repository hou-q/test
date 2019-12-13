package com.example.demo.test;


import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlText {

    public static String SRC = "FirstPage.html";


    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean isMatch = false;
        // 制定验证条件，目前有些新卡会出现类似166开头的，需要适当调整
        String regex1 = "^[1][3,4,5,7,8][0-9]{9}$";
        String regex2 = "^((13[0-9])|(14[579])|(15([0-3,5-9]))|(16[6])|(17[0135678])|(18[0-9]|19[89]))\\d{8}$";

        p = Pattern.compile(regex2);
        m = p.matcher(str);
        isMatch = m.matches();
        return isMatch;
    }


    public static void main(String[] args) throws IOException {

        // 爬取网页写进txt
        InputStream is2 = UrlCrawBoke.doGet("https://zh.58.com/");
        String pageStr = UrlCrawBoke.inputStreamToString(is2, "UTF-8");
        is2.close();
        FileWriter is1 = new FileWriter("before.txt");
        is1.write(pageStr); // 可以用 write("666")
        is1.close();

        // 正则提取：从html中提取纯文本
        String after = Html2Text(pageStr.toString());


        Pattern p1 = Pattern.compile("1\\d{10}");
        Matcher m1 = p1.matcher(pageStr.toString());
        Set<String> set = new HashSet<>();
        // 通过Matcher类的group方法和find方法来进行查找和匹配
        while (m1.find()) {
            String value = m1.group();
            if(isMobile(value)) {
                set.add(value);
            }

        }
        System.out.println("seeeeeeeeet:"+set);


        FileWriter is = new FileWriter("after.txt");
        is.write(after); // 可以用 write("666")
        is.close();
        System.out.println("after:" + after);

    }

    // 从html中提取纯文本
    public static String Html2Text(String inputString) {
        String htmlStr = inputString; // 含html标签的字符串
        String textStr = "";
        java.util.regex.Pattern p_script;
        java.util.regex.Matcher m_script;
        java.util.regex.Pattern p_style;
        java.util.regex.Matcher m_style;
        java.util.regex.Pattern p_html;
        java.util.regex.Matcher m_html;
        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
            String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); // 过滤script标签
            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); // 过滤style标签
            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); // 过滤html标签
            textStr = htmlStr;
        } catch (Exception e) {
            System.err.println("Html2Text: " + e.getMessage());
        }
        // 剔除空格行
        textStr = textStr.replaceAll("[ ]+", "");
        textStr = textStr.replaceAll("1", "").replaceAll("2", "").replaceAll("3", "").replaceAll("4", "")
                .replaceAll("5", "").replaceAll("6", "").replaceAll("7", "").replaceAll("8", "").replaceAll("9", "")
                .replaceAll("0", "");
        textStr = textStr.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
        textStr = textStr.replaceAll("\t", "");
        textStr = textStr.replaceAll("&nbsp;", "").replace("&gt;", "").replace("&mdash;", "");// 还有什么 查一查
        textStr = textStr.replaceAll("\\\\", "");// 正则表达式中匹配一个反斜杠要用四个反斜杠
        textStr = textStr.replaceAll("\r\n", "");
        textStr = textStr.replaceAll("\n", "");
        return textStr;// 返回文本字符串
    }
}

class UrlCrawBoke {

    public static InputStream doGet(String urlstr) throws IOException {
        URL url = new URL(urlstr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        InputStream inputStream = conn.getInputStream();
        return inputStream;
    }

    public static String inputStreamToString(InputStream is, String charset) throws IOException {
        byte[] bytes = new byte[1024];
        int byteLength = 0;
        StringBuffer sb = new StringBuffer();
        while ((byteLength = is.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, byteLength, charset));
        }
        return sb.toString();
    }
}

