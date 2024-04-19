package com.functions;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program：jemterdemo
 * @author: lvxueqing
 * @create: 2024/04/19 17:38
 */
public class Plus extends AbstractFunction {
    private Object[] values;
    private CompoundVariable first,second; // 存储第一个和第二个参数

    /**
     * 执行方法
     */
    public String execute(SampleResult sampleResult, Sampler sampler) throws InvalidVariableException {
        System.out.println(" execute  run ");

        first = (CompoundVariable) values[0];
        System.out.println("第一个参数是 " + first);
        second = (CompoundVariable) values[1];
        System.out.println("第二个参数是 " + second);
        int count = new Integer(first.execute().trim()) + new Integer(second.execute().trim()) ;
        System.out.println("和 " + count);

        return String.valueOf(count);
    }

    /**
     * 设置参数， 接收用户传递的参数
     */
    public void setParameters(Collection<CompoundVariable> collection) throws InvalidVariableException {
        System.out.println(" setParameters  run ");
        checkParameterCount(collection,2);
        values = collection.toArray();
    }

    /**
     * 功能名称
     */
    public String getReferenceKey() {
        System.out.println(" getReferenceKey  run ");
        return "__MyDemoPlus";
    }

    /**
     * 功能描述 参数描述
     */
    public List<String> getArgumentDesc() {
        System.out.println(" getArgumentDesc  run ");
        List desc = new ArrayList();
        desc.add("第一个数");
        desc.add("第二个数");
        return desc;
    }
}
