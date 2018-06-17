package com.thinkinnetty.oio;/**
 * @Author: wangs
 * @Date: 2018/6/10
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.ExportException;

/**
 * Description:
 * User:wangs
 * Date:2018/6/10
 */
public class TimeServer {
    public static void main(String[] args) {
        Integer port = null;
        if (args == null || args.length == 0) {
            port = 8080;
        }
        if (port == null) {
            return;
        }
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("The server is start in port :" + port);
            TimeServerExecutorPool singleExecutor = new TimeServerExecutorPool(8,10);
            while (true) {
                Socket socket = serverSocket.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
