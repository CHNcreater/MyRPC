package org.myrpc;

import org.myrpc.entity.Invocation;
import org.myrpc.protocol.HttpClient;
import org.myrpc.proxy.ProxyFactory;
import org.myrpc.service.HelloService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Consumer {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

//        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Class[]{String.class}, new Object[]{"Joey"});
//        String result = HttpClient.send("localhost", 8888, invocation);
//        System.out.println(result);

        //Dynamic Proxy
        HelloService proxy = ProxyFactory.getProxy(HelloService.class);
        String result = proxy.sayHello("Joey");
        System.out.println(result);
    }
}