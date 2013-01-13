package com.sky.recordcalls.view.layout.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
//import b.b.d.b;
//import com.record.my.call.controller.l;
//import com.record.my.call.view.layout.ActivityFirstPage;
//import com.record.my.call.view.layout.ActivityRenameManager;

public class ReceiverIncomingCall extends BroadcastReceiver
{
//  private Context a;
//  private Intent b;
//
//  private String a()
//  {
//    String str1 = this.b.getStringExtra("incoming_number");
//    com.nathaniel.lib.function.c.a.a("incomingCall: " + str1);
//    if (str1 != null);
//    Object localObject;
//    try
//    {
//      String str3 = l.c(this.a, str1);
//      localObject = ActivityRenameManager.a(this.a, "Incoming_Call", str3);
//      break;
//      String str2 = b.a("_");
//      localObject = str2;
//    }
//    catch (Exception localException)
//    {
//      localObject = b.a("_");
//    }
//    return localObject;
//  }

//  private boolean b()
//  {
//    if (((TelephonyManager)this.a.getSystemService("phone")).getCallState() == 1);
//    for (boolean bool = true; ; bool = false)
//      return bool;
//  }
//
  public void onReceive(Context paramContext, Intent paramIntent)
  {
//    boolean bool1 = true;
//    this.a = paramContext;
//    this.b = paramIntent;
//    com.nathaniel.lib.function.e.c localc = new com.nathaniel.lib.function.e.c(paramContext);
//    ActivityFirstPage.a();
//    com.nathaniel.lib.function.c.a.a("ReceiverIncomingCall stage 1");
//    StringBuilder localStringBuilder1 = new StringBuilder("isRinging(): ").append(b()).append(" - isStateOffhook(): ");
//    boolean bool2;
//    String str2;
//    com.record.my.call.model.a.a locala;
//    if (((TelephonyManager)this.a.getSystemService("phone")).getCallState() == 2)
//    {
//      bool2 = bool1;
//      StringBuilder localStringBuilder2 = localStringBuilder1.append(bool2).append(" - isIdle(): ");
//      if (((TelephonyManager)this.a.getSystemService("phone")).getCallState() != 0)
//        break;
//      com.nathaniel.lib.function.c.a.a(bool1);
//      if ((b()) && (localc.b("isServiceRunning")) && (!com.nathaniel.lib.function.c.c.a(paramContext, ServiceTempIncoming.class)))
//      {
//        String str1 = this.b.getStringExtra("incoming_number");
//        str2 = l.a(this.a, str1);
//        com.nathaniel.lib.function.c.a.a("uniqueKey: " + str2);
//        if (!a.a.a.a.a.a(str2))
//          break;
//        locala = new com.record.my.call.model.a.a(this.a, "Unknown Contact");
//      }
//    }
//    while (true)
//    {
//      if (locala.d)
//      {
//        localc.a("recordName", a());
//        paramContext.startService(new Intent(paramContext, ServiceTempIncoming.class));
//      }
//      return;
//      bool2 = false;
//      break;
//      bool1 = false;
//      break;
//      locala = new com.record.my.call.model.a.a(this.a, str2);
//      if (locala.g < 0L)
//        locala = new com.record.my.call.model.a.a(this.a, "Known Contact");
//    }
  }
}
