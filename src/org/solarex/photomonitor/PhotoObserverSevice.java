
package org.solarex.photomonitor;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;

public class PhotoObserverSevice extends Service {
    private PhotoObserver photoObserver;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        Utils.log("PhotoObserverService onCreate --> enter");
        if (!Utils.isSdcardAvailable()) {
            Utils.log("sdcard unavailable");
            return;
        }
        String photoPath = Environment.getExternalStorageDirectory().toString() + "/Па»ъ";
        photoObserver = new PhotoObserver(photoPath);
        Utils.log("PhotoObserverService onCreate --> exit");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        super.onStartCommand(intent, flags, startId);
        Utils.log("PhotoObserverService onStartCommand --> enter");
        photoObserver.startWatching();
        Utils.log("PhotoObserverService onStartCommand --> exit");
        return 0;
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        Utils.log("PhotoObserverService onDestory --> enter");
        photoObserver.stopWatching();
        Utils.log("PhotoObserverService onDestory --> exit");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

}
