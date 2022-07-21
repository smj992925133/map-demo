package com.example.f1t;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.f1t.monitor.MonitorFactory;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registry.registerViewFactory("threemonitor", new MonitorFactory(flutterEngine));
        ExData.context=MainActivity.this;
        ExData.activity=MainActivity.this;
        ExData.savedInstanceState=savedInstanceState;

    }
    PlatformViewRegistry registry;
    private FlutterEngine flutterEngine;
    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);
        registry = flutterEngine.getPlatformViewsController().getRegistry();
        this.flutterEngine = flutterEngine;

    }
}
