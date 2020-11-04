package com.scanlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ScannerContract extends ActivityResultContract<Integer, Uri> {
    public ScannerContract() {
    }

    @NonNull
    public Intent createIntent(@NonNull Context context, Integer input) {
        Intent intent = new Intent(context, ScanActivity.class);
        intent.putExtra(ScanConstants.OPEN_INTENT_PREFERENCE, input);
        return intent;
    }

    public Uri parseResult(int resultCode, @Nullable Intent intent) {
        return resultCode == Activity.RESULT_OK ? (Uri) intent.getExtras().getParcelable(ScanConstants.SCANNED_RESULT) : null;
    }
}
