package com.awesomeproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Context;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.phoenixcapture.camerakit.FaceBox;

import ai.tech5.pheonix.capture.controller.FaceCaptureController;
import ai.tech5.pheonix.capture.controller.FaceCaptureListener;

public class RNairsnapModule extends ReactContextBaseJavaModule implements FaceCaptureListener {
     Context context;
    public RNairsnapModule (@Nullable ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext.getApplicationContext();

//        Log.d(" React Module", "Logging" + controller.toString());

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
//            callback.invoke(null, message);
            Activity activity = getCurrentActivity();
            Log.d("Logging Message", "Message " + message);
            FaceCaptureController controller = FaceCaptureController.getInstance();
            controller.startFaceCapture("", activity, new FaceCaptureListener() {
                @Override
                public void onFaceCaptured(byte[] bytes, FaceBox faceBox) {
                    callback.invoke(null, "onFaceCaptureSuccess");
                }

                @Override
                public void OnFaceCaptureFailed(String s) {
                    callback.invoke(null, "OnFaceCaptureFailed " + s);
                }

                @Override
                public void onCancelled() {
                    callback.invoke(null, "onCancelled");
                }

                @Override
                public void onTimedout(byte[] bytes) {
                    callback.invoke(null, "onTimedout");
                }
            });
        }catch (Exception e){
            callback.invoke(null, e.getLocalizedMessage());
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
