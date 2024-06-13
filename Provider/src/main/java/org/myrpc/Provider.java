package org.myrpc;

import org.myrpc.entity.Url;
import org.myrpc.protocol.HttpServer;
import org.myrpc.register.LocalRegister;
import org.myrpc.register.RegistCenter;
import org.myrpc.service.HelloService;
import org.myrpc.serviceImpl.HelloServiceImpl;

public class Provider {
    public static void main(String[] args) {
        LocalRegister.regist(HelloService.class.getName(), HelloServiceImpl.class);
        Url url = new Url("localhost", 8888);

        RegistCenter.regist(HelloService.class.getName(), url);

        HttpServer.start(url.getHostname(), url.getPort());
    }
}
