package com.sky.recordcalls.view.layout.framework;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
//import com.record.my.call.view.layout.ActivityFirstPage;

public class FrameworkService extends Service
{
  protected Context a;

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
//    super.onCreate();
//    this.a = this;
//    ActivityFirstPage.a();
  }

  public void onDestroy()
  {
    super.onDestroy();
  }
}
