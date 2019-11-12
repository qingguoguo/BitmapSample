package com.qgg.bitmapsample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtil.e(TAG, getResources().getDisplayMetrics().density);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic);
        log("bitmap", bitmap);

        Bitmap bitmaph = BitmapFactory.decodeResource(getResources(), R.drawable.pic_hdpi);
        log("bitmaph", bitmaph);

        Bitmap bitmapXh = BitmapFactory.decodeResource(getResources(), R.drawable.pic_xhdpi);
        log("bitmapXh", bitmapXh);

        Bitmap bitmapXXh = BitmapFactory.decodeResource(getResources(), R.drawable.pic_xxhdpi);
        log("bitmapXXh", bitmapXXh);

        Bitmap bitmapXXXh = BitmapFactory.decodeResource(getResources(), R.drawable.pic_xxxhdpi);
        log("bitmapXXXh", bitmapXXXh);
    }

    private void log(String tag, Bitmap bitmap) {
        LogUtil.e(TAG, tag, bitmap.getByteCount(), "，getAllocationByteCount=", bitmap.getAllocationByteCount());
    }
}
