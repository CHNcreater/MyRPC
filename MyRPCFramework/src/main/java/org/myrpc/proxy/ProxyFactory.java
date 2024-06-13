package org.myrpc.proxy;

import org.myrpc.entity.Invocation;
import org.myrpc.entity.Url;
import org.myrpc.loadbalancer.LoadBalancer;
import org.myrpc.protocol.HttpClient;
import org.myrpc.register.RegistCenter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class ProxyFactory {
    public static <T> T getProxy(Class service) {
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Invocation invocation = new Invocation(service.getName(), method.getName(), method.getParameterTypes(), args);
                List<Url> urls = RegistCenter.get(service.getName());
                Url url = LoadBalancer.get(urls);
                String result = HttpClient.send(url.getHostname(), url.getPort(), invocation);
                return result;
            }
        };

        Object object = Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, invocationHandler);
        return (T)object;
    }
}
