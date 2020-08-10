package com.rigsec.lotteranalsis;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * @ProjectName: LotterAnalsis
 * @Package: com.rigsec.lotteranalsis
 * @ClassName: LotterApplication
 * @Description: java类作用描述
 * @Author: 唐朝
 * @CreateDate: 2019/10/20 19:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/10/20 19:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LotterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "0aac0b1fd6", true);

    }
}
