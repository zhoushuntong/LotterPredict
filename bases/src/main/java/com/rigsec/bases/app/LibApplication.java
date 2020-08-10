package com.rigsec.bases.app;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.rigsec.arounter.ARouterUtils;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class LibApplication extends Application {

    private static Context appInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        //initRealm(this);
        appInstance = this;
        InitialService.startInitialService(this,InitialService.ACTION_INITIAL_ALL);

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static Context getAppInstance(){
        return appInstance;
    }
    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        Log.d("Application", "onTerminate");
        super.onTerminate();
        //Realm.getDefaultInstance().close();
        //AppConfig.INSTANCE.closeExecutor();
        ARouterUtils.destroy();
    }


    /**
     * 低内存的时候执行
     */
    @Override
    public void onLowMemory() {
        Log.d("Application", "onLowMemory");
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }


    /**
     * HOME键退出应用程序
     * 程序在内存清理的时候执行
     */
    @Override
    public void onTrimMemory(int level) {
        Log.d("Application", "onTrimMemory");
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN){
            Glide.get(this).clearMemory();
        }
        Glide.get(this).trimMemory(level);
    }

    /**
     * onConfigurationChanged
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d("Application", "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }


    /**
     * 初始化数据库
     * @param application               application
     */
/*    public void initRealm(Application application){
        Realm.init(application);
        RealmConfiguration realmConfig = new RealmConfiguration
                .Builder()
                .name(Constant.REALM_NAME)
                .schemaVersion(Constant.REALM_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.getInstance(realmConfig);
        Realm.setDefaultConfiguration(realmConfig);
    }*/

    @Override
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);
    }
}
