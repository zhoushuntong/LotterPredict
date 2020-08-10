package com.rigsec.lotteranalsis.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;

import com.rigsec.lotteranalsis.R;

/**
 * @ProjectName: LotterAnalsis
 * @Package: com.rigsec.lotteranalsis.view
 * @ClassName: LimitedNumberEditText
 * @Description: java类作用描述
 * @Author: 唐朝
 * @CreateDate: 2020/1/8 15:11
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/1/8 15:11
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class LimitedNumberEditText extends AppCompatEditText {

    // 最小数字
    private int minNumber=0;
    //最大数字
    private int maxNumber=0;

    private StringBuilder stringBuilder = new StringBuilder();
    public LimitedNumberEditText(Context context) {
        super(context);
    }

    public LimitedNumberEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LimitedNumberEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initial(context,attrs);
        //addFilter();
        addTextWatcher();
    }

    @Nullable
    @Override
    public Editable getText() {
        return super.getText();
    }

    void initial(Context context,AttributeSet attr){
        TypedArray array = context.obtainStyledAttributes(attr, R.styleable.DecimalEditText);
        minNumber = array.getInteger(R.styleable.DecimalEditText_minNumber,1);
        maxNumber = array.getInteger(R.styleable.DecimalEditText_maxNumber,33);
        array.recycle();
    }

    void addFilter(){
        setFilters(new InputFilter[]{new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                Log.d("TEST","source->" + source + "--start->" + start + " " + "--end->" + end+ dest.toString() + "--dstart->" + dstart + "--dend->" + dend);
                int number = Integer.parseInt(stringBuilder.toString());
                if (number>maxNumber){
                    return null;
                }
                String lastInputContent = dest.toString();

                return null;

            }
        }});
    }

    void addTextWatcher(){
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence,int start, int count, int after) {
                Log.d("###beforeTextChanged",charSequence+"start="+start+"count=" +count + "after"+after);
            }

            @Override
            public void onTextChanged(CharSequence charSequence,int start, int before, int count) {
                Log.d("###onTextChanged",charSequence+"start="+start+"count=" +count + "before"+before);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d("a###fterTextChanged",editable.toString());
            }
        });
    }
}
