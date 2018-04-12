package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.freedesktop.gstreamer.tutorials.tutorial_3.AdjustLightColorActivity;
import org.freedesktop.gstreamer.tutorials.tutorial_3.GlobalVariable;

public class SelectActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        //獲取TabHost控制元件
        FragmentTabHost mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //設定Tab頁面的顯示區域，帶入Context、FragmentManager、Container ID
        mTabHost.setup(this, getSupportFragmentManager(), R.id.container);
        View controlTab = (View) LayoutInflater.from(this).inflate(R.layout.select_control, null);
        View albumTab = (View) LayoutInflater.from(this).inflate(R.layout.select_album, null);
        View sittingTab = (View) LayoutInflater.from(this).inflate(R.layout.select_sitting, null);
        mTabHost.addTab(mTabHost.newTabSpec("one")
                        .setIndicator(controlTab)
                , org.freedesktop.gstreamer.tutorials.tutorial_3.SelectControlActivity.class, null);

//        //同上方Tab設定，不同處為帶入參數的差異
        mTabHost.addTab(mTabHost.newTabSpec("two")
                        .setIndicator(albumTab)
                , org.freedesktop.gstreamer.tutorials.tutorial_3.SelectAlbumActivity.class, null);


        mTabHost.addTab(mTabHost.newTabSpec("three")
                        .setIndicator(sittingTab)
                , org.freedesktop.gstreamer.tutorials.tutorial_3.SelectSittingActivity.class, null);


        int tabnum = setPage();
        if (tabnum < 4 && tabnum >= 0) {
            mTabHost.setCurrentTab(tabnum);
        } else {
            mTabHost.setCurrentTab(0);
        }

    }

    private int setPage() {

        Intent setPageiIntent = this.getIntent();
        String first = setPageiIntent.getStringExtra("type");
        if (first.equals("sitting")) {
            return 2;
        } else if (first.equals("album")) {
            return 1;
        }

        return 0;
    }

    public void click(View v) {
        switch (v.getId()) {

            case R.id.lightAdjButton:
                this.finish();
                Intent intent = new Intent();
                intent.setClass(SelectActivity.this , AdjustLightColorActivity.class);
                startActivity(intent);

        }
    }

}