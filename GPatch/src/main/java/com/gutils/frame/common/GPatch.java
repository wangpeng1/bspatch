package com.gutils.frame.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;

import java.io.File;

/**
 * patch update
 */
public class GPatch {

    static {
        System.loadLibrary("gpatch");
    }

    private native static int bspatch(String oldPackage, String newPack, String patch);

    /**
     * get system application apk
     *
     * @return apk file patch
     */
    private static String getApkFile(Context context) {
        ApplicationInfo ai = context.getApplicationInfo();
        return ai.publicSourceDir;
    }

    /**
     * patch
     * @param oldPackage
     * @param newPack
     * @param patch
     * @return
     */
    public static int patch(String oldPackage, String newPack, String patch) {
        File patchFile = new File(patch);
        if(!patchFile.exists()){
            throw new IllegalArgumentException("patch is not a file");
        }
        return bspatch(oldPackage, newPack, patch);
    }

    /**
     * patch
     * @param context
     * @param newPack
     * @param patch
     * @return
     */
    public static int patch(Context context, String newPack, String patch) {
        if(context == null){
            throw new IllegalArgumentException("context is null");
        }
        return patch(getApkFile(context), newPack, patch);
    }

    /**
     * install Apk
     * @param context
     * @param newApk
     */
    public static void installApk(Context context,String newApk) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.fromFile(new File(newApk)),
                "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

}
