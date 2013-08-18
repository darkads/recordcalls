package com.sky.recordcalls.util;

import com.sky.recordcalls.MainService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class Record extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent)
	{
		Bundle bundle = intent.getExtras();
		String state = bundle.getString(TelephonyManager.EXTRA_STATE);

		if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING))
		{
//			Intent i = new Intent(context, MainService.class);
//			 i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//			 context.startService(i);
		}
		if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK))
		{
			Log.d("Record", "Phone is offhook");
			Intent i = new Intent(context, MainService.class);
			context.stopService(i);
//			if (context.startService(i) != null)
//			{
//				Toast.makeText(context, "Service is already running! Stopping it first...", Toast.LENGTH_SHORT).show();
//				context.stopService(i);
//			}
			context.startService(i);
		}
		if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE))
		{
			Log.d("Record", "Phone is idle");
			Intent i = new Intent(context, MainService.class);
			context.stopService(i);
		}
	}
}
