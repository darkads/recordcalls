package com.sky.recordcalls.view.layout.service;

import android.content.Intent;
import android.os.IBinder;
import android.telephony.TelephonyManager;
//import com.record.my.call.view.layout.ActivityFirstPage;
import com.sky.recordcalls.view.layout.framework.FrameworkService;

public class ServiceRecordCall extends FrameworkService
{
//  private com.nathaniel.lib.b.b.a b;
  private com.sky.recordcalls.controller.a c;
  private TelephonyManager d;
//  private com.nathaniel.lib.function.advance.d.a e;
  private boolean f = false;

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
  }

  public void onDestroy()
  {
    super.onDestroy();
//    com.nathaniel.lib.function.c.a.a("ServiceRecordCall - onDestroy");
//    com.nathaniel.lib.function.advance.d.a.a();
//    this.b.a();
//    this.d.listen(this.c, 0);
//    this.c = null;
  }

//  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
//  {
//    if (!this.f)
//    {
//      this.f = true;
//      ActivityFirstPage.a();
//      this.b = new com.nathaniel.lib.b.b.a(this.a);
//      this.e = new com.nathaniel.lib.function.advance.d.a(this.a);
//      this.c = new com.sky.recordcalls.controller.a(this.a);
//      this.d = ((TelephonyManager)getSystemService("phone"));
//      this.d.listen(this.c, 32);
//      com.nathaniel.lib.function.c.a.a("Initialise System ServiceRecordCall");
//      this.b.a();
//    }
//    return 3;
//  }
}
