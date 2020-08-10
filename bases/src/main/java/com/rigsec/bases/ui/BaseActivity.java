package com.rigsec.bases.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author zst
 * @date 20200820
 * 状态栏 工具栏 集成可适配
 * 屏幕适配集成
 *
 */
public abstract class BaseActivity<P extends BasePresent> extends AppCompatActivity {

    // present
    protected P mPresent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public abstract void initialView();
    public abstract void initialListener();
    public abstract void initialData();


}
