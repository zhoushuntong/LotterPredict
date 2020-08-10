package com.rigsec.lotteranalsis.tools;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

/**
 * @ProjectName: LotterAnalsis
 * @Package: com.rigsec.lotteranalsis.tools
 * @ClassName: ToastUtil
 * @Description: java类作用描述
 * @Author: 唐朝
 * @CreateDate: 2019/12/23 20:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/12/23 20:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ToastUtil {

    public static void showToast(Context context,String info){
        Toast.makeText(context,info,Toast.LENGTH_LONG).show();
    }
}
