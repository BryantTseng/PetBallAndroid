package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.freedesktop.gstreamer.tutorials.tutorial_3.GlobalVariable;
public class SelectSittingActivity extends Fragment {
    GlobalVariable gv;
    String StrlightText[] = {"黃光","藍光","隨機"};
    String StrcontrolerText[] = {"左邊","右邊"};
    String StrsoundText[] = {"響板聲","哨子聲","鳥叫聲"};

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        gv = (GlobalVariable)getActivity().getApplicationContext();
        //取得MainActivity的方法，將文字放入text字串
//        MainActivity mMainActivity = (MainActivity) activity;
//        text = mMainActivity.getLessonOneText();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //導入Tab分頁的Fragment Layout
        return inflater.inflate(R.layout.activity_select_sitting, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        SetLightText();
        SetControlerLocationText();
        SetSoundText();
    }


    public void SetLightText(){
        int choose = gv.getLightColor();
        TextView lightColorT = (TextView)getActivity().findViewById(R.id.lightColorText);

        lightColorT.setText(StrlightText[choose]);

    }
//
    public void SetControlerLocationText(){
        int choose = gv.getControlerLocation();
        TextView controlerT = (TextView)getActivity().findViewById(R.id.controlerLocaText);

        controlerT.setText(StrcontrolerText[choose]);
    }

    public void SetSoundText(){
        int choose = gv.getSound();
        TextView soundT = (TextView)getActivity().findViewById(R.id.soundText);

        soundT.setText(StrsoundText[choose]);

    }


}
