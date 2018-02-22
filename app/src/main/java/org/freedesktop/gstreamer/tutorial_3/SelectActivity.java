package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.TabHost;


public class SelectActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        //獲取TabHost控制元件
        FragmentTabHost mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //設定Tab頁面的顯示區域，帶入Context、FragmentManager、Container ID
        mTabHost.setup(this, getSupportFragmentManager(), R.id.container);
        mTabHost.addTab(mTabHost.newTabSpec("one")
                        .setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.source_selectview_control, null))
                , org.freedesktop.gstreamer.tutorials.tutorial_3.SelectControlActivity.class,null);

//        //同上方Tab設定，不同處為帶入參數的差異
        mTabHost.addTab(mTabHost.newTabSpec("two")
                        .setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.source_selectview_album, null))
                , org.freedesktop.gstreamer.tutorials.tutorial_3.SelectAlbumActivity.class,null);

        mTabHost.addTab(mTabHost.newTabSpec("two")
                        .setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.source_selectview_count, null))
                , org.freedesktop.gstreamer.tutorials.tutorial_3.SelectCountActivity.class,null);

        mTabHost.addTab(mTabHost.newTabSpec("two")
                        .setIndicator("", ResourcesCompat.getDrawable(getResources(), R.drawable.source_selectview__sitting, null))
                , org.freedesktop.gstreamer.tutorials.tutorial_3.SelectSittingActivity.class,null);
    }

}
