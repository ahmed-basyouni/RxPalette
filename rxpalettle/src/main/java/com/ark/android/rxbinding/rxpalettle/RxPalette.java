package com.ark.android.rxbinding.rxpalettle;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;

import java.util.List;

import io.reactivex.Observable;


/**
 *
 * Created by Ark on 6/11/2017.
 */

public class RxPalette{

    public static Observable<List<Palette.Swatch>> analyze(Bitmap bitmap){
        return new BitmapAnalyzer(bitmap);
    }
}
