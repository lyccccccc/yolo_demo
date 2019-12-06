package com.zt.web;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@CrossOrigin
@RestController
public class ControllerDemo {
    @RequestMapping("/hello")
    public String hello(){
        return "hello!";
    }


    @RequestMapping("/yolo")
    public Map<String,String> yolo(@RequestParam("filename") String fileName){
        String exe = "python";
        String command = "/keras-yolo3-master/yolo_video.py --image --selfinput";
        String address = "/keras-yolo3-master/";
        String cmd = exe+" "+command+" "+address+fileName;
        System.out.println("执行....");
        String output = "";
        try {
            Process process=Runtime.getRuntime().exec(cmd);

            BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
            String line;

            while((line=reader.readLine())!=null) {
                System.out.println(line);
                output = output + line;
            }
            reader.close();

              //使子进程等待，可能会引起阻塞-待分析（输入输出导致缓存满？）
            int endFlag = process.waitFor();
            if (endFlag == 0)
            {
                System.out.println("The process is ended normally.");
            }

            process.destroy();   //结束子进程
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束....");
        Map<String,String> resultMap = new HashMap<String, String>();
        resultMap.put("result", output);
        return resultMap;
    }


    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        String filePath = "/keras-yolo3-master/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);

            return "上传成功";
        } catch (IOException e) {
            System.out.println(e);
        }
        return "上传失败！";
    }
}
