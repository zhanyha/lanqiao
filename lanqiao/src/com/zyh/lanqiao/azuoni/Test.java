package com.zyh.lanqiao.azuoni;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description Test——
 * @Author zhanyuhao
 * @Date 2020/6/6 20:46
 **/
public class Test {
    public static void main(String[] args) throws Exception {

        String topath = "C:\\Users\\zhanyuhao\\Desktop\\kanyanCore.json";
        File from = new File(topath);//文件或文件夹对象

        Reader reader = new InputStreamReader(new FileInputStream(from), StandardCharsets.UTF_8);//读取文件对象

        String areaData = IOUtils.toString(reader);
        System.out.println(areaData.length());
        JSONArray jsonArray = JSONObject.parseArray(areaData);
        System.out.println(jsonArray);


    }
}
