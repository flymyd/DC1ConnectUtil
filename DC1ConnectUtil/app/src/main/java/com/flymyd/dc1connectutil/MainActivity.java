package com.flymyd.dc1connectutil;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * @author myd
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //强制在主窗体里做请求
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView ssidtxt = findViewById(R.id.editText1);
                TextView pwdtxt = findViewById(R.id.editText2);
                String ssid = ssidtxt.getText().toString();
                if ("".equals(ssid)){
                    Toast.makeText(MainActivity.this, "请填写SSID！", Toast.LENGTH_SHORT).show();
                    return;
                }
                String pwd = pwdtxt.getText().toString();
                if ("".equals(pwd)){
                    Toast.makeText(MainActivity.this, "请填写密码！", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    UDPConnect.connectUtil(ssid,pwd);
                    Toast.makeText(MainActivity.this, "发送配网数据成功！请检查DC1连接状况", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "发送配网数据失败！请重试", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
