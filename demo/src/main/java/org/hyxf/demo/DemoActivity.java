package org.hyxf.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gutils.frame.common.GPatchTask;

import java.io.File;

/**
 * patch update demo
 */
public class DemoActivity extends Activity implements View.OnClickListener{
    private Button mBtnPatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        mBtnPatch = (Button)findViewById(R.id.btn_patch);
        mBtnPatch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String baseSDcard = getSDPath();
        if(!TextUtils.isEmpty(baseSDcard)){
            String newApk = baseSDcard + File.separator + "demo.apk";
            String patch = baseSDcard + File.separator + "demo.patch";

            GPatchTask task = new GPatchTask(this,newApk,patch);
            task.execute();
        }else {
            Toast.makeText(DemoActivity.this, "SDCard is not exit", Toast.LENGTH_SHORT).show();
        }
    }

    public String getSDPath(){
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED);  //判断sd卡是否存在
        if  (sdCardExist)
        {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        }
        return sdDir.toString();
    }
}
