package com.sky.recordcalls.util;

import com.sky.recordcalls.MainService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class Record extends BroadcastReceiver
{
	Boolean nowRecording = false;
	int callNumber = 0;
//	String previousState = TelephonyManager.EXTRA_STATE_IDLE;

	@Override
	public void onReceive(Context context, Intent intent)
	{
		Bundle bundle = intent.getExtras();
		String state = bundle.getString(TelephonyManager.EXTRA_STATE);
		SharedPreferences sharedpref = context.getSharedPreferences("com.sky.recordcalls", Context.MODE_PRIVATE);
//		SharedPreferences.Editor editor = login.edit();
//		editor.putString("emailLogin", connectCheck.getUserEmail());
//		editor.putString("pwLogin", connectCheck.getPassword());
//		editor.putString("userName", connectCheck.getUserName());
//		editor.putString("userID", connectCheck.getUserID());
//		editor.putString("userDB_NMID", connectCheck.getUserFbTwNmID());
//		editor.commit();
		

		if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING))
		{
			// Log.e("RECORD", "Phone is ringing");
			// Toast.makeText(context, "Phone is ringing", Toast.LENGTH_SHORT).show();

			// Intent i = new Intent(context, MainService.class);
			// i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			// context.startService(i);
		}
		if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK))
		{
			Log.d("Record", "Phone is offhook");
			callNumber = sharedpref.getInt("CallNumber", 0);
			// context.stopService(i);
			if (callNumber == 0)
			{
//				previousState = TelephonyManager.EXTRA_STATE_OFFHOOK;
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
			if(callNumber < 0)
			{
				callNumber = 0;
			}
			editor.putInt("CallNumber", callNumber);
			editor.commit();
//			previousState = TelephonyManager.EXTRA_STATE_IDLE;
			
		}
	}
}
