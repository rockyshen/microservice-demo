package org.rockyshen;

import redis.clients.jedis.Jedis;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rockyshen
 * @date 2024/8/7 17:26
 * 利用redis的十大数据结构中的bitmap实现：布隆过滤器
 * 布隆过滤器，主要用来放在redis和mysql之间，用来判断redis查不到的数据，mysql到底有没有；
 * 如果mysql没有，请求就别过去了！
 * 布隆说有，还真不一定，有可能哈希冲突；
 * 但是布隆说没有，就真的没有
 */
public class BloomFilterDemo {
    private static final String BLOOM_FILTER_KEY = "bloom_filter";
    private static final int BITMAP_SIZE = 1000000;   //位图的初始化大小
    private static final int[] HASH_SEEDS = {3, 5, 7, 11, 13, 17};  // 哈希函数的种子

    private Jedis jedis;  // jedis实例对象
    private List<SimpleHash> hashFunctions;   // 一组哈希函数

    // 构造函数
    public BloomFilterDemo(){
        this.jedis = new Jedis("47.101.200.22",6379);
        this.hashFunctions = new ArrayList<>();
        for (int seed : HASH_SEEDS){
            hashFunctions.add(new SimpleHash(BITMAP_SIZE, seed));
        }
    }

    // 增，添加元素到布隆过滤器
    public void add(String value){
        for (SimpleHash hashFunction : hashFunctions){
            //setbit key  偏移位置   设置为1，也即true
            jedis.setbit(BLOOM_FILTER_KEY, hashFunction.hash(value), true);
        }
    }


    // 查，检查元素是否存在于布隆过滤器
    public boolean isContain(String value){
        for (SimpleHash hashFunction : hashFunctions){
            // getbit
            if(!jedis.getbit(BLOOM_FILTER_KEY,hashFunction.hash(value))){return false;}
        }
        return true;
    }

    // 关闭redis连接
    public void close(){
        jedis.close();
    }


    // 静态内部类
    static class SimpleHash {
        private int cap;  //容量
        private int seed;

        // 构造函数
        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        // 手写一个hash函数，根据value，返回数组中的偏移量！
        public int hash(String value){
            int result = 0;
            byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
            for (byte b : bytes) {
                result = seed * result + b;
            }
            return (cap - 1) & result;
        }
    }
}
