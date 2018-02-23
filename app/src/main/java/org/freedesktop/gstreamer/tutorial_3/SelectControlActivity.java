package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SelectControlActivity extends Fragment {

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
        Button jump =  getView().findViewById(R.id.button_startplay);
        final TextView mText = getView().findViewById(R.id.test);
        jump.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mText.setText("go to stream");
            }
        });
//        //取得TextView元件並帶入text字串
//        TextView mText = (TextView) getView().findViewById(R.id.text);
//        mText.setText(text);
//
//        //取得ImageView元件並帶入指定圖片
//        ImageView mImg = (ImageView) getActivity().findViewById(R.id.img);
//        mImg.setImageResource(R.drawable.lesson1_img);
    }
}
