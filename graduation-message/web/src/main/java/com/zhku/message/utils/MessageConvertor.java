package com.zhku.message.utils;


import com.zhku.pojo.DsfMessageTemplateEntity;
import com.zhku.pojo.MessageRequest;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageConvertor {
	
	private static String REGEX = "\\{([^}]*)\\}";

    public static String getSendContent(MessageRequest request){
        DsfMessageTemplateEntity template = request.getDsfMessageTemplateEntity();
        String tempContent = template.getTemplateContent();
        Map param = request.getMessageParam();
        //此处是中文输入的（）
        Matcher mat = Pattern.compile(REGEX).matcher(tempContent);
        while(mat.find()){
            tempContent = tempContent.replaceAll("\\{"+mat.group(1)+"\\}",param.get(mat.group(1))+"");
        }
        return tempContent;
    }


    public static String nihao (String request, Map param){

        Matcher mat = Pattern.compile(REGEX).matcher(request);//此处是中文输入的（）
        while(mat.find()){
            //sendContent = request.replaceAll("{"+mat.group(1)+"}",param.get(mat.group(1))+"");
            request = request.replaceAll("\\{"+mat.group(1)+"\\}",param.get(mat.group(1))+"");
            //System.out.println(mat.group().substring(1, mat.group().length()-1));
            //System.out.println(mat.group(1));
        }
        //System.out.println(sendContent);
        return request;
    }

    /*
    public static void main(String[] args) {
        Map map = Maps.newHashMap();
        map.put("userName","汤新涛");
        map.put("money","15");
        map.put("tia","贴");
        map.put("tian","天");
        System.out.println("{tia}nihao{userName},qig缴费：金额{money}员！{tian}");
        System.out.println(nihao("{tia}nihao{userName},qig缴费：金额{money}员！{tian}",map));
    }*/



}
