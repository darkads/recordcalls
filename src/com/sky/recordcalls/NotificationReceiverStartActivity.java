package com.sky.recordcalls;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;

public class NotificationReceiverStartActivity extends Activity
{
	File pathString = Environment.getExternalStorageDirectory();
	String fileName = "", fileExt = "mp4";
	Button startRecBtn, stopRecBtn;
	MediaRecorder Callrecorder;
	int samplingRate = 44100;
	final int NOTIFICATION_ID_RECORDING = 1;

	protected String TAG = "NotificationReceiverStartActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);

		// initialise();
		sendBroadcast();
	}

	// Send Broadcast, create stop notification and ends this activity.
	public void sendBroadcast()
	{

		Intent broadcast = new Intent("com.sky.recordcalls.NotificationReceiverStartActivity");
//		broadcast.putExtra(AudioManager.EXTRA_SCO_AUDIO_STATE, AudioManager.)
		broadcast.setAction("startRecording");
		this.sendBroadcast(broadcast);

		this.finish();
	}


}