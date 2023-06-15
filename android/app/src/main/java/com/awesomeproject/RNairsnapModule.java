package com.awesomeproject;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.phoenixcapture.camerakit.FaceBox;

import ai.tech5.pheonix.capture.controller.FaceCaptureController;
import ai.tech5.pheonix.capture.controller.FaceCaptureListener;

public class RNairsnapModule extends ReactContextBaseJavaModule implements FaceCaptureListener {
    public RNairsnapModule (@Nullable ReactApplicationContext reactContext) {
        super(reactContext);

//        FaceCaptureController controller = FaceCaptureController.getInstance();
//        Log.d(" React Module", "Logging" + controller.toString());
//        controller.startFaceCapture("", RNairsnapModule.this, this);
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

            Log.d("Logging Message", "Message " + message);
        }catch (Exception e){
            callback.invoke(e, null);
        }
    }

    @ReactMethod
    public void getStatus(String name, Callback callback){
        try {
            String message = "Hellodd"+name;
            callback.invoke(null, message);

        }catch (Exception e){
            callback.invoke(e, null);
        }
    }

    @Override
    public void onFaceCaptured(byte[] bytes, FaceBox faceBox) {
        Log.d("RNAirsnapModule", "onFaceCaptured()");
    }

    @Override
    public void OnFaceCaptureFailed(String s) {

    }

    @Override
    public void onCancelled() {

    }

    @Override
    public void onTimedout(byte[] bytes) {

    }
}
