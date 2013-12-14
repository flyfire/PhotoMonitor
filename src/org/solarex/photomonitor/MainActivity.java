
package org.solarex.photomonitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView tv = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.log("MainActivity onCreate --> enter");
        tv = (TextView)this.findViewById(R.id.tv);
        Utils.log("MainActivity onCreate --> exit");
    }
    
    public void doClick(View view)
    {
        Utils.log("MainActivity doClick --> enter");
        switch (view.getId()) {
            case R.id.start:
                Utils.log("start clicked");
                this.startService(new Intent(this, PhotoObserverSevice.class));
                break;
            case R.id.stop:
                Utils.log("stop clicked");
                if (this.stopService(new Intent(this, PhotoObserverSevice.class))) {
                    Utils.log("PhotoObserverService stoped");
                }else{
                    Utils.log("PhotoObserverService stop failed");
                }
                break;
            case R.id.log:
                Utils.log("refresh clicked");
                tv.setText(Utils.accessLogMsg);
                break;
            case R.id.clear:
                Utils.log("clear clicked");
                tv.setText("");
                Utils.accessLogMsg = "";
                break;
            default:
                Utils.log("unknown component");
                break;
        }
        Utils.log("MainActivity doClick --> exit");
    }
    
}
