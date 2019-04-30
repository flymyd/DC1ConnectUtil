package com.flymyd.dc1connectutil;

import com.alibaba.fastjson.JSON;
import com.flymyd.dc1connectutil.bean.ConnectWifiBean;
import com.flymyd.dc1connectutil.config.Const;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author myd
 */
public class UDPConnect {
    public static void connectUtil(String ssid,String password) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        ConnectWifiBean connectWifiBean = new ConnectWifiBean(ssid,password);
        String str = JSON.toJSONString(connectWifiBean)+"\n";
        System.out.println(str);
        byte[] buf = str.getBytes();
        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName(Const.DC1_CONNECT_WIFI_CONSOLE_IP), Integer.parseInt(Const.DC1_CONNECT_WIFI_CONSOLE_PORT));
        ds.send(dp);
        ds.close();
    }
}
