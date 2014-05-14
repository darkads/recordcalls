package com.sky.recordcalls.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.sky.recordcalls.MainService;

public class Record extends BroadcastReceiver
{
	Boolean nowRecording = false;
	int callNumber = 0;

	// String previousState = TelephonyManager.EXTRA_STATE_IDLE;

	@Override
	public void onReceive(Context context, Intent intent)
	{
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		// then you use
		boolean enableRec = prefs.getBoolean("EnableRecord", true);
		if (enableRec)
		{
			Bundle bundle = intent.getExtras();
			String state = bundle.getString(TelephonyManager.EXTRA_STATE);
			SharedPreferences sharedpref = context.getSharedPreferences("com.sky.recordcalls", Context.MODE_PRIVATE);

			if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING))
			{
				
			}
			if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK))
			{
				Log.d("Record", "Phone is offhook");
				callNumber = sharedpref.getInt("CallNumber", 0);
				// context.stopService(i);
				if (callNumber == 0)
				{
					// previousState = TelephonyManager.EXTRA_STATE_OFFHOOK;
					callNumber++;
					SharedPreferences.Editor editor = sharedpref.edit();
					editor.putInt("CallNumber", callNumber);
					editor.commit();
					Intent i = new Intent(context, MainService.class);
					if (context.startService(i) != null)
					{
						Toast.makeText(context, "Service is already running! Stopping it first...", Toast.LENGTH_SHORT).show();
						context.stopService(i);
					}
					if (nowRecording == false)
					{
						context.startService(i);
						nowRecording = true;
					}
				}
			}
			if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE))
			{
				Log.d("Record", "Phone is idle");
				Intent i = new Intent(context, MainService.class);
				context.stopService(i);
				nowRecording = false;
				callNumber--;
				SharedPreferences.Editor editor = sharedpref.edit();
				if (callNumber < 0)
				{
					callNumber = 0;
				}
				editor.putInt("CallNumber", callNumber);
				editor.commit();

			}
		}
	}
	
}
