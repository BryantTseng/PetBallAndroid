package org.freedesktop.gstreamer.tutorials.tutorial_3;

import android.app.Application;

/**
 * Created by bryant on 2/5/18.
 */

public class GlobalVariable extends Application {
   private String roomii_IP = "init";
   private String database_IP = "init";
   private int LoginState = 0;
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

}
