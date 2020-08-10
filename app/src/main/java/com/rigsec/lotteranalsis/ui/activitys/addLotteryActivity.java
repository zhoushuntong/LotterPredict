package com.rigsec.lotteranalsis.ui.activitys;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.rigsec.lotteranalsis.R;
import com.rigsec.lotteranalsis.tools.StatusBarUtil;
import com.rigsec.lotteranalsis.ui.fragments.AddFragment;

import java.lang.reflect.Method;


public class addLotteryActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_historydata);
        Toolbar toolbar = findViewById(R.id.activity_main_toolbar);
        tabLayout = findViewById(R.id.tab_FindFragment_title);
        viewPager = findViewById(R.id.vp_add_lottery);
        StatusBarUtil.setColor(this,android.R.color.holo_blue_dark);
        final Fragment []fragmentDoubleColor = new Fragment[]{AddFragment.newInstance("double_color"),
                AddFragment.newInstance("daletou"),
                AddFragment.newInstance("sand"),
                AddFragment.newInstance("qxing")};
        final String[] titles = {"双色球", "大乐透","福彩3D","七星彩"};
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentDoubleColor[i];
            }

            @Override
            public int getCount() {
                return fragmentDoubleColor.length;
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(1).select();//设置第一个为选中
        toolbar.setTitle(R.string.title_add_lottery);

        setSupportActionBar(toolbar);
        //设置是否有NvagitionIcon（返回图标）
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // 设置Navigation的点击事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // Menu点击事件监听
        toolbar.setOnMenuItemClickListener(onMenuItemClick);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.right_addlottery_menu, menu);
        return true;
    }

    // Menu选项点击处理
    private Toolbar.OnMenuItemClickListener onMenuItemClick=new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            String msg = "";
            switch (item.getItemId()) {
                case R.id.action_item1:
                    msg += "Click item1";
                    break;
                case R.id.action_item2:
                    msg += "Click item2";
                    break;
            }
            if (!msg.equals("")) {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };
}
