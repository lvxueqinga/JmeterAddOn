package com.demo;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 * @program：jemterdemo
 * @author: lvxueqing
 * @create: 2024/04/19 16:46
 */
public class First extends AbstractJavaSamplerClient {
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        System.out.println(" 我的demo！！！！");
        return null;
    }
}
