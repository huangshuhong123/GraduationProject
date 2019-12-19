package com.zhku.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 高频使用工具
 * Created by lvshaohua on 2017/9/7.
 */
public class BaseUtil {
    private final static transient Logger logger = LoggerFactory.getLogger(BaseUtil.class);
    public final static String DEPT_APPEND = "-";
    public final static String DEPT_BREAK = "/";
    public final static String NO = "0";
    public final static String YES = "1";
    public final static Integer INIT_MAP_SIZE = 16;
    public static String KEY_DEPT_FULL_NAME = "deptFullName";
    /**
     * 市委组织类型
     */
    public final static String ORG_SW_TYPE="133";
    /**
     * 省直属工委组织类型
     */
    public final static String ORG_GW_TYPE="22";


    /**
     * 对象是否为空
     * @param o String,List,Map,Object[],int[],long[]
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            if ("".equals(o.toString().trim())) {
                return true;
            }
        } else if (o instanceof List) {
            if (((List) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Map) {
            if (((Map) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Set) {
            if (((Set) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Object[]) {
            if (((Object[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof int[]) {
            if (((int[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof long[]) {
            if (((long[]) o).length == 0) {
                return true;
            }
        }
        return false;
    }
    public static boolean isEmpty(Object... o) {
        boolean empty = false;
        for (Object o1 : o) {
            if(isEmpty(o1)){
                empty = true;
                break;
            }
        }
        return empty;
    }

    /**
     * map添加%value%
     * @param map
     * @param key
     * @param value
     * @return
     */
    public static Map putMapLike(Map map,String key,Object value){
        if(isNotEmpty(value)){
            map.put(key,"%"+value+"%");
        }
        return map ;
    }

    /**
     * map添加%value
     * @param map
     * @param key
     * @param value
     * @return
     */
    public static Map putMapLeftLike(Map map,String key,Object value){
        if(isNotEmpty(value)){
            map.put(key,"%"+value);
        }
        return map ;
    }

    /**
     * map添加value%
     * @param map
     * @param key
     * @param value
     * @return
     */
    public static Map putMapRightLike(Map map,String key,Object value){
        if(isNotEmpty(value)){
            map.put(key,value+"%");
        }
        return map ;
    }

    /**
     * 先判空，map添加value
     * @param map
     * @param key
     * @param value
     * @return
     */
    public static Map putMap(Map map,String key,Object value){
        if(isNotEmpty(value)){
            map.put(key,value);
        }
        return map ;
    }

    /**
     * 对象是否不为空
     * @param o String,List,Map,Object[],int[],long[]
     * @return
     */
    public static boolean isNotEmpty(Object o){
        return !isEmpty(o);
    }
    /**
     * 对象组中是否存在 Empty Object
     * @param os 对象组
     * @return
     */
    public static boolean isOneEmpty(Object... os) {
        for (Object o : os) {
            return isEmpty(o);
        }
        return false;
    }

    /**
     * 对象组中是否全是 Empty Object
     * @param os
     * @return
     */
    public static boolean isAllEmpty(Object... os) {
        for (Object o : os) {
            if (!isEmpty(o)) {
                return false;
            }
        }
        return true;
    }

    public static String trimSpace(String source) {
        return source == null ? source : source.replaceAll("^[\\s　]*|[\\s　]*$", "");
    }

    public static String getUUID32(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 向input中追加党组织nodeId & 分隔符 格式: nodeId1-nodeId2-nodeId3-
     * @param input 被追加的builder
     * @param nodeId 党组织nodeId
     * @return 追加后的builder
     */
    public static StringBuilder appendDepartmentSeparator(StringBuilder input, Long nodeId){
        return Optional.ofNullable(input)
                .orElse(new StringBuilder())
                .append(nodeId)
                .append(DEPT_APPEND);
    }


    /**
     * 加-＞[内容 nodeId]
     */
    public static String addBrackets(String nodeId) {
        if(BaseUtil.isNotEmpty(nodeId)){
            nodeId = nodeId+DEPT_APPEND;
        }
        return nodeId;
    }



    public static <T> void setKey(T vo, String key,Object value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if(isNotEmpty(value)){
            Field keyField = null;
            try {
                keyField = vo.getClass().getDeclaredField(key);
            } catch (NoSuchFieldException e) {
                logger.debug(vo.getClass().getName()+"对象不存在"+key+"字段！");
            }
            if(BaseUtil.isNotEmpty(keyField)){
                String setMethodName = setMethodName(key);
                Method setMethod = vo.getClass().getMethod(setMethodName,value.getClass());
                setMethod.invoke(vo,value);
            }
        }
    }

    public static String getMethodName(String key){
        return "get"
                + key.substring(0, 1).toUpperCase()
                + key.substring(1);
    }
    public static String setMethodName(String key){
        return "set"
                + key.substring(0, 1).toUpperCase()
                + key.substring(1);
    }


    /**
     * 数据版本号加1
     * <p>Description: TODO</p>
     */
    public static Integer getDateVersion(Integer version) {
        Integer dateVersion = 0;
        if(BaseUtil.isNotEmpty(version)){
            dateVersion = version;
        }
        dateVersion += 1;
        return dateVersion;
    }

    /**
     * 设置VO基础属性
     */
    public static <T> void setCreatePO(T vo, String userId, String orgId) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        setKey(vo,"createTime",new Date());
        setKey(vo,"createUser",userId);
        setKey(vo,"orgId",orgId);
        setKey(vo,"isDelete","0");
        setKey(vo,"dateVersion",0);
    }

    public static String appendMoreSql(Object object){
        if(object!=null&&(object instanceof List||object instanceof String[])){
            StringBuffer sql = new StringBuffer(" (");
            if(object instanceof List) {
                if (((List) object).size() != 0) {
                    for(String str:(List<String>) object){
                        sql.append("'").append(str).append("',");
                    }
                }
            }else if(object instanceof String[]) {
                if (((String[]) object).length != 0) {
                    for(String str:(String[]) object){
                        sql.append("'").append(str).append("',");
                    }
                }
            }
            return sql.substring(0,sql.length()-1)+") ";
        }
        return "";
    }

    //手机号码中间4位替换成*号
    public static String replaceAsterisk(String mobile) {
        if(BaseUtil.isNotEmpty(mobile)){
            String compileStr="[0-9]*";
            Pattern pattern = Pattern.compile(compileStr);
            Matcher isNum = pattern.matcher(mobile);
            if(isNum.matches()&&mobile.length()==11){
                String str1 = mobile.substring(0,3);
                String str2 = mobile.substring(mobile.length()-4);
                mobile = str1+"****"+str2;

            }
        }
        return mobile;
    }

    /**
     * 获取map的值
     * @param map
     * @param key
     * @return
     */
    public static String getStringMap(Map map,String key){
        Object val = map.get(key);
        if(isNotEmpty(val)){
            return String.valueOf(val);
        }
        if(val==""){
            return "";
        }
        return null ;
    }


    /**
     * 根据fullName 获取到所有上级部门全称
     * @param deptFullName 部门全称
     * @return arrStr
     */
    public static List<String> getParentDeptByFullName(String deptFullName) {
        List<String> result = new ArrayList<String>();
        if(deptFullName.contains(DEPT_APPEND)){
            String[] split = deptFullName.split(DEPT_APPEND);
            String dept = "";
            for (String s : split) {
                dept += s ;
                dept += DEPT_APPEND ;
                result.add(dept);
            }
        }else{
            result.add(deptFullName);
        }
        return result;
    }

    /**
     * 复制LIST 重新指定list两个LIST互不影响
     * @param src
     * @param <T>
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> List<T> listCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

    public static String getDatePoor(String startTime ,String endTime) {
        String str = "";
        if (null!=startTime && null!=endTime){
            try{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date nowDate = sdf.parse(startTime);
                Date endDate = sdf.parse(endTime);
                long nd = 1000 * 24 * 60 * 60;
                long nh = 1000 * 60 * 60;
                long nm = 1000 * 60;
                // long ns = 1000;
                // 获得两个时间的毫秒时间差异
                long diff = endDate.getTime() - nowDate.getTime();
                // 计算差多少天
                long day = diff / nd;
                // 计算差多少小时
                long hour = diff % nd / nh;
                // 计算差多少分钟
                long min = diff % nd % nh / nm;
                // 计算差多少秒//输出结果
                // long sec = diff % nd % nh % nm / ns;
                if (day>0){
                    str += day + "天";
                }
                if(hour>0){
                    str += hour + "小时";
                }
                if(min>0){
                    str += min + "分钟";
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    /**
     * 日期转星期
     * @param datetime
     * @return
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 日期转星期
     * @param datetime
     * @return
     */
    public static String subStringDate(String datetime,int n) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateStr = "";
        try {
            if(datetime.length()>=16) {
                if (n == 0) {
                    dateStr = (sdf.format(sdf.parse(datetime))).substring(0, 10);
                }
                if (n == 1) {
                    dateStr = (sdf.format(sdf.parse(datetime))).substring(11, 16);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    /**
     * 审核结果微信模板参数赋值
     * @param parameters
     * @param first 标题
     * @param keyword1 审核人
     * @param keyword2 审核时间
     * @param keyword3 原因
     */
    public static void setMsgMapValue(Map<String, String> parameters,String first, String keyword1, String keyword2, String keyword3){
        parameters.put("first", first);
        parameters.put("keyword1",keyword1);//审核人
        parameters.put("keyword2",keyword2);
        parameters.put("keyword3",keyword3);//原因
        parameters.put("remark","请点击查看详情!");
    }

    /**
     * 生成随机数
     *
     * @param numLen 随机数长度
     * @return
     */
    public static String generateRomdom(int numLen) {
        StringBuffer sb = new StringBuffer();
        String str = "0123456789";
        Random r = new Random();
        for(int i=0;i<numLen;i++){
            int num = r.nextInt(str.length());
            sb.append(str.charAt(num));
            str = str.replace((str.charAt(num)+""), "");
        }
        return sb.toString();
    }

    public static int getInt(String count) {
        try {
            return Integer.parseInt(count);
        } catch (Exception e) {
            //不是数字或空不处理合并返回0
            return 0;
        }
    }

    public static double getDouble(String count) {
        try {
            return Double.parseDouble(count);
        } catch (Exception e) {
            //不是数字或空不处理合并返回0
            return 0;
        }
    }

    //身份证中间11位替换成*号
    public static String replaceIdentity(String identity) {
        if(BaseUtil.isNotEmpty(identity)){
            identity = identity.replaceAll("(\\d{3})\\d{11}(\\d{4})","$1***********$2");
        }
        return identity;
    }

}