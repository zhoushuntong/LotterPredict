package com.rigsec.lotteranalsis.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.rigsec.lotteranalsis.R;
import com.rigsec.lotteranalsis.tools.ToastUtil;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainFragment extends Fragment {

    private final String TAG = MainFragment.class.getSimpleName();
    private Context mContext;
    Unbinder unbinder;
    private String lotteryType;
    @BindView(R.id.activity_main_toolbar)
    Toolbar mToolBar;

    public static MainFragment newInstance(String type) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString("mType", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle bundle = getArguments();
        if (bundle != null&& !bundle.isEmpty()){
            lotteryType = bundle.getString("mType");
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder= ButterKnife.bind(this,root);
        mContext = getActivity();
        return root;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}