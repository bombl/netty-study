package com.thinkinnetty.nio;/**
 * @Author: wangs
 * @Date: 2018/6/10
 */

/**
 * Description:
 * User:wangs
 * Date:2018/6/10
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        MultiplexerTimeServer multiplexerTimeServer = new MultiplexerTimeServer(port);
        new Thread(multiplexerTimeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
