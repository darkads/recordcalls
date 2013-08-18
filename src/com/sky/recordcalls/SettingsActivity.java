package com.sky.recordcalls;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SettingsActivity extends Activity
{

	private final String TAG = "SettingsActivity";
	private NotificationHelper notificationHelper;
	private final int SETTINGS_ID = 2;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//		Log.i(TAG, "SettingsActivity created");
//		Button createNoti = (Button) findViewById(R.id.createNotiBtn);
//		notificationHelper = new NotificationHelper(this, SETTINGS_ID);
//		createNoti.setOnClickListener(new OnClickListener()
//		{
//
//			@Override
//			public void onClick(View v)
//			{
//				notificationHelper.createNotification();
//			}
//		});
	}

}
