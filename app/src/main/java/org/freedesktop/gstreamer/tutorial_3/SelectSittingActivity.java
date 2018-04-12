package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.content.Context;
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
    }


    public void SetLightText(){
        int choose = gv.getLightColor();
        TextView lightColorT = (TextView)getActivity().findViewById(R.id.lightColorText);
        if(choose == 0)
        {
            lightColorT.setText("黃光");
        }
        else if(choose == 1)
        {
            lightColorT.setText("藍光");
        }
        else if(choose == 2)
        {
            lightColorT.setText("隨機");
        }
    }

}
