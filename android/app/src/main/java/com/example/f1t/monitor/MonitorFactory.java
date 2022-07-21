package com.example.f1t.monitor;

import android.content.Context;
import android.os.Bundle;


import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class MonitorFactory extends PlatformViewFactory {
    public final   FlutterEngine flutterEngine;
        public MonitorFactory( FlutterEngine flutterEngine) {
        super(StandardMessageCodec.INSTANCE);
            this.flutterEngine = flutterEngine;

        }

    @Override
    public PlatformView create(Context context, int viewId, Object args) {
        return new MonitorView(context,flutterEngine,viewId);
    }
}
