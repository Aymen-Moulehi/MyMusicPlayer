package com.moulehi.mymusicplayer;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

public class AccessStorageCheckPermission {
    boolean checkPermission(Context context){
        int result = ContextCompat
                .checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);

        if(result == PackageManager.PERMISSION_GRANTED)
            return true;
        return false;
    }
}
