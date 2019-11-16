package com.qgg.bitmapsample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogUtil.e(TAG, "设备 density=", getResources().getDisplayMetrics().density);
        LogUtil.e(TAG, "设备 densityDpi=", getResources().getDisplayMetrics().densityDpi);

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

        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inMutable = true;
//        options.inScaled = false;
//        options.inPreferredConfig = Bitmap.Config.RGB_565;
//        options.inSampleSize = 2;
//        options.outHeight = 100;
//        options.outWidth = 100;
//        options.inJustDecodeBounds = true;
        Bitmap bitmapXXXh1 = BitmapFactory.decodeResource(getResources(), R.drawable.pic_xxxhdpi, options);
        LogUtil.e(TAG, "bitmapXXXh", options.inDensity, options.inTargetDensity, options.inScreenDensity, options.outWidth);
        log("bitmapXXXh", bitmapXXXh1);

        try {
            // 从assets获取图片
            Bitmap bitmapAssets = BitmapFactory.decodeStream(getAssets().open("pic_assets.jpg"));
            // 获取assets得到的Bitmap的Density
            LogUtil.e(TAG, "bitmapAssets", bitmapAssets.getDensity());
            log("bitmapAssets", bitmapAssets);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Bitmap内存占用计算公式为：scale = targetDensity / density
        // memory = (bitmapWidth * scale + 0.5) * (bitmapHeight * scale + 0.5) * ColorType / inSampleSize / inSampleSize
    }

    private void log(String tag, Bitmap bitmap) {
        LogUtil.e(TAG, tag, bitmap.getByteCount(), "，getAllocationByteCount=", bitmap.getAllocationByteCount());
    }
}
