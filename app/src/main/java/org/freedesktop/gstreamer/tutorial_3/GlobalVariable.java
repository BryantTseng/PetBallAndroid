package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.app.Application;

/**
 * Created by bryant on 2/5/18.
 */

public class GlobalVariable extends Application {
   private String roomii_IP = "172.20.10.14";
   private String database_IP = "init";
   private int LoginState = 0;
   private int LightColor = 0;
   private int ControlerLocation = 0;
   private int Sound = 0;
   private int VideoQuality = 0;

   public String getDB_IP(){
       return this.database_IP;
   }
   public String getRoomii_IP(){
       return this.roomii_IP;
   }
   public void setRoomii_IP(String ip){
       this.roomii_IP=ip;
   }
   public void setLoginState(int num){LoginState=num;}
   public int getLoginState(){return LoginState;}


   //Yellow color is 0. Blue color is 1, random is 2
   public void setLightColor(int color){LightColor = color;}
   public int getLightColor(){return LightColor;}

   //Left is 0. Right is 1.
   public void setControlerLocation(int loca){ControlerLocation = loca;}
   public int getControlerLocation(){return ControlerLocation;}

   //Castanets is 0
   public void setSound(int sound){Sound = sound;}
   public int getSound(){return Sound;}

   //720P is 0
   public void setVideoQuality(int quality){VideoQuality = quality;}
   public int getVideoQuality(){return VideoQuality;}
}
