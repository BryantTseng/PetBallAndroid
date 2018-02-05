package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class SignupActivity extends Activity {

    private View sign_up_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        sign_up_view = inflater.inflate(R.layout.activity_signup, null);

        setContentView(sign_up_view);

        cut_title();

        //Button button1 = findViewById(R.id.go_login_button);
    }

    public void click(View v){
        switch(v.getId()){



        }
    }

    private void cut_title(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}
