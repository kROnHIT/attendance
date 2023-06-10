package com.awesomeproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNairsnapModule extends ReactContextBaseJavaModule {
    public RNairsnapModule (@Nullable ReactApplicationContext reactContext) {
        super(reactContext);
    }
    @NonNull
    @Override
    public String getName() {
        return "RNairsnap";
    }

    @ReactMethod
    public void sayHello(String name, Callback callback){
        try {
            String message = "Hellodd"+name;
            callback.invoke(null, message);
        }catch (Exception e){
            callback.invoke(e, null);
        }
    }
}
