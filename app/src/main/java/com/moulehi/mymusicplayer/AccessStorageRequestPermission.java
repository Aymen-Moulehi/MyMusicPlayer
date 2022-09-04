package com.moulehi.mymusicplayer;

import android.Manifest;
import android.app.Activity;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class AccessStorageRequestPermission {
    void requestPermission(Activity activity){
        if(ActivityCompat.shouldShowRequestPermissionRationale(
                activity,
                Manifest.permission.READ_EXTERNAL_STORAGE
        ))
            Toast.makeText(
                    activity,
                    "Storage permission is required",
                    Toast.LENGTH_LONG
            ).show();
            
        ActivityCompat.
                requestPermissions(
                        activity,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        10
                );
    }
}
