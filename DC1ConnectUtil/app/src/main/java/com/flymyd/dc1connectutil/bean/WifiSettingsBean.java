package com.flymyd.dc1connectutil.bean;

import lombok.Data;

/**
 * @author myd
 */
@Data
public class WifiSettingsBean {
    WifiSettingsBean(String ssid,String password){
        this.ssid = ssid;
        this.password = password;
    }
    public String ssid;
    public String password;
}
