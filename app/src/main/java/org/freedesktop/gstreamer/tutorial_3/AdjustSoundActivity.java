package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

import org.freedesktop.gstreamer.tutorials.tutorial_3.R;

import org.freedesktop.gstreamer.tutorials.tutorial_3.GlobalVariable;
public class AdjustSoundActivity extends Activity {
    GlobalVariable gv;
    Button castB;
    Button whistleB;
    Button birdmB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_sound);

        gv = (GlobalVariable)getApplicationContext();
        castB = (Button)findViewById(R.id.castanetsSetButton);
        whistleB = (Button)findViewById(R.id.whistleSetButton);
        birdmB = (Button)findViewById(R.id.birdSetButton);

        FocusColorChange();
    }
    public void click(View v) {

        switch (v.getId()) {

            case R.id.returnButton:
                this.finish();
                Intent intent = new Intent();
                Intent sitting_intent = new Intent();
                sitting_intent .putExtra("type","sitting"); // told SelectPage go to which tab
                sitting_intent.setClass(AdjustSoundActivity.this , org.freedesktop.gstreamer.tutorials.tutorial_3.SelectActivity.class);
                startActivity(sitting_intent);

                break;
            case R.id.castanetsSetButton:
                gv.setSound(0);
                FocusColorChange();
                break;
            case R.id.whistleSetButton:
                gv.setSound(1);
                FocusColorChange();
                break;
            case R.id.birdSetButton:
                gv.setSound(2);
                FocusColorChange();
                break;
        }
    }

    public void FocusColorChange(){
        int choose = gv.getSound();
        if(choose == 0)
        {
            castB.setTextColor(0xff595757);
            whistleB.setTextColor(0xff898989);
            birdmB.setTextColor(0xff898989);
        }
        else if(choose == 1)
        {
            castB.setTextColor(0xff898989);
            whistleB.setTextColor(0xff595757);
            birdmB.setTextColor(0xff898989);
        }
        else if(choose == 2)
        {
            castB.setTextColor(0xff898989);
            whistleB.setTextColor(0xff898989);
            birdmB.setTextColor(0xff595757);
        }
    }
}
