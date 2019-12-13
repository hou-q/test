package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.pagehelper.util.StringUtil;
import io.swagger.models.auth.In;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Page<T> {

    //当前页
    private Integer pageNum;
    //总记录数
    private Integer total;
    //总页数
    private Integer pages;

    //当前页显示多少条记录
    @JsonIgnore
    private Integer pageSize;

    private List<T> list;

    public Page(List<T> list, Integer pageNum, Integer pageSize) {

        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = list.size();

        //总记录数和每页显示的记录之间是否可以凑成整数（pages）
        boolean full = total % pageSize == 0;

        //分页 == 根据pageSize（每页显示的记录数）计算pages
        if (!full) {
            //如果凑不成整数
            this.pages = total / pageSize + 1;
        } else {
            //如果凑成整数
            this.pages = total / pageSize;
        }

        int fromIndex = 0;
        int toIndex = 0;
        fromIndex = pageNum * pageSize - pageSize;
        if (pageNum == 0) {
            throw new ArithmeticException("第0页无法展示");
        } else if (pageNum > pages) {
            //如果查询的页码数大于总的页码数，list设置为[]
            list = new ArrayList<>();
        } else if (pageNum == pages) {
            //如果查询的当前页等于总页数，直接索引到total处
            toIndex = total;
        } else {
            //如果查询的页码数小于总页数，不用担心切割List的时候toIndex索引会越界，直接等
            toIndex = pageNum * pageSize;
        }

        if (list.size() == 0) {
            this.list = list;
        } else {
            this.list = list.subList(fromIndex, toIndex);
        }

    }

    public Integer getPageNum() {
        return pageNum;
    }


    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }


    public Integer getTotal() {
        return total;
    }


    public void setTotal(Integer total) {
        this.total = total;
    }


    public Integer getPages() {
        return pages;
    }


    public void setPages(Integer pages) {
        this.pages = pages;
    }


    public Integer getPageSize() {
        return pageSize;
    }


    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    public List<T> getList() {
        return list;
    }


    public void setList(List<T> list) {
        this.list = list;
    }


    public static void main(String[] args) {
        Page<Student> student = getString(1, 2);
        String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);

        String pattern_sjhm= "(?<!\\d)(?:(?:1[35]\\d{9})|(?:0[1-9]\\d{1,2}-?\\d{7,8}))(?!\\d)";
        String pattern_zjhm = "\\d{6}(18|19|20)?\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|[xX])";
        String pattern_cphm = "[京,津,渝,沪,冀,晋,辽,吉,黑,苏,浙,皖,闽,赣,鲁,豫,鄂,湘,粤,琼,川,贵,云,陕,秦,甘,陇,青,台,内蒙古,桂,宁,新,藏,澳,军,海,航,警][A-Z][0-9,A-Z]{5}";
        String s="身份证：411522199401274579，邮箱347465858@qq.com 身份证：3****2199302034**5,  错误的号码：15638284509，测试浙H2D357，身份证号：411522199302134509";
        JSONArray sjhm = regexMatches(pattern_sjhm, s);
        JSONArray zjhm = regexMatches(pattern_zjhm, s);
        JSONArray cphm = regexMatches(pattern_cphm, s);
        List<String> mapsjhm=(List)sjhm;
        List<String> mapListJson = (List)zjhm;
        List<String> cphmList = (List)cphm;

        for (int i = 0; i < mapsjhm.size(); i++) {
            System.out.println("sjhm:"+mapsjhm.get(i));
        }
        for (int i = 0; i < mapListJson.size(); i++) {
            System.out.println("zjhm:"+mapListJson.get(i));
        }
        for (int i = 0; i < cphmList.size(); i++) {
            System.out.println("cphm:"+cphmList.get(i));

        }


        String label="小偷,大偷";

        if (StringUtil.isNotEmpty(label)) {
            String[] labels = label.split(",");
            for (String lab : labels) {
                System.out.println("标签:"+lab);
            }
        }

        getStu();



    }






    public static JSONArray regexMatches(String pattern, String str) {
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(str);
        JSONArray jsonArray = new JSONArray();
        while (matcher.find()) {
            jsonArray.add(matcher.group(0));
        }
        return jsonArray;
    }

    /**
     * 提取text中的电话和手机号码
     *
     * @param text
     * @return
     */
    public static String pickUp(String text) {
        Matcher matcher = pattern.matcher(text);
        StringBuffer bf = new StringBuffer(64);
        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
        }
        int len = bf.length();
        if (len > 0) {
            bf.deleteCharAt(len - 1);
        }
        return bf.toString();
    }


    public static void getStu(){
        List<Student> list1 = new ArrayList<>();
        Student student1 = new Student();
        student1.setName("张三");
        student1.setAge("12");
        Student student2 = new Student();
        student2.setName("张三");
        student2.setAge("13");
        Student student3 = new Student();
        student3.setName("王五");
        student3.setAge("14");
        Student student4 = new Student();
        student4.setName("赵六");
        student4.setAge("15");
        list1.add(student1);
        list1.add(student2);
        list1.add(student3);
        list1.add(student4);

        int size=0;
        Map<String, Integer> map=new HashMap<>();
        for (int i = 0; i <list1.size() ; i++) {
            if(null ==map.get(list1.get(i).getName())){
                size=1;
            }else {
                size++;
            }
            map.put(list1.get(i).getName(),size);

        }
        System.out.println(map);

    }



    /**
     * 手机号码
     */
    private static Pattern pattern = Pattern.compile("(?<!\\d)(?:(?:1[35]\\d{9})|(?:0[1-9]\\d{1,2}-?\\d{7,8}))(?!\\d)");

    public static Page<Student> getString(int pageNum, int pageSize) {
        List<Student> list1 = new ArrayList<>();
        Student student1 = new Student();
        student1.setName("张三");
        student1.setAge("12");
        Student student2 = new Student();
        student2.setName("张三");
        student2.setAge("13");
        Student student3 = new Student();
        student3.setName("王五");
        student3.setAge("14");
        Student student4 = new Student();
        student4.setName("赵六");
        student4.setAge("15");
        list1.add(student1);
        list1.add(student2);
        list1.add(student3);
        list1.add(student4);
        Page<Student> stringPage = new Page<>(list1, pageNum, pageSize);
        return stringPage;
    }

    static class Student {
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
