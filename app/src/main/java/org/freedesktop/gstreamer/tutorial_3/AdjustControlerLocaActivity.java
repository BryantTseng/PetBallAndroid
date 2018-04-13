package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import org.freedesktop.gstreamer.tutorials.tutorial_3.GlobalVariable;

import org.freedesktop.gstreamer.tutorials.tutorial_3.R;

public class AdjustControlerLocaActivity extends Activity {
    GlobalVariable gv;
    Button leftB;
    Button rightB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_controler_loca);

        gv = (GlobalVariable)getApplicationContext();
        leftB = (Button)findViewById(R.id.leftSetButton);
        rightB = (Button)findViewById(R.id.rightSetButton);

        FocusColorChange();
    }
    public void click(View v) {

        switch (v.getId()) {

            case R.id.returnButton:
                this.finish();
                Intent intent = new Intent();
                Intent sitting_intent = new Intent();
                sitting_intent .putExtra("type","sitting"); // told SelectPage go to which tab
                sitting_intent.setClass(AdjustControlerLocaActivity.this , org.freedesktop.gstreamer.tutorials.tutorial_3.SelectActivity.class);
                startActivity(sitting_intent);

                break;
            case R.id.leftSetButton:
                gv.setControlerLocation(0);
                FocusColorChange();
                break;
            case R.id.rightSetButton:
                gv.setControlerLocation(1);
                FocusColorChange();
                break;
        }
    }

    public void FocusColorChange(){
        int choose = gv.getControlerLocation();
        if(choose == 0)
        {
            leftB.setTextColor(0xff595757);
            rightB.setTextColor(0xff898989);
        }
        else if(choose == 1)
        {
            leftB.setTextColor(0xff898989);
            rightB.setTextColor(0xff595757);
        }
    }
}
