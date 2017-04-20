package com.pavlospt.lithoplayground;

import android.app.Application;
import com.facebook.litho.LithoWebKitInspector;
import com.facebook.soloader.SoLoader;
import com.facebook.stetho.Stetho;

import static com.facebook.stetho.Stetho.*;

public class LithoApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    SoLoader.init(this, false);
    initialize(
        newInitializerBuilder(this)
            .enableWebKitInspector(new LithoWebKitInspector(this))
            .build());
  }
}
