package com.sky.recordcalls;

import java.io.File;
import java.io.IOException;

import com.sky.recordcalls.util.Formatter;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
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
		broadcast.setAction("startRecording");
		this.sendBroadcast(broadcast);
//		Intent intent = new Intent(this, NotificationReceiverStopActivity.class);
//		PendingIntent pIntentStop = PendingIntent.getActivity(this, 1, intent, 0);
//
//		Log.d(TAG, "After pending intent");
//		// Build notification
//		// Actions are just fake
//		Notification noti = new Notification.Builder(this).setContentTitle("Record Calls").setContentText("Subject").setContentIntent(pIntentStop).setSmallIcon(R.drawable.ic_launcher).addAction(R.drawable.ic_launcher, "Stop", pIntentStop).build();
//
//		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//		// Hide the notification after its selected
//		noti.flags |= Notification.FLAG_AUTO_CANCEL;
//		Log.d(TAG, "After notificationManager");
//
//		notificationManager.notify(NOTIFICATION_ID_RECORDING, noti);
//		BroadcastReceiver broadcastReceiver = new BroadcastReceiver()
//		{
//			@Override
//			public void onReceive(Context context, Intent intent)
//			{
//				String action_name = intent.getAction();
//				if (action_name.equals("startRecording"))
//				{
//					startRecording();
//				}
//				else if (action_name.equals("stopRecording"))
//				{
//					stopRecording();
//				}
//			};
//		};
//		registerReceiver(broadcastReceiver, new IntentFilter("startRecording"));
//		registerReceiver(broadcastReceiver, new IntentFilter("stopRecording"));
		this.finish();
	}

//	private void initialise()
//	{
//
//		startRecBtn = (Button) findViewById(R.id.startRecBtn);
//		stopRecBtn = (Button) findViewById(R.id.stopRecBtn);
//
//		startRecBtn.setOnClickListener(new View.OnClickListener()
//		{
//
//			@Override
//			public void onClick(View v)
//			{
//				startRecording();
//			}
//
//		});
//		stopRecBtn.setOnClickListener(new View.OnClickListener()
//		{
//
//			@Override
//			public void onClick(View v)
//			{
//				stopRecording();
//			}
//
//		});
//	}
//
//	protected void stopRecording()
//	{
//		Callrecorder.stop();
//		Callrecorder.reset();
//		Callrecorder.release();
//		Callrecorder = null;
//
//	}
//
//	protected void startRecording()
//	{
//		String state = android.os.Environment.getExternalStorageState();
//		if (!state.equals(android.os.Environment.MEDIA_MOUNTED))
//		{
//			try
//			{
//				throw new IOException("SD Card is not mounted.  It is " + state + ".");
//			}
//			catch (IOException e)
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		if (Callrecorder != null)
//		{
//			Callrecorder.release();
//		}
//
//		Callrecorder = new MediaRecorder();
//		Callrecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
//		// Callrecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
//		Callrecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
//		Callrecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
//		fileName = Formatter.datetime(Long.valueOf(System.currentTimeMillis()).longValue(), "_");
//
//		Log.d(TAG, "pathString - " + pathString);
//		boolean exists = (new File(pathString + "/RecordCalls/")).exists();
//		if (!exists)
//		{
//			Log.d(TAG, "RecordCalls folder does not exist.");
//			new File(pathString + "/RecordCalls/").mkdirs();
//		}
//		File localFile = new File(pathString, "/RecordCalls/" + fileName + "." + fileExt);
//		String recordPath = localFile.getAbsolutePath();
//		Callrecorder.setOutputFile(recordPath);
//		Callrecorder.setAudioSamplingRate(samplingRate);
//		try
//		{
//			Callrecorder.prepare();
//		}
//		catch (IllegalStateException e)
//		{
//			e.printStackTrace();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
//		Callrecorder.start();
//
//	}
}