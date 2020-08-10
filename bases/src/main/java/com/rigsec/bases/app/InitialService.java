package com.rigsec.bases.app;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.rigsec.utils.common.LogUtils;


/**
 *  初始化第三方库
 *  2020.08.06 zdt
 * */

public class InitialService extends IntentService {

    public static String ACTION_INITIAL_ALL = "INITIAL_ALL";
    /*** default initial *********************************/
    public static String ACTION_INITIAL_DEFAULT = "INITIAL_DEFAULT";
    /*** optional initial *********************************/

    /*
    *  startAction initial different sdk or setting according to the action String
    */
    public static void startInitialService(Context context, String startAction){
        Intent intent = new Intent();
        intent.setAction(startAction);
        context.startService(intent);
    }
    public InitialService(String name) {
        super(name);
    }

    @Override
    public void setIntentRedelivery(boolean enabled) {
        super.setIntentRedelivery(enabled);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        initialApplication();
        initialDefault();
    }

    // request permission and make sure the network is available
    private void initialApplication(){
        //QQwebkit initial

    }

    private void initialDefault(){
        LogUtils.Builder builder = new LogUtils.Builder();
        builder.setBorderSwitch(true);
        builder.setGlobalTag("application");
        builder.setLogSwitch(true);
    }
}
