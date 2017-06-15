# RxPalette
A reactive layer on top of android palette (easy and hassle-free) using [RxJava 2](https://github.com/ReactiveX/RxJava)

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-RxPalette-blue.svg?style=plastic)](https://android-arsenal.com/details/1/5882)

# Gradle
````
compile 'com.ark.android:RxPalette:1.0.1'
````

# how to use
#### easy just call

````
RxPalette.analyze(loadedImage)
                .subscribe(new PaletteConsumer() {
                    @Override
                    public void onNext(List<Palette.Swatch> swatches) {
                        Palette.Swatch swatch = swatches.get(0);
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                });
````                

and you can also make use of observable features and [RxAndroid](https://github.com/ReactiveX/RxAndroid) by calling in your application

````
.subscribeOn(Schedulers.io())
.observeOn(AndroidSchedulers.mainThread())  
````

#### That's it happy coding

# License

  The MIT License (MIT)

    Copyright (c) 2017 Ahmed basyouni

    Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
