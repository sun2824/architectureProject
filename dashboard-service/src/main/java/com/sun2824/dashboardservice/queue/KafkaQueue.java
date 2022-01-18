package com.sun2824.dashboardservice.queue;

import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class KafkaQueue {

    public BlockingQueue<Object> kafkaQueue;

    private KafkaQueue(String key){
        kafkaQueue = new LinkedBlockingQueue<>();
    }

    public static KafkaQueue getInstance(final String key){
        synchronized (instances){
            KafkaQueue instance;

            if((instance = instances.get(key))==null){
                instance = new KafkaQueue(key);
                instances.putIfAbsent(key, instance);
            }

            return instance;

        }
    }

    public static KafkaQueue remove(String key){
        synchronized (instances){
            return instances.remove(key);
        }
    }

    private static KafkaQueue get(String key){
        synchronized (instances){
            return instances.get(key);
        }
    }

    public static int size(String key){
        synchronized (instances){
            return instances.size();
        }
    }

    public static List<String> keySet(){
        synchronized (instances){
            return Collections.list(instances.keys());
        }
    }

    private static final ConcurrentHashMap<String, KafkaQueue> instances = new ConcurrentHashMap<>();

}
