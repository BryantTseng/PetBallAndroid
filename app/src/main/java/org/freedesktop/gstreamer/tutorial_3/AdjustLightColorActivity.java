package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.freedesktop.gstreamer.tutorials.tutorial_3.GlobalVariable;


public class AdjustLightColorActivity extends Activity {
    GlobalVariable gv;
    Button yellowB;
    Button blueB;
    Button randomB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_light_color);
        gv = (GlobalVariable)getApplicationContext();
        yellowB = (Button)findViewById(R.id.yellowSetButton);
        randomB = (Button)findViewById(R.id.randomSetButton);
        blueB = (Button)findViewById(R.id.blueSetButton);

        FocusColorChange();

    }
    public void click(View v) {

        switch (v.getId()) {

            case R.id.returnButton:
                this.finish();
                Intent intent = new Intent();
                Intent sitting_intent = new Intent();
                sitting_intent .putExtra("type","sitting"); // told SelectPage go to which tab
                sitting_intent.setClass(AdjustLightColorActivity.this , org.freedesktop.gstreamer.tutorials.tutorial_3.SelectActivity.class);
                startActivity(sitting_intent);

                break;
            case R.id.yellowSetButton:
                gv.setLightColor(0);
                FocusColorChange();
                break;
            case R.id.blueSetButton:
                gv.setLightColor(1);
                FocusColorChange();
                break;
            case R.id.randomSetButton:
                gv.setLightColor(2);
                FocusColorChange();
                break;
        }
    }

    public void FocusColorChange(){
        int choose = gv.getLightColor();
        if(choose == 0)
        {
            yellowB.setTextColor(0xff595757);
            blueB.setTextColor(0xff898989);
            randomB.setTextColor(0xff898989);
        }
        else if(choose == 1)
        {
            yellowB.setTextColor(0xff898989);
            blueB.setTextColor(0xff595757);
            randomB.setTextColor(0xff898989);
        }
        else if(choose == 2)
        {
            yellowB.setTextColor(0xff898989);
            blueB.setTextColor(0xff898989);
            randomB.setTextColor(0xff595757);
        }
    }

}
