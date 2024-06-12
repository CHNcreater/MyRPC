package org.myrpc;

import org.myrpc.server.HttpServer;

public class Provider {
    public static void main(String[] args) {
        HttpServer.start("localhost", 8888);
    }
}
