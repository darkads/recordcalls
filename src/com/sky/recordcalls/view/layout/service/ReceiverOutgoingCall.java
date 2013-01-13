package com.sky.recordcalls.view.layout.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
//import b.b.d.b;
//import com.record.my.call.controller.l;
//import com.record.my.call.view.layout.ActivityFirstPage;
//import com.record.my.call.view.layout.ActivityRenameManager;

public class ReceiverOutgoingCall extends BroadcastReceiver
{
//  private Context a;
//  private Intent b;
//
//  private String a()
//  {
//    String str1 = this.b.getStringExtra("android.intent.extra.PHONE_NUMBER");
//    com.nathaniel.lib.function.c.a.a("outgoingCall: " + str1);
//    if (str1 != null);
//    Object localObject;
//    try
//    {
//      String str3 = l.c(this.a, str1);
//      localObject = ActivityRenameManager.a(this.a, "Outgoing_Call", str3);
//      break label82;
//      String str2 = b.a("_");
//      localObject = str2;
//    }
//    catch (Exception localException)
//    {
//      com.nathaniel.lib.function.c.a.a(localException);
//      localObject = b.a("_");
//    }
//    label82: return localObject;
//  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
//    int i = 1;
//    this.a = paramContext;
//    this.b = paramIntent;
//    com.nathaniel.lib.function.e.c localc = new com.nathaniel.lib.function.e.c(paramContext);
//    ActivityFirstPage.a();
//    com.nathaniel.lib.function.c.a.a("ReceiverOutgoingCall stage 1");
//    StringBuilder localStringBuilder1 = new StringBuilder("isRinging(): ");
//    label99: String str2;
//    label131: boolean bool;
//    if (((TelephonyManager)this.a.getSystemService("phone")).getCallState() == i)
//    {
//      int k = i;
//      StringBuilder localStringBuilder2 = localStringBuilder1.append(k).append(" - isStateOffhook(): ");
//      if (((TelephonyManager)this.a.getSystemService("phone")).getCallState() != 2)
//        break label268;
//      int n = i;
//      StringBuilder localStringBuilder3 = localStringBuilder2.append(n).append(" - isIdle(): ");
//      if (((TelephonyManager)this.a.getSystemService("phone")).getCallState() != 0)
//        break label274;
//      com.nathaniel.lib.function.c.a.a(i);
//      if ((localc.b("isServiceRunning")) && (!com.nathaniel.lib.function.c.c.a(paramContext, ServiceTempOutgoing.class)))
//      {
//        String str1 = this.b.getStringExtra("android.intent.extra.PHONE_NUMBER");
//        str2 = l.a(this.a, str1);
//        com.nathaniel.lib.function.c.a.a("uniqueKey: " + str2);
//        if (!a.a.a.a.a.a(str2))
//          break label279;
//        bool = new com.record.my.call.model.a.a(this.a, "Unknown Contact").e;
//      }
//    }
//    while (true)
//    {
//      if (bool)
//      {
//        localc.a("recordName", a());
//        paramContext.startService(new Intent(paramContext, ServiceTempOutgoing.class));
//      }
//      return;
//      int m = 0;
//      break;
//      label268: int i1 = 0;
//      break label99;
//      label274: int j = 0;
//      break label131;
//      label279: com.record.my.call.model.a.a locala1 = new com.record.my.call.model.a.a(this.a, str2);
//      com.nathaniel.lib.function.c.a.a("contact.isOutgoingCall: " + locala1.e);
//      if (locala1.g < 0L)
//      {
//        com.nathaniel.lib.function.c.a.a("Known number and not listed on contact database");
//        com.record.my.call.model.a.a locala2 = new com.record.my.call.model.a.a(this.a, "Known Contact");
//        com.nathaniel.lib.function.c.a.a("contact.isOutgoingCall: " + locala2.e);
//        bool = locala2.e;
//      }
//      else
//      {
//        com.nathaniel.lib.function.c.a.a("Known and listed");
//        bool = locala1.e;
//      }
//    }
  }
}
