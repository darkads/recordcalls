package com.sky.recordcalls;

import java.io.File;
import java.io.IOException;

import com.sky.recordcalls.util.Formatter;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Toast;

public class NotificationHelper
{

	protected String TAG = "NotificationHelper";
	private Notification.Builder notificationBuilder;
	private Notification notification;
	private NotificationManager notificationManager;
	private PendingIntent pendingIntent;
	private CharSequence ContentTitle;
	private PhoneStateListener listener;
	private TelephonyManager telephoneM;
	private int ID;
	private Context context;
	private Boolean recording = false, idle;
	private long startTime;
	RemoteViews contentView;

	final int NOTIFICATION_ID_NOT_RECORDING = 0;
	final int NOTIFICATION_ID_RECORDING = 1;

	File pathString = Environment.getExternalStorageDirectory();
	String fileName = "", fileExt = "mp4";
	private MediaRecorder Callrecorder;
	int samplingRate = 44100;
	BroadcastReceiver stopRecording, startRecording;

	public NotificationHelper(Context context, int id)
	{

		this.ID = id;
		this.context = context;
		this.idle = false;
	}

	public void createNotification()
	{
		// Prepare intent which is triggered if the notification is selected
		Intent intent = new Intent(context, NotificationReceiverStartActivity.class);
		pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
		// PendingIntent pIntentStop = PendingIntent.getActivity(this, 1, intent, 0);

		Log.d(TAG, "After pending intent");
		// Build notification actions are just fake
		contentView = new RemoteViews(context.getPackageName(), R.layout.notification_layout);
		setListeners(contentView);
		// notification.contentView = contentView;
		contentView.setViewVisibility(R.id.textViewSmallNoti, View.INVISIBLE);
		contentView.setViewVisibility(R.id.progressBar1, View.INVISIBLE);
		contentView.setTextViewText(R.id.textViewBigNoti, "Start Recording?");
		// Notification.Builder notificationBuilder = new Notification.Builder(context);
		notificationBuilder = new Notification.Builder(context);
		notificationBuilder.setContent(contentView);
		notificationBuilder.setContentTitle("Record Calls");
		notificationBuilder.setContentText("Subject");
		notificationBuilder.setContentIntent(pendingIntent);
		notificationBuilder.setSmallIcon(R.drawable.ic_launcher);
		// notificationBuilder.addAction(R.drawable.ic_launcher, "Record", pendingIntent);
		notification = notificationBuilder.build();

		// .setContentText("Subject")

		// .addAction(R.drawable.icon, "Record", pIntent)
		// .addAction(R.drawable.icon, "More", pIntent)

		notificationManager = ((NotificationManager) context.getSystemService(Service.NOTIFICATION_SERVICE));
		// Hide the notification after its selected
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		Log.d(TAG, "After notificationManager");

		notificationManager.notify(NOTIFICATION_ID_NOT_RECORDING, notification);

		startRecording = new BroadcastReceiver()
		{
			@Override
			public void onReceive(Context context, Intent intent)
			{
				String action_name = intent.getAction();
				if (action_name.equals("startRecording"))
				{
					Log.d(TAG, "startrecording...");
					startRecording();
					context.unregisterReceiver(startRecording);
					startRecording = null;
				}
				// else if (action_name.equals("stopRecording"))
				// {
				// stopRecording();
				// context.unregisterReceiver(stopRecording);
				// }
			};
		};
		context.registerReceiver(startRecording, new IntentFilter("startRecording"));
		// registerReceiver(broadcastReceiver, new IntentFilter("stopRecording"));

		stopRecording = new BroadcastReceiver()
		{
			@Override
			public void onReceive(Context context, Intent intent)
			{
				String action_name = intent.getAction();
				if (action_name.equals("stopRecording"))
				{
					Log.d(TAG, "stoprecording...");
					stopRecording();
					context.unregisterReceiver(stopRecording);
					stopRecording = null;
				}
			};
		};
		context.registerReceiver(stopRecording, new IntentFilter("stopRecording"));

//		 listener = new PhoneStateListener()
//		 {
//		 public void onCallStateChanged(int state, String incomingnumber)
//		 {
//		 // String stateS = "N/A";
//		 switch (state)
//		 {
//		 case TelephonyManager.CALL_STATE_IDLE:
//		 stopSelf();
//		 break;
//		 case TelephonyManager.CALL_STATE_RINGING:
//		
//		 break;
//		 case TelephonyManager.CALL_STATE_OFFHOOK:
//		
//		 break;
//		 }
//		
//		 }
//		 };
//		
//		 telephoneM = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//		 telephoneM.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
	}
	
	public void createDialog()
	{
//		Log.d(TAG,"In create dialog");
//		Intent intent = new Intent(context, StartRecordingDialog.class);
//		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		context.startActivity(intent);	
	}

	private void setListeners(RemoteViews contentView)
	{
		Intent startRec = new Intent(context, NotificationReceiverStartActivity.class);
		// startRec.putExtra("AN_ACTION", "do");// if necessary

		PendingIntent pStartRec = PendingIntent.getActivity(context, 0, startRec, 0);

		// R.id.radio is a button from the layout which is created at step 2 view.setOnClickPendingIntent(R.id.radio, pRadio);
		contentView.setOnClickPendingIntent(R.id.startRecBtnNoti, pStartRec);

		// Follows exactly my code!

		Intent stopRec = new Intent(context, NotificationReceiverStopActivity.class);

		// stopRec.putExtra("DO", "volume");

		// HERE is the whole trick. Look at pVolume. I used 1 instead of 0.

		PendingIntent pStopRec = PendingIntent.getActivity(context, 1, stopRec, 0);

		contentView.setOnClickPendingIntent(R.id.stopRecBtnNoti, pStopRec);

	}

	protected void stopRecording()
	{
		recording = false;
		Callrecorder.stop();
		Callrecorder.reset();
		Callrecorder.release();
		Callrecorder = null;

	}

	protected void startRecording()
	{
		Log.d(TAG, "in startrecording()");
		recording = true;
		startTime = SystemClock.elapsedRealtime();
		String state = android.os.Environment.getExternalStorageState();
		if (!state.equals(android.os.Environment.MEDIA_MOUNTED))
		{
			try
			{
				throw new IOException("SD Card is not mounted.  It is " + state + ".");
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (Callrecorder != null)
		{
			Callrecorder.release();
		}

		Log.d(TAG, "in startrecording() - before creating new callrecorder");
		Callrecorder = new MediaRecorder();
		Callrecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
		// Callrecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		Callrecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
		Callrecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
		fileName = Formatter.datetime(Long.valueOf(System.currentTimeMillis()).longValue(), "_");

		Log.d(TAG, "pathString - " + pathString);
		boolean exists = (new File(pathString + "/RecordCalls/")).exists();
		if (!exists)
		{
			Log.d(TAG, "RecordCalls folder does not exist.");
			new File(pathString + "/RecordCalls/").mkdirs();
		}
		File localFile = new File(pathString, "/RecordCalls/" + fileName + "." + fileExt);
		String recordPath = localFile.getAbsolutePath();
		Callrecorder.setOutputFile(recordPath);
		Callrecorder.setAudioSamplingRate(samplingRate);
		try
		{
			Callrecorder.prepare();
		}
		catch (IllegalStateException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		Callrecorder.start();

	}

	// We call this function within the onProgressUpdate() of our running Async Task. Essentially we pass to it the percentage complete of our long running operation and then notify our Notification.

	public void progressUpdate(String recordingTime)
	{

		// RemoteViews contentView = new RemoteViews(context.getPackageName(), R.layout.notification_layout);
		// setListeners(contentView);
		if (recording)
		{
			contentView.setViewVisibility(R.id.textViewSmallNoti, View.VISIBLE);
			contentView.setViewVisibility(R.id.progressBar1, View.VISIBLE);
			contentView.setTextViewText(R.id.textViewBigNoti, "Recording...");
			contentView.setTextViewText(R.id.textViewSmallNoti, recordingTime);
			String contentText = "Now Recording: " + recordingTime;
			notificationBuilder.setContent(contentView);
			notificationBuilder.setContentTitle("Record Calls");
			notificationBuilder.setContentText(contentText);
			notificationBuilder.setContentIntent(pendingIntent);
			notificationBuilder.setSmallIcon(R.drawable.ic_launcher);
			notification = notificationBuilder.build();
			notificationManager.notify(NOTIFICATION_ID_NOT_RECORDING, notification);
		}
		else
		{
			contentView.setViewVisibility(R.id.textViewSmallNoti, View.INVISIBLE);
			contentView.setViewVisibility(R.id.progressBar1, View.INVISIBLE);
			contentView.setTextViewText(R.id.textViewBigNoti, "Start Recording?");
			String contentText = "Now Recording: " + recordingTime;
			notificationBuilder.setContent(contentView);
			notificationBuilder.setContentTitle("Record Calls");
			notificationBuilder.setContentText(contentText);
			notificationBuilder.setContentIntent(pendingIntent);
			notificationBuilder.setSmallIcon(R.drawable.ic_launcher);
			notification = notificationBuilder.build();
			notificationManager.notify(NOTIFICATION_ID_NOT_RECORDING, notification);
		}

	}

	// We call this function from the onPostExecute() of our Async Task to tell the user and the notification manager that our long running process is compelted

	public void completed()
	{

		// Lets display a toast so the user knows the long running process has finished
		Toast.makeText(context, "Long running process COMPLETE!", Toast.LENGTH_LONG).show();
		// notificationManager.cancel(NOTIFICATION_ID_NOT_RECORDING);

	}

	public NotificationManager getNotificationManager()
	{
		return notificationManager;
	}

	public void setNotificationManager(NotificationManager notificationManager)
	{
		this.notificationManager = notificationManager;
	}

	public MediaRecorder getCallrecorder()
	{
		return Callrecorder;
	}

	public void setCallrecorder(MediaRecorder callrecorder)
	{
		Callrecorder = callrecorder;
	}

	public Boolean getRecording()
	{
		return recording;
	}

	public void setRecording(Boolean recording)
	{
		this.recording = recording;
	}

	public Notification getNotification()
	{
		return notification;
	}

	public void setNotification(Notification notification)
	{
		this.notification = notification;
	}

	public PendingIntent getPendingIntent()
	{
		return pendingIntent;
	}

	public void setPendingIntent(PendingIntent pendingIntent)
	{
		this.pendingIntent = pendingIntent;
	}

	public Boolean getIdle()
	{
		return idle;
	}

	public void setIdle(Boolean idle)
	{
		this.idle = idle;
	}

	public long getStartTime()
	{
		return startTime;
	}

	public void setStartTime(long startTime)
	{
		this.startTime = startTime;
	}

	
}
