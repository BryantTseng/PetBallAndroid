package org.freedesktop.gstreamer.tutorials.tutorial_3;


import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


import org.freedesktop.gstreamer.tutorials.tutorial_3.GlobalVariable;
import org.freedesktop.gstreamer.tutorials.tutorial_3.R;
import org.freedesktop.gstreamer.tutorials.tutorial_3.WebConnect;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);

        //setContentView(R.layout.firstpage);

        setContentView(R.layout.activity_login);
        cut_title();
    }

    public void click(View v){
        Intent intent = new Intent();
        switch(v.getId()){

            case R.id.login_button:
                TextView login_email_tv = (TextView) findViewById(R.id.Login_Email);
                TextView login_password_tv = (TextView) findViewById(R.id.Login_Password);
                String login_email = login_email_tv.getText().toString();
                String login_password = login_password_tv.getText().toString();
                GlobalVariable gv = (GlobalVariable)getApplicationContext();
//                gv.setRoomii_IP("change");

                JSONObject logindata = new JSONObject();
                String test;
                gv.setLoginState(1);
                WebConnect Webcon = new WebConnect(gv);
                test = Webcon.execute("login?email="+login_email+"&password="+login_password).toString();
                Log.d("LOGINTEST",test);
                //Log.d("loginstate",gv.getLoginState());
                if(gv.getLoginState()==2){
                   //login success
                    gv.setLoginState(0);
                    intent.setClass(LoginActivity.this , org.freedesktop.gstreamer.tutorials.tutorial_3.TeachingActivity.class);
                    startActivity(intent);
                }
                else if(gv.getLoginState()==3){
                    gv.setLoginState(0);
                    //login failed
                }




                break;
            case R.id.signup_button:
                intent.setClass(LoginActivity.this , org.freedesktop.gstreamer.tutorials.tutorial_3.SignupActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void cut_title(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
