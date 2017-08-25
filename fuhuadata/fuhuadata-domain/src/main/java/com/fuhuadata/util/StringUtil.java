package com.fuhuadata.util;

import com.google.common.collect.Sets;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 字符处理工具类
 * Created by intanswer on 2017/3/9.
 */
public class StringUtil {
    //字符串去重
    public static String[] minus(String[] strArray1, String[] strArray2) {
        LinkedList<String> list = new LinkedList<String>();
        for (String str : strArray1) {
            if (!list.contains(str)) {
                list.add(str);
            }
        }
        for (String str : strArray2) {
            if (list.contains(str)) {
                list.remove(str);
            }
        }
        for(int i = 0;i<list.size();i++) {
            System.out.println(list.get(i).toString());
        }
        String[] result = new String[0];
        return list.toArray(result);
    }

    /**
     * 求两个字符串数组的并集，利用set的元素唯一性
     * @param strArray1 字符串数组1
     * @param strArray2 字符串数组2
     * @return 两个字符串数组的并集
     */
    public static String[] union(String[] strArray1, String[] strArray2) {
        Set<String> setString = new HashSet<String>();
        for (String str : strArray1) {
            setString.add(str);
        }
        for (String str : strArray2) {
            setString.add(str);
        }
        String[] result = new String[0];
        return setString.toArray(result);
    }

    /**
     * 求两个字符串数组的交集
     * @param strArray1 字符串数组1
     * @param strArray2 字符串数组2
     * @return 两个字符串数组的交集
     */
    public static String[] intersect(String[] strArray1, String[] strArray2) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        LinkedList<String> list = new LinkedList<String>();
        // 通过Map来获取两个集合的相同元素
        for (String str : strArray1) {
            if (!map.containsKey(str)) {
                map.put(str, Boolean.FALSE);
            }
        }
        for (String str : strArray2) {
            if (map.containsKey(str)) {
                map.put(str, Boolean.TRUE);
            }
        }
        // 将Map中相同元素添加加list中
        for (Map.Entry<String, Boolean> e : map.entrySet()) {
            if (e.getValue().equals(Boolean.TRUE)) {
                list.add(e.getKey());
            }
        }
        String[] result = new String[0];
        return list.toArray(result);
    }

    /**
     * 去掉数组中的重复元素
     * @param strArray 字符串数组
     * @return 去掉重复元素后的数组
     */
    public static String[] distinct(String[] strArray) {
        // 无序
		/*
		Set<String> treeSet = new TreeSet<String>();
		for(int i = 0; i < strArray.length; i ++) {
			treeSet.add(strArray[i]);
		}
		String[] result = new String[0];
		return treeSet.toArray(result);
		*/

        // 有序
        ArrayList<String> strList = new ArrayList<String>();
        for(int i = 0; i < strArray.length; i ++) {
            if (!strList.contains(strArray[i])) {
                strList.add(strArray[i]);
            }
        }
        String[] result = new String[0];
        return strList.toArray(result);
    }


    /**
     *
     * @param str
     * @param digits
     * @return
     */
    public static String increment(String str,int digits){
        String preStr=str.substring(0,str.length()-digits);
        String numStr = str.substring(str.length()-digits,str.length());
        int num = Integer.valueOf(numStr)+1;
        String numConStr=String.valueOf(num);
        StringBuffer sb = new StringBuffer();
        //补全前面缺失的0
        for(int i = 0;i<digits-numConStr.length();i++){
            sb.append("0");
        }if(numConStr.length()<=digits){
            numStr=sb.toString()+numConStr;
        }else{
            numStr="无可用序列";
        }
        return preStr+numStr;
    }

    /**
     * 将字符串分割为特定类型的set
     *
     * @param str
     * @param separatorChars
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Set<T> splitToTypeSet(String str, String separatorChars, Class<T> clazz) {
        Set<T> result = Sets.newHashSet();

        if (StringUtils.isEmpty(str)) {
            return result;
        }

        String[] values = StringUtils.split(str, separatorChars);
        for (String value : values) {
            if (StringUtils.isNotEmpty(value)) {
                result.add((T) ConvertUtils.convert(value, clazz));
            }
        }

        return result;
    }


    /**
     * c产品规格型号合并
     * @param str1
     * @param str2
     * @param separate
     * @return
     */
    public static String merge2string(String str1,String str2,String separate){
        if(str1!=null&&""!=str1){
            if(str2!=null&&""!=str2){
                return str1+separate+str2;
            }else{
                return str1;
            }
        }else{
            return str2;
        }
    }

    /**
     * 生成 uuid，替换掉短横线
     * @return
     */
    public static String uuidWithoutLine() {

        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
