package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
//import android.widget.ImageButton;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.freedesktop.gstreamer.GStreamer;
import org.freedesktop.gstreamer.tutorial_3.WebConnect;


public class Tutorial3 extends Activity implements SurfaceHolder.Callback{
    private native void nativeInit();     // Initialize native code, build pipeline, etc
    private native void nativeFinalize(); // Destroy pipeline and shutdown native code
    private native void nativePlay();     // Set pipeline to PLAYING
    private native void nativePause();    // Set pipeline to PAUSED
    private static native boolean nativeClassInit(); // Initialize native class: cache Method IDs for callbacks
    private native void nativeSurfaceInit(Object surface);
    private native void nativeSurfaceFinalize();
    private long native_custom_data;      // Native code will use this to keep private data

    private boolean is_playing_desired;   // Whether the user asked to go to PLAYING


    private RelativeLayout guide_page;
    private RelativeLayout list_page;

    private boolean list_page_status;
    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Initialize GStreamer and warn if it fails
        try {
            GStreamer.init(this);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        cut_title();

        setContentView(R.layout.main);

        guide_page = findViewById(R.id.guide_page);
        list_page = findViewById(R.id.list_page);

        SurfaceView sv = (SurfaceView) this.findViewById(R.id.surface_video);
        SurfaceHolder sh = sv.getHolder();
        sh.addCallback(this);

        if (savedInstanceState != null) {
            is_playing_desired = savedInstanceState.getBoolean("playing");
            Log.i ("GStreamer", "Activity created. Saved state is playing:" + is_playing_desired);
        } else {
            is_playing_desired = false;
            Log.i ("GStreamer", "Activity created. There is no saved state, playing: false");
        }

        setPage();
        ControlButtonSetting();
        startStreaming();
    }
    private void cut_title(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    private void ControlButtonSetting(){
        Button up = (Button)this.findViewById(R.id.up_Button);
        up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch ( event.getAction() ) {
                    case MotionEvent.ACTION_DOWN:
                        new WebConnect().execute("go?direction=1");
                        break;
                    case MotionEvent.ACTION_UP:
                        new WebConnect().execute("stop?direction=1");
                        break;
                }
                return false;
            }
        });
        Button down = (Button)this.findViewById(R.id.down_Button);
        down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch ( event.getAction() ) {
                    case MotionEvent.ACTION_DOWN:
                        new WebConnect().execute("go?direction=2");
                        break;
                    case MotionEvent.ACTION_UP:
                        new WebConnect().execute("stop?direction=2");
                        break;
                }
                return false;
            }
        });
        Button left = (Button)this.findViewById(R.id.left_Button);
        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch ( event.getAction() ) {
                    case MotionEvent.ACTION_DOWN:
                        new WebConnect().execute("go?direction=3");
                        break;
                    case MotionEvent.ACTION_UP:
                        new WebConnect().execute("stop?direction=3");
                        break;
                }
                return false;
            }
        });
        Button right = (Button)this.findViewById(R.id.right_Button);
        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch ( event.getAction() ) {
                    case MotionEvent.ACTION_DOWN:
                        new WebConnect().execute("go?direction=4");
                        break;
                    case MotionEvent.ACTION_UP:
                        new WebConnect().execute("stop?direction=4");
                        break;
                }
                return false;
            }
        });
    }
    private void startStreaming(){
        //nativeInit();
        is_playing_desired = true;
        //nativePlay();
    }
    private void setPage(){

        Intent setPageiIntent = this.getIntent();
        String first = setPageiIntent.getStringExtra("First");
        if(first.equals("Y"))
        {
            guide_page.setVisibility(View.VISIBLE);
        }
        else
        {
            guide_page.setVisibility(View.INVISIBLE);
        }

        list_page.setVisibility(View.INVISIBLE);
        list_page_status = false;
    }

    private void setListPage()
    {
        if(list_page_status== false)
        {
            list_page.setVisibility(View.VISIBLE);
            list_page_status = true;
        }
        else
        {
            list_page.setVisibility(View.INVISIBLE);
            list_page_status = false;
        }
    }


    public void click(View v){
        switch(v.getId()){

            case R.id.guide_button:
                    guide_page.setVisibility(View.INVISIBLE);
                break;
            case R.id.led_button:

                break;
            case R.id.music_button:

                break;
            case R.id.list_button:

                setListPage();
                break;
            case R.id.sitting_button:
                Intent sitting_intent = new Intent();
                sitting_intent .putExtra("type","sitting"); // told SelectPage go to which tab
                sitting_intent.setClass(Tutorial3.this , org.freedesktop.gstreamer.tutorials.tutorial_3.SelectActivity.class);
                startActivity(sitting_intent);
                break;
            case R.id.album_button:
                Intent album_intent = new Intent();
                album_intent .putExtra("type","album"); // told SelectPage go to which tab
                album_intent.setClass(Tutorial3.this , org.freedesktop.gstreamer.tutorials.tutorial_3.SelectActivity.class);
                startActivity(album_intent);
                break;
            case R.id.count_button:
                Intent count_intent = new Intent();
                count_intent .putExtra("type","count"); // told SelectPage go to which tab
                count_intent.setClass(Tutorial3.this , org.freedesktop.gstreamer.tutorials.tutorial_3.SelectActivity.class);
                startActivity(count_intent);
                break;

        }
    }


    protected void onSaveInstanceState (Bundle outState) {
        Log.d ("GStreamer", "Saving state, playing:" + is_playing_desired);
        outState.putBoolean("playing", is_playing_desired);
    }

    protected void onDestroy() {
        nativeFinalize();
        super.onDestroy();
    }

    // Called from native code. This sets the content of the TextView from the UI thread.
    private void setMessage(final String message) {
        final TextView tv = (TextView) this.findViewById(R.id.textview_message);
        runOnUiThread (new Runnable() {
          public void run() {
            tv.setText(message);
          }
        });
    }

    // Called from native code. Native code calls this once it has created its pipeline and
    // the main loop is running, so it is ready to accept commands.
    private void onGStreamerInitialized () {
        Log.i ("GStreamer", "Gst initialized. Restoring state, playing:" + is_playing_desired);
        // Restore previous playing state
        if (is_playing_desired) {
            nativePlay();
        } else {
            nativePause();
        }

        // Re-enable buttons, now that GStreamer is initialized
        final Activity activity = this;
        runOnUiThread(new Runnable() {
            public void run() {
//                activity.findViewById(R.id.button_play).setEnabled(true);
//                activity.findViewById(R.id.button_stop).setEnabled(true);
            }
        });
    }

    static {
        System.loadLibrary("gstreamer_android");
        System.loadLibrary("tutorial-3");
        nativeClassInit();
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int width,
            int height) {
        Log.d("GStreamer", "Surface changed to format " + format + " width "
                + width + " height " + height);
        nativeSurfaceInit (holder.getSurface());
    }

    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("GStreamer", "Surface created: " + holder.getSurface());
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("GStreamer", "Surface destroyed");
        nativeSurfaceFinalize ();
    }

}
