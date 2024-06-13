package org.myrpc.loadbalancer;

import org.myrpc.entity.Url;

import java.util.List;
import java.util.Random;

public class LoadBalancer {

    public static Url get(List<Url> urls) {
        Random random = new Random();
        int i = random.nextInt(urls.size());
        return urls.get(i);
    }
}
