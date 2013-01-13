package com.sky.recordcalls.controller;

import android.app.Service;
import android.content.Context;
import android.telephony.PhoneStateListener;
//import com.nathaniel.lib.function.d.a.a.i;

public final class a extends PhoneStateListener
{
//  private static byte r;
//  private Context a;
//  private e b;
//  private com.nathaniel.lib.b.b.a c;
//  private com.nathaniel.lib.function.e.c d;
//  private com.nathaniel.lib.function.advance.d.a e;
//  private i f;
//  private com.nathaniel.lib.function.advance.g.a.a g;
//  private boolean h;
//  private String i;
//  private String j;
//  private boolean k;
//  private boolean l;
//  private boolean m;
//  private boolean n;
//  private boolean o;
//  private boolean p;
//  private boolean q;
//
//  public a(Object paramObject)
//  {
//    this.a = ((Context)paramObject);
//    h();
//    this.b = new e(this.a);
//    this.c = new com.nathaniel.lib.b.b.a(this.a);
//    this.e = new com.nathaniel.lib.function.advance.d.a(this.a);
//    this.g = new com.nathaniel.lib.function.advance.g.a.a(this.a);
//  }
//
//  private void a(String paramString)
//  {
//    com.nathaniel.lib.function.c.a.b("==Error==:" + paramString);
//    this.h = false;
//    this.g.a(paramString);
//    this.d.a("serviceMessage", paramString);
//    d();
//  }
//
//  private void c()
//  {
//    if ((this.q) && (!this.b.a()));
//    while (true)
//    {
//      return;
//      while (!f())
//        b.b.d.a.a();
//      if (this.p)
//        new d(this, (byte)0).execute(new Void[0]);
//      else
//        e();
//    }
//  }
//
//  private void d()
//  {
//    if ((this.q) && (!this.b.b()));
//    while (true)
//    {
//      return;
//      if (g())
//        new c(this, (byte)0).execute(new Void[0]);
//    }
//  }
//
//  private void e()
//  {
//    this.c.a();
//    com.nathaniel.lib.function.advance.d.a.a();
//    try
//    {
//      finalize();
//      label19: com.nathaniel.lib.function.c.a.a("Killing CallRecording Service");
//      ((Service)this.a).stopSelf();
//      return;
//    }
//    catch (Throwable localThrowable)
//    {
//      break label19;
//    }
//  }
//
//  private static boolean f()
//  {
//    if (r == 0);
//    for (boolean bool = true; ; bool = false)
//      return bool;
//  }
//
//  private static boolean g()
//  {
//    int i1 = 1;
//    if (r == i1);
//    while (true)
//    {
//      return i1;
//      int i2 = 0;
//    }
//  }
//
//  private void h()
//  {
//    this.i = "";
//    r = 0;
//    com.nathaniel.lib.function.c.a.a("state: STATE_IDLE");
//  }
//
//  public final void onCallStateChanged(int paramInt, String paramString)
//  {
//    super.onCallStateChanged(paramInt, paramString);
//    this.d = new com.nathaniel.lib.function.e.c(this.a);
//    this.j = this.d.a("recordName");
//    this.k = this.d.b("isNotificationIcon");
//    this.l = this.d.b("isShowReview");
//    this.o = this.d.b("isPreventSleep");
//    this.m = this.d.b("isNexiwave");
//    this.n = this.d.b("isAutomaticUpload");
//    this.p = this.d.b("isServiceRunning");
//    this.q = this.d.b("isRecordOnConnected");
//    com.nathaniel.lib.function.c.a.b("isCallActive: " + l.e(this.a) + " - state:'" + paramInt + "' - incomingNumber:'" + paramString + "'");
//    com.nathaniel.lib.function.c.a.a("isIdle: " + f() + " - isRecording: " + g());
//    if ((f()) && (paramInt == 2))
//    {
//      com.nathaniel.lib.function.c.a.a("stateOffHook - startCall");
//      c();
//    }
//    while (true)
//    {
//      return;
//      if ((g()) && (paramInt == 0))
//      {
//        com.nathaniel.lib.function.c.a.a("stateInIdle - donecall");
//        d();
//      }
//      else if ((f()) && (paramInt != 0))
//      {
//        com.nathaniel.lib.function.c.a.a("stateInIdle - nothing to do");
//      }
//    }
//  }
}
