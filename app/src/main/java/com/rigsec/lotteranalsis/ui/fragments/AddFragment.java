package com.rigsec.lotteranalsis.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
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

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AddFragment extends Fragment {

    private final String TAG = AddFragment.class.getCanonicalName();
    private final String TAG1 = AddFragment.class.getSimpleName();
    private final String TAG2 = AddFragment.class.getName();
    private Context mContext;
    Unbinder unbinder;
    private String lotteryType;

    /*@BindViews({R.id.et_one,R.id.et_two,R.id.et_three,R.id.et_four,R.id.et_five,R.id.et_six,R.id.et_seven})
    List<EditText> mEditNumber;*/

    public static AddFragment newInstance(String type) {
        AddFragment fragment = new AddFragment();
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
        View root = inflater.inflate(R.layout.fragment_add_lottery, container, false);
        unbinder= ButterKnife.bind(this,root);
        mContext = getActivity();
        //mEditNumber.get(0).addTextChangedListener(inputWatch(mEditNumber.get(0)));
        return root;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
    public TextWatcher inputWatch(final EditText input) {
        return new TextWatcher() {

            String permitNumber;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("###beforeTextChanged",s+"start="+start+"count=" +count + "after"+after);
                permitNumber = s.toString();
                Log.d("","");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("###onTextChanged",s+"start="+start+"count=" +count + "before"+before);
                String words = s.toString();
                //首先内容进行非空判断，空内容（""和null）不处理
                if (!TextUtils.isEmpty(words)) {
                    //1-100的正则验证
                    Pattern p = Pattern.compile("^(0[1-9]|[0-3]|1\\d|2\\d|3[0-3])$");
                    Matcher m = p.matcher(words);
                    if (m.matches()) {
                        //这个时候输入的是合法范围内的值
                    } else {
                        Log.e("###onTextChanged","permitNumber" + permitNumber);
                        if (TextUtils.isEmpty(permitNumber)){
                            input.setText("");
                        }else{
                            input.setText(permitNumber);
                            input.setSelection(1);
                        }
                        ToastUtil.showToast(mContext,"请输入范围在1-35之间的整数");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();
                Log.e("###afterTextChanged",str);
            }
        };
    }

}