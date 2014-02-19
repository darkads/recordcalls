package com.sky.recordcalls.util;

import com.sky.recordcalls.MainService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class OutgoingCallReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent)
	{
		Log.d(OutgoingCallReceiver.class.getSimpleName(), intent.toString());
		Toast.makeText(context, "Outgoing call catched!", Toast.LENGTH_LONG).show();
		// TODO: Handle outgoing call event here
		Intent i = new Intent(context, MainService.class);
		context.startService(i);
	}
}
