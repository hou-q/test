package com.example.demo.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: 集合辅助类
 */
public class CollectionUtil {

    /**
     * 判断集合是否为空
     * 
     * @param collection 集合对象
     * @return 值为空返回 true，否则返回 false
     */
    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * 集合为null或者长度为0返回false，否则返回true
     *
     * @param collection 被判断对象
     * @return boolean 值不为空返回 true，否则返回 false
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 字符串列表倒序
     *
     * @param strList 列表对象
     * @return List<String> 倒序结果
     */
    public static List<String> reverse(List<String> strList) {
        strList.sort(Comparator.reverseOrder());
        return strList;
    }

    /**
     * 判断对象是否为数组
     *
     * @param obj 判断对象
     * @return boolean 值为数组返回 true,否则返回 false
     */
    public static boolean isArray(Object obj) {
        return (null != obj && obj.getClass().isArray());
    }

    /**
     * 判断数组是否为空
     *
     * @param array 判断数组
     * @return boolean 数组为空返回 true,否则返回 false
     */
    public static boolean isArrayEmpty(Object[] array) {
        return (null == array || array.length == 0);
    }

    /**
     * 判断数组是否不为空
     *
     * @param array 判断数组
     * @return boolean 数组不为空返回 true,否则返回 false
     */
    public static boolean isArrayNotEmpty(Object[] array) {
        return !isArrayEmpty(array);
    }
}
