package com.example.f1t.monitor;


import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.util.Pair;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.content.PermissionChecker;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.UiSettings;
import com.example.f1t.ExData;
import com.example.f1t.R;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;


public class MonitorView implements PlatformView, MethodChannel.MethodCallHandler{
    Context context;
    View view;
    TextureMapView mMapView;
    AMap aMap;
    public MonitorView(Context context, FlutterEngine flutterEngine, int id) {

        this.context = context;

        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), "three_monitor_channel");
        methodChannel.setMethodCallHandler(this);

        MapsInitializer.updatePrivacyShow(context, true, true);
        MapsInitializer.updatePrivacyAgree(context, true);
        view = LayoutInflater.from(context).inflate(R.layout.one_monitor_map, null, true);

        mMapView = (TextureMapView) view.findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(ExData.savedInstanceState);
        //初始化地图控制器对象
        aMap = mMapView.getMap();
        if (aMap == null) {
            aMap = mMapView.getMap();
        }
        if (aMap != null) {
            aMap.clear();
            UiSettings uiSettings = aMap.getUiSettings();
            uiSettings.setRotateGesturesEnabled(false);//禁止地图旋转手势
            uiSettings.setTiltGesturesEnabled(false);//禁止倾斜手势
            uiSettings.setZoomControlsEnabled(false);
            uiSettings.setScaleControlsEnabled(false);//设置比例尺控件是否可见
        }

    }
    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {

    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void dispose() {

    }
}



