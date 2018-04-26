package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Begin_page extends Activity {

    private final int SPLASH_DISPLAY_LENGHT = 3000; // 延遲六秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_page);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent mainIntent = new Intent(Begin_page.this,
                        org.freedesktop.gstreamer.tutorials.tutorial_3.LoginActivity.class);
                Begin_page.this.startActivity(mainIntent);
                Begin_page.this.finish();
            }

        }, SPLASH_DISPLAY_LENGHT);

    }
}
