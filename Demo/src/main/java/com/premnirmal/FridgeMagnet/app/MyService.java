package com.premnirmal.FridgeMagnet.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.premnirmal.FridgeMagnet.FridgeMagnetRequirements;
import com.premnirmal.FridgeMagnet.RefrigeratorService;

/**
 * Created by prem on 7/20/14.
 * Desc: Example on how to use {@link com.premnirmal.FridgeMagnet.RefrigeratorService}
 */
public class MyService extends RefrigeratorService {

    private static final String TAG = "Refrigerator";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected Notification createNotification() {
        Intent notificationIntent = new Intent(this, ParanormalActivity.class);
        return new Notification.Builder(getApplicationContext())
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(PendingIntent.getActivity(this, 0, notificationIntent, 0))
                .setContentTitle("Hello")
                .build();
    }

    @Override
    protected FridgeMagnetRequirements getIcon() {
        return new FridgeMagnetRequirements() {
            @Override
            public View getIconView(Context context) {
                ImageView icon = new ImageView(context);
                icon.setImageResource(R.drawable.ic_launcher);
                return icon;
            }

            @Override
            public int getRemoveIconResID() {
                return -1;
            }

            @Override
            public boolean removeIconShouldBeResponsive() {
                return true;
            }

            @Override
            public boolean shouldStickToWall() {
                return true;
            }

            @Override
            public boolean shouldFlingAway() {
                return true;
            }
        };
    }

    @Override
    public void onFlingAway() {
        Log.d(TAG,"onFlingAway()");
    }

    @Override
    public void onMove(float x, float y) {

    }

    @Override
    public void onIconClick(View icon, float iconXPose, float iconYPose) {
        Log.d(TAG,"Icon clicked!");
    }

    @Override
    public void onIconDestroyed() {
        Log.d(TAG,"onIconDestroyed()");
        stopSelf();
    }

}
