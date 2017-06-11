package com.ark.android.rxbinding.rxpalettle;

import android.support.v7.graphics.Palette;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 *
 * Created by Ark on 6/11/2017.
 */

public abstract class PaletteConsumer implements Observer<List<Palette.Swatch>> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }
}
