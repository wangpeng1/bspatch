package org.hyxf.frame.common;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * patch update task
 * Created by qiudongchao on 2015/9/7.
 */
public class GPatchTask extends AsyncTask<Void,Void,String>{

    private String mNewApk;
    private String mPatch;
    private Context mCtx;

    public GPatchTask(Context ctx, String newApk,String patch){
        mNewApk = newApk;
        mPatch = patch;
        mCtx = ctx;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try{
            int flag = GPatch.patch(mCtx,mNewApk,mPatch);
            if(flag == 0){
                return mNewApk;
            }else {
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(!TextUtils.isEmpty(s)){
            GPatch.installApk(mCtx,s);
        }else {
            Toast.makeText(mCtx,"patch update failed",Toast.LENGTH_SHORT).show();
        }
    }
}
