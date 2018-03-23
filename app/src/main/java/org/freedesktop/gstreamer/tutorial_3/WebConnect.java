package org.freedesktop.gstreamer.tutorials.tutorial_3;

/**
 * Created by will on 18年1月22日.
 */
import android.app.Activity;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import android.provider.Settings;
import android.util.Log;
import org.freedesktop.gstreamer.tutorials.tutorial_3.GlobalVariable;
import android.content.Context;

import org.json.JSONObject;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class WebConnect extends AsyncTask<String, Void, String> {
    private Context mContext;
    public WebConnect(Context _con){
        mContext=_con;
    }
    /*****************************************************/
       /*  This is a background process for connecting      */
      /*   to the arduino server and sending               */
     /*    the GET request withe the added data           */
    /*****************************************************/
    @Override
    protected String doInBackground(String... params) {
        try {
            /* Change the IP to the IP you set in the arduino sketch */
            GlobalVariable gv = (GlobalVariable)mContext;
            URL url = new URL("http://172.20.10.5/" + params[0]);
            Log.d("URL",url.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder result = new StringBuilder();
            JSONObject json_result = new JSONObject();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                Log.d("Response: ", "> " + inputLine);
                result.append(inputLine).append("\n");
            }
            try {
                json_result = new JSONObject(result.toString());
                //Log.d("JSON_result",json_result.toString());
            }catch(Exception e){
                Log.e("JSON","FAILED ON CREATE JSON");
            }
            in.close();
            connection.disconnect();




            try {
                if (json_result.getString("type") == "login") {
                    try {
                        if(json_result.getString("email")=="failed"){
                            //failed login
                        }else{
                            try {
                                //Log.d("GET JSON's roomii ip",json_result.getString("roomii_ip"));
                                gv.setRoomii_IP(json_result.getString("roomii_ip"));

                            }catch(Exception e){
                                Log.e("JSON","FAILED TO SET roomii ip");
                            }
                        }
                    }catch(Exception e){

                    }
                } else if (json_result.getString("type") == "signup") {

                }
            }catch(Exception e){
                Log.e("Type","FAILED IDENTIFY TYPE");
            }








            return result.toString();

        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
