package org.freedesktop.gstreamer.tutorials.tutorial_3;


import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import org.freedesktop.gstreamer.tutorials.tutorial_3.R;

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
    }

    public void click(View v){
        Intent intent = new Intent();
        switch(v.getId()){

            case R.id.login_button:
                intent.setClass(LoginActivity.this , org.freedesktop.gstreamer.tutorials.tutorial_3.TeachingActivity.class);
                startActivity(intent);
                break;
            case R.id.signup_button:
                intent.setClass(LoginActivity.this , org.freedesktop.gstreamer.tutorials.tutorial_3.SignupActivity.class);
                startActivity(intent);
                break;
        }
    }


}
