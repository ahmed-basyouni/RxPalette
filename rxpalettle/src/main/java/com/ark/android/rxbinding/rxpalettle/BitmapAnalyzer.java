package com.ark.android.rxbinding.rxpalettle;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 *
 * Created by Ark on 6/11/2017.
 */

final class BitmapAnalyzer extends Observable<List<Palette.Swatch>>{

    private final Bitmap bitmap;

    BitmapAnalyzer(Bitmap bitmap){
        this.bitmap = bitmap;
    }

    @Override
    protected void subscribeActual(Observer<? super List<Palette.Swatch>> observer) {
        Listener listener = new Listener(observer);
        observer.onSubscribe(listener);
    }

    private class Listener implements Disposable {

        private final Observer<? super List<Palette.Swatch>> observer;

        Listener(Observer<? super List<Palette.Swatch>> observer) {
            this.observer = observer;
            startBitmapAnalysis();
        }

        private void startBitmapAnalysis() {
            if(!isDisposed()){
                Palette palette = Palette.from(bitmap).generate();

                List<Palette.Swatch> swatches = palette.getSwatches();

                if(!swatches.isEmpty()) {
                    this.observer.onNext(swatches);
                    this.observer.onComplete();
                }else
                    this.observer.onError(new Throwable("couldn't get colors from bitmap"));
            }
        }

        private final AtomicBoolean unsubscribed = new AtomicBoolean();

        @Override
        public void dispose() {
            if (unsubscribed.compareAndSet(false, true)) {
                observer.onError(new Throwable("Canceled"));
            }
        }

        @Override
        public boolean isDisposed() {
            return unsubscribed.get();
        }


    }
}
