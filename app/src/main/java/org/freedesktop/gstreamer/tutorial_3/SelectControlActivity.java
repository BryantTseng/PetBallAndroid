package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SelectControlActivity extends Fragment {
    private static final int STOPSPLASH = 0;
    // time in milliseconds
    private static final long SPLASHTIME = 1000;
    private LinearLayout splash;
    private LinearLayout start;
    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);

        //取得MainActivity的方法，將文字放入text字串
//        MainActivity mMainActivity = (MainActivity) activity;
//        text = mMainActivity.getLessonOneText();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //導入Tab分頁的Fragment Layout
        return inflater.inflate(R.layout.activity_select_control, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);


        Message msg = new Message();
        msg.what = STOPSPLASH;

        splash = (LinearLayout) getActivity().findViewById(R.id.splashScreen);
        start = (LinearLayout) getActivity().findViewById(R.id.startScreen);
        splashHandler.sendMessageDelayed(msg, SPLASHTIME);

        splash.setVisibility(View.VISIBLE);
        start.setVisibility(View.INVISIBLE);


        Button jump =  getView().findViewById(R.id.button_startplay);
        jump.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            }
        });
    }
    private Handler splashHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case STOPSPLASH:
                    SystemClock.sleep(2500);
                    splash.setVisibility(View.INVISIBLE);
                    start.setVisibility(View.VISIBLE);
                    break;
            }
            super.handleMessage(msg);
        }
    };
}
