package com.yootk.common.reflect;


import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class MethodParameterUtil {
    /**
     * 根据指定的类型以及方法名称获取参数的完整信息
     * @param clazz 要解析的Class类
     * @param method_name 要进行处理的方法名称
     * @return 一个包含有参数名称以及类型对应的Map集合
     */
    public static Map<String,Class> getMethodParameter(Class<?> clazz, String method_name) {
        Map<String,Class> map = new LinkedHashMap<>() ; // 必须有序存储Map
        if (clazz == null || method_name == null || "".equals(method_name)) {
            return map ;
        }
        Method method = MethodUtil.getMethod(clazz,method_name) ;
        String names [] = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method) ;
        Class<?> parameterTypes[] = method.getParameterTypes();
        for (int x = 0; x < parameterTypes.length; x++) {
            map.put(names[x], parameterTypes[x]);
        }
        return map ;
    }
    public static Map<String,Class> getMethodParameter(Class<?> clazz, Method method) {
        Map<String,Class> map = new LinkedHashMap<>() ; // 必须有序存储Map
        if (method == null) {
            return map ;
        }
        String names [] = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method) ;
        Class<?> parameterTypes[] = method.getParameterTypes();
        for (int x = 0; x < parameterTypes.length; x++) {
            map.put(names[x], parameterTypes[x]);
        }
        return map ;
    }
}
