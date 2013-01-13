package com.sky.recordcalls;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class NotificationReceiverStopActivity extends Activity
{

	protected String TAG = "NotificationReceiverStopActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);

		// Send Broadcast and ends this activity.
		
		sendBroadcast();
	}

	private void sendBroadcast()
	{
		Log.d(TAG,"stoprecording");
		Intent broadcast = new Intent("com.sky.recordcalls.NotificationReceiverStopActivity");
		broadcast.setAction("stopRecording");
		this.sendBroadcast(broadcast);
		this.finish();	
	}
}
