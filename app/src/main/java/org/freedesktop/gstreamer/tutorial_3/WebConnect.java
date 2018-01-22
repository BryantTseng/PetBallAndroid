package org.freedesktop.gstreamer.tutorial_3;

/**
 * Created by will on 18年1月22日.
 */
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class WebConnect extends AsyncTask<String, Void, String> {



    /*****************************************************/
       /*  This is a background process for connecting      */
      /*   to the arduino server and sending               */
     /*    the GET request withe the added data           */
    /*****************************************************/
    @Override
    protected String doInBackground(String... params) {
        try {
            /* Change the IP to the IP you set in the arduino sketch */
            URL url = new URL("http://192.168.0.17/patball/?" + params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder result = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                result.append(inputLine).append("\n");

            in.close();
            connection.disconnect();
            return result.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
