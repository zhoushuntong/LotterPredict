package com.rigsec.lotteranalsis;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.rigsec.lotteranalsis.tools.StatusBarUtil;
import com.rigsec.lotteranalsis.ui.fragments.AddFragment;
import com.rigsec.lotteranalsis.ui.fragments.MainFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private int mCurrentPos = -1;
    private List<? extends Fragment> mFragmentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setTransparentForWindow(this);

        mFragmentList = Arrays.asList(
                MainFragment.newInstance(""),
                AddFragment.newInstance(""),
                AddFragment.newInstance(""),
                AddFragment.newInstance("")
        );
        BottomNavigationView navView = findViewById(R.id.bottom_main);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        switchFragmentIndex(0);
                        break;
                    case R.id.navigation_dashboard:
                        switchFragmentIndex(1);
                        break;
                    case R.id.navigation_notifications:
                        switchFragmentIndex(2);
                        break;
                    case R.id.navigation_setting:
                        switchFragmentIndex(3);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        switchFragmentIndex(0);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
    }

    private void switchFragmentIndex(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (mCurrentPos != -1) {
            fragmentTransaction.hide(mFragmentList.get(mCurrentPos));
        }
        if (!mFragmentList.get(position).isAdded()) {
            fragmentTransaction.add(R.id.fl_content, mFragmentList.get(position));
        }
        fragmentTransaction.show(mFragmentList.get(position)).commit();
        mCurrentPos = position;
    }

}
