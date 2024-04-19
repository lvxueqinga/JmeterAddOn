package com.demo;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @program：jemterdemo
 * @author: lvxueqing
 * @create: 2024/04/19 16:57
 */
public class Second implements JavaSamplerClient {
    private static final String URLNAME="URL"; //jmeter属性中显示的变量名称
    private static final String DEFAULTURL="http://www.baidu.com"; //jmeter属性中显示的变量值
    private String resultData; // 存储响应数据，将结果放到查看结果树里

    /**
     * 决定了jmeter中要展示哪些属性， 第一个运行
     */
    public Arguments getDefaultParameters() {
        System.out.println("getDefaultParameters  run!! ");
        Arguments arguments = new  Arguments();
        arguments.addArgument(URLNAME,DEFAULTURL);
        return arguments;
    }

    //接收用户输入的URL
    private String inputUrl ;
    /**
     * 初始化的方法
     */
    public void setupTest(JavaSamplerContext javaSamplerContext) {
        System.out.println("setupTest  run!! ");

        inputUrl = javaSamplerContext.getParameter(URLNAME,DEFAULTURL);
        System.out.println("用户输入的url地址是  " + inputUrl);

    }

    /**
     * 具体功能逻辑的方法
     */
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        System.out.println("runTest  run!! ");
        SampleResult sampleResult = new SampleResult();
        StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL(inputUrl);
            URLConnection conn = url.openConnection();
            byte[] buffer = new byte[1024];
            int len;
            sampleResult.sampleStart(); // 标记事务开始
            InputStream in = conn.getInputStream();
            while ((len=in.read(buffer)) != -1){
                resultData = new String(buffer,"UTF-8");
                sb.append(resultData);

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        resultData = "这就是响应结果";
        resultData = sb.toString();
        sampleResult.setSuccessful(true); // 告诉查看结果树 请求是否成功
        sampleResult.setSampleLabel("自定义java访问请求");
        sampleResult.setResponseData(resultData,"UTF-8");
        sampleResult.setDataType(SampleResult.TEXT);

        return sampleResult;
    }

    /**
     * 做一些收尾工作的方法
     */
    public void teardownTest(JavaSamplerContext javaSamplerContext) {
        System.out.println("teardownTest  run!! ");

    }


}
