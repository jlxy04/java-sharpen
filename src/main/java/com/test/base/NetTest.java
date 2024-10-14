package com.test.base;

import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Formatter;

public class NetTest {

    public static void main(String[] args) {
        try {
            // 获取所有网络接口
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    Formatter formatter = new Formatter();
                    for (byte b : mac) {
                        formatter.format("%02X:", b);
                    }
                    String macAddress = formatter.toString().substring(0, formatter.toString().length() - 1); // 移除最后一个冒号
                    System.out.println("MAC Address: " + macAddress);
                    formatter.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
