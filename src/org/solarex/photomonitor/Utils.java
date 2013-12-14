package org.solarex.photomonitor;

import android.os.Environment;
import android.util.Log;

public class Utils {
    public static String TAG = "Solarex";
    public static String accessLogMsg = "";
    
    public static boolean isSdcardAvailable(){
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
    
    public static void log(String msg)
    {
        Log.d(TAG, msg != null ? msg : "null");
    }
}
