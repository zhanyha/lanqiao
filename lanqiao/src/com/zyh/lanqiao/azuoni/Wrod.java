package com.zyh.lanqiao.azuoni;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zyh.lanqiao.azuoni.Word;
import org.apache.commons.io.IOUtils;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class Wrod {

    public static void main(String[] args) throws Exception {
        String copyPath = "C:\\Users\\zhanyuhao\\Desktop\\copyKaoYan_3.json";
        String topath = "C:\\Users\\zhanyuhao\\Desktop\\kanyanCore.json";
        File from = new File(copyPath);//�ļ����ļ��ж���
        File to = new File(topath);

        Reader reader = new InputStreamReader(new FileInputStream(from), StandardCharsets.UTF_8);//��ȡ�ļ�����
        BufferedReader br = new BufferedReader(reader);//��һ�㻺����
        Writer writer = new OutputStreamWriter(new FileOutputStream(to), StandardCharsets.UTF_8);//��ȡ�ļ�����
        BufferedWriter bw = new BufferedWriter(writer,1024*1024);//��һ�㻺����

        String areaData = IOUtils.toString(reader);

        JSONArray objects = JSONObject.parseArray(areaData);
        JSONObject obj;
        Word[] words = new Word[objects.size()];
        for (int i = 0; i < objects.size(); i++) {
            obj = JSONObject.parseObject(objects.get(i).toString());
            words[i] = new Word();
            words[i].setWordRank(obj.getString("wordRank"));
            String wordJSonString = obj.getString("content");
            obj = JSONObject.parseObject(wordJSonString);
            wordJSonString = obj.getString("word");
            obj = JSONObject.parseObject(wordJSonString);
            words[i].setEnglish(obj.getString("wordHead"));
            wordJSonString = obj.getString("content");
            obj = JSONObject.parseObject(wordJSonString);
            words[i].setPronounce(obj.getString("ukphone"));
            wordJSonString = obj.getString("trans");
            //System.out.println(wordJSonString);
            JSONArray oarr = JSONObject.parseArray(wordJSonString);
            for (int j = 0; j < oarr.size(); j++) {
                obj = JSONObject.parseObject(oarr.get(j).toString());
                words[i].setChinese(obj.getString("tranCn"));
            }

        }
        String finalString = JSONObject.toJSONString(words);
       // System.out.println(finalString.length());
       // System.out.println(finalString);
        bw.write(finalString);
        bw.flush();
        bw.close();
    }
}
