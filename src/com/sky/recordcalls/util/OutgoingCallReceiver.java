package com.sky.recordcalls.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.sky.recordcalls.MainService;

public class OutgoingCallReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		// then you use
		boolean enableRec = prefs.getBoolean("EnableRecord", true);
		if (enableRec)
		{
			Log.d(OutgoingCallReceiver.class.getSimpleName(), intent.toString());
			Toast.makeText(context, "Outgoing call catched!", Toast.LENGTH_LONG).show();
			// TODO: Handle outgoing call event here
			Intent i = new Intent(context, MainService.class);
			context.startService(i);
		}
	}
}
