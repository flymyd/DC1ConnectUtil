package com.flymyd.dc1connectutil.bean;

import lombok.Data;

/**
 * @author myd
 */
@Data
public class ConnectWifiBean {
    public ConnectWifiBean(String ssid, String password){
        this.params = new WifiSettingsBean(ssid,password);
    }
    private String header = "phi-plug-0001";
    private String uuid = "00010";
    private String action = "wifi=";
    private String auth = "";
    private WifiSettingsBean params;
}
