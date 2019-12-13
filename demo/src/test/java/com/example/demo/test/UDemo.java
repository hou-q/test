package com.example.demo.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.*;
import java.net.*;


/**
 * 读取当当网下首页图书的数据，并进行分析
 * 爬取深度为2
 * 爬去数据存储到E:/dangdang_book/目录下，需自行创建
 * /Users/hq/Documents
 */
public class UDemo {
    //提取的数据存放到该目录下
    private static String savepath = "/Users/hq/Documents/aa";
    //等待爬取的url
    private static List<String> allwaiturl = new ArrayList<>();
    //爬取过的url
    private static Set<String> alloverurl = new HashSet<>();
    //记录所有url的深度进行爬取判断
    private static Map<String, Integer> allurldepth = new HashMap<>();
    //爬取得深度
    private static int maxdepth = 2;
    //生命对象，帮助进行线程的等待操作
    private static Object obj = new Object();
    //记录总线程数5条
    private static int MAX_THREAD = 5;
    //记录空闲的线程数
    private static int count = 0;


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

    public static void main(String args[]) {
        //确定爬取的网页地址，此处为当当网首页上的图书分类进去的网页
        //网址为        http://book.dangdang.com/
        //String strurl="http://search.dangdang.com/?key=%BB%FA%D0%B5%B1%ED&act=input";
        //  String strurl = "http://book.dangdang.com/";

         String strurl= "https://zh.58.com/";
        // String strurl = "https://zh.58.com/shangpucz/?PGTID=0d100000-0038-e291-583a-266e00e633cf&ClickID=2";
        //workurl(strurl,1);
        addurl(strurl, 0);
        for (int i = 0; i < MAX_THREAD; i++) {
            new UDemo().new MyThread().start();
        }
    }


    /**
     * 网页数据爬取
     * @param strurl
     * @param depth
     */
    public static void workurl(String strurl, int depth) {
        //判断当前url是否爬取过
        if (!(alloverurl.contains(strurl) || depth > maxdepth)) {
            //检测线程是否执行
            System.out.println("当前执行：" + Thread.currentThread().getName() + " 爬取线程处理爬取：" + strurl);
            //建立url爬取核心对象
            try {
                URL url = new URL(strurl);
                //通过url建立与网页的连接
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("User-Agent",
                        "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
                //通过链接取得网页返回的数据
                InputStream is = conn.getInputStream();

                //一般按行读取网页数据，并进行内容分析
                //因此用BufferedReader和InputStreamReader把字节流转化为字符流的缓冲流
                //进行转换时，需要处理编码格式问题
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                //按行读取并打印
                String line = null;
                //正则表达式的匹配规则提取该网页的链接
                Pattern p = Pattern.compile("<a .*href=.+</a>");
                Pattern p2 = Pattern.compile("1\\d{10}");

                Pattern regex = Pattern.compile("<span class=\"name\">[^<>]*</span>");

                Map<String,String> map=new LinkedHashMap<>();
                //建立一个输出流，用于保存文件,文件名为执行时间，以防重
                // PrintWriter pw = new PrintWriter(new File(savepath + System.currentTimeMillis() + ".txt"));
                List<String> list = new LinkedList<>();
                while ((line = br.readLine()) != null) {

                  //  pw.println(line);
                    Matcher m = p.matcher(line);

                   Matcher m2= p2.matcher(line);

                    Matcher m3=regex.matcher(line);

                    while (m2.find()){
                        String value = m2.group();
                        if (isMobile(value)) {
                            list.add(value);
                        }
                    }

                    while (m3.find()){
                        String value=m3.group();
                       // list.add(value);
                        System.out.println("list:"+value);
                    }


                    while (m.find()) {
                        String href = m.group();
                        //找到超链接地址并截取字符串
                        //有无引号
                        href = href.substring(href.indexOf("href="));
                        if (href.charAt(5) == '\"') {
                            href = href.substring(6);
                        } else {
                            href = href.substring(5);
                        }
                        //截取到引号或者空格或者到">"结束
                        try {
                            href = href.substring(0, href.indexOf("\""));
                        } catch (Exception e) {
                            try {
                                href = href.substring(0, href.indexOf(" "));
                            } catch (Exception e1) {
                                href = href.substring(0, href.indexOf(">"));
                            }
                        }
                        if (href.startsWith("http:") || href.startsWith("https:")) {
                            /*
                            //输出该网页存在的链接
                            //System.out.println(href);
                            //将url地址放到队列中
                            allwaiturl.add(href);
                            allurldepth.put(href,depth+1);
                            */
                            //调用addurl方法
                            addurl(href, depth);
                        }

                    }
                }
                if(list.size()>0) {
                    for (String s : list) {
                        map.put(s,s);
                    }

                }
                System.out.println("map:"+map.values());
              //pw.close();
                br.close();
                is.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //将当前url归列到alloverurl中
            alloverurl.add(strurl);
            System.out.println(strurl + "网页爬取完成，已爬取数量：" + alloverurl.size() + "，剩余爬取数量：" + allwaiturl.size());
        }
        /*
        //用递归的方法继续爬取其他链接
        String nexturl=allwaiturl.get(0);
        allwaiturl.remove(0);
        workurl(nexturl,allurldepth.get(nexturl));
        */
        if (allwaiturl.size() > 0) {
            synchronized (obj) {
                obj.notify();
            }
        } else {
            System.out.println("爬取结束.......");
        }

    }

    /**
     * 将获取的url放入等待队列中，同时判断是否已经放过
     *
     * @param href
     * @param depth
     */
    public static synchronized void addurl(String href, int depth) {
        //将url放到队列中
        allwaiturl.add(href);
        //判断url是否放过
        if (!allurldepth.containsKey(href)) {
            allurldepth.put(href, depth + 1);
        }
    }

    /**
     * 移除爬取完成的url，获取下一个未爬取得url
     *
     * @return
     */
    public static synchronized String geturl() {
        String nexturl = allwaiturl.get(0);
        allwaiturl.remove(0);
        return nexturl;
    }

    /**
     * 线程分配任务
     */
    public class MyThread extends Thread {
        @Override
        public void run() {
            //设定一个死循环，让线程一直存在
            while (true) {
                //判断是否新链接，有则获取
                if (allwaiturl.size() > 0) {
                    //获取url进行处理
                    String url = geturl();
                    //调用workurl方法爬取
                    workurl(url, allurldepth.get(url));
                } else {
                    System.out.println("当前线程准备就绪，等待连接爬取：" + this.getName());
                    count++;
                    //建立一个对象，让线程进入等待状态，即wait（）
                    synchronized (obj) {
                        try {
                            obj.wait();
                        } catch (Exception e) {

                        }
                    }
                    count--;
                }
            }
        }

    }


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

