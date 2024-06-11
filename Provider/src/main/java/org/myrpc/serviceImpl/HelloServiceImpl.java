package org.myrpc.serviceImpl;

import org.myrpc.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello, Welcome " + name;
    }
}
