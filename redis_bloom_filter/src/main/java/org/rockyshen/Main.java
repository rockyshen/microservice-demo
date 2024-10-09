package org.rockyshen;

/**
 * @author rockyshen
 * @date 2024/8/7 16:58
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BloomFilterDemo bloomFilterDemo = new BloomFilterDemo();
        bloomFilterDemo.add("hello");
        bloomFilterDemo.add("world");

        // 通过测试！
        System.out.println(bloomFilterDemo.isContain("woold"));
        System.out.println(bloomFilterDemo.isContain("hello"));

    }
}