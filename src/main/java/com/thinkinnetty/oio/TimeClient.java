package com.thinkinnetty.oio;/**
 * @Author: wangs
 * @Date: 2018/6/10
 */

import java.io.*;
import java.net.Socket;

/**
 * Description:
 * User:wangs
 * Date:2018/6/10
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1",port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("QUERY TIME ORDER");
            System.out.println("Send order 2 server successed.");
            String resp = in.readLine();
            System.out.println("Now is : " + resp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
