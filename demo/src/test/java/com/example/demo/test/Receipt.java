package com.example.demo.test;

import com.example.demo.entity.bo.stage.AlarmBO;
import com.github.pagehelper.util.StringUtil;
import org.assertj.core.util.DateUtil;
import sun.swing.StringUIClientPropertyKey;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Receipt {
    //猪肉单价（单位:kg）
    private static final BigDecimal MEAT_PRICE = new BigDecimal("19.98");
    //大米单价（单位:kg）
    private static final BigDecimal RICE_PRICE = new BigDecimal(3.33D);
    //清风卷纸（12包装）单价
    private static final BigDecimal QINGFENG_ROLL_PAPER_PRICE = BigDecimal.valueOf(25D);
    //维达卷纸（20包装）单价
    private static final BigDecimal VINDA_ROLL_PAPER_PRICE = BigDecimal.valueOf(50D);

    public static void main(String[] args) {
        long count = 0;
        String alarmBO="这是同一警情。";
        if (alarmBO.contains("同一警情")) {
            count++;
        }
        System.out.println("count:"+count);
            Date date = new Date();
            System.out.println(date);
            List<String> list = new ArrayList<String>();
            list.add("fsfssss");
            list.add("abc");
            list.add("fsfsdes");
            System.out.println(list.contains("fsfs"));


            String s = "15";
            String aa = "15,2,3";
            String bb = "2,3";
            String cc = "1,2,3";


            List<String> ab = new ArrayList<>();
            String[] a = aa.split(",");
            System.out.println("a:" + Arrays.asList(a));
            String[] b = {"2", "3"};
            String[] c = {"1", "2", "3"};

            int oo = 0;
            System.out.println("ab:" + ab + "ab.size" + ab.size());

            String[] aaa = aa.split(",");
            if (s.equals(aaa)) {
                oo++;
            }

            System.out.println("oo:" + oo);
            long now = System.currentTimeMillis();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String sd = sdf.format(now);
            System.out.println(sd);
            System.out.println("now:" + now);
            //购物卡余额：100
            BigDecimal amount = BigDecimal.valueOf(100D);
            //总价初始化为0
            BigDecimal totalPrice = BigDecimal.ZERO;
            //猪肉净含量
            double weightOfMeat = 2.25D;
            //大米净含量
            double weightOfRice = 24.35D;
            //卷纸数量
            int quantityOfVinda = 1;

            //猪肉总价：44.9550
            BigDecimal meatTotalPrice = MEAT_PRICE.multiply(BigDecimal.valueOf(weightOfMeat)).setScale(2, RoundingMode.HALF_UP);
            //大米总价：84.42
            // 3.33 * 25.35 = 84.4155，通过setScale设置保留的2位小数，并且设置舍入模式为四舍五入
            BigDecimal riceTotalPrice = RICE_PRICE.multiply(BigDecimal.valueOf(weightOfRice)).setScale(2, RoundingMode.HALF_UP);
            //维达卷纸总价：50.00
            BigDecimal vindaRollPaperPrice = VINDA_ROLL_PAPER_PRICE.multiply(BigDecimal.valueOf(quantityOfVinda)).setScale(2, RoundingMode.HALF_UP);

            //通过add（加法）计算总价totalPrice:179.38
            totalPrice = totalPrice.add(meatTotalPrice).add(riceTotalPrice).add(vindaRollPaperPrice);
            //通过subtract（减法）计算差价differencePrice：-79.38
            BigDecimal differencePrice = amount.subtract(totalPrice);
            if (differencePrice.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("请付款：" + differencePrice.abs() + "元，" + "购物卡余额：0元.");
            } else {
                System.out.println("购物卡余额：" + differencePrice + "元.");
            }

            //通过divide（除法）计算一包清风纸的价格，设置采用四舍五入模式保留2位小数，并使用doubleValue方法将结果转化成double类型
            double qingFengSingle = QINGFENG_ROLL_PAPER_PRICE.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP).doubleValue();
            //通过divide（除法）计算一包维达纸的价格，
            double vindaSingle = VINDA_ROLL_PAPER_PRICE.divide(BigDecimal.valueOf(20), 2, RoundingMode.HALF_UP).doubleValue();
            int result = Double.compare(qingFengSingle, vindaSingle);

            if (result < 0) {
                System.out.println("一包清风纸价钱" + qingFengSingle + "元，小于一包维达纸价钱" + vindaSingle + "元。所以购买清风更划算！");
            } else if (result == 0) {
                System.out.println("一包清风纸价钱" + qingFengSingle + "元，等于一包维达纸价钱" + vindaSingle);
            } else {
                System.out.println("一包清风纸价钱" + qingFengSingle + "元，大于一包维达纸价钱" + vindaSingle + "元。所以购买维达更划算！");
            }
        }
    }
