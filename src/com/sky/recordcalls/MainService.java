package com.sky.recordcalls;

import java.util.Locale;

import android.os.AsyncTask;
import android.os.IBinder;
import android.os.SystemClock;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MainService extends Service
{

	protected String TAG = "MainService";
	final int ID = 0;
	NotificationHelper notificationHelper;
	private PhoneStateListener listener;
	private TelephonyManager telephoneM;

	@Override
	// protected void onCreate(Bundle savedInstanceState)
	public void onCreate()
	{
		// super.onCreate(savedInstanceState);
		super.onCreate();
		// setContentView(R.layout.activity_main);

//		if (isMyServiceRunning())
//		{
//			Context context = getApplicationContext();
//			Toast.makeText(context, "Service is already running! Stopping it first...", Toast.LENGTH_SHORT).show();
//			Intent i = new Intent(context, MainService.class);
//			context.stopService(i);
//		}
		notificationHelper = new NotificationHelper(this, ID);
		Log.i(TAG, "Service created...");
		// this.finish();

	}
	
	private boolean isMyServiceRunning() {
	    ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
	    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
	        if ("com.sky.recordcalls.MainService".equals(service.service.getClassName())) {
	            return true;
	        }
	    }
	    return false;
	}

	// @Override
	// protected void onPause()
	// {
	// super.onPause();
	// if (startRecording != null)
	// {
	// this.unregisterReceiver(startRecording);
	// }
	// if (stopRecording != null)
	// {
	// this.unregisterReceiver(stopRecording);
	// }
	// }

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu)
	// {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.activity_main, menu);
	// return true;
	// }

	@Override
	public IBinder onBind(Intent intent)
	{
		return null;
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		if (notificationHelper.getNotificationManager() != null)
		{
			Log.d(TAG, "NotificationManager is not null!");
			// Check if the service was already recording. If not, stop service. If yes, stop this recording first before stopping service
			if (notificationHelper.getCallrecorder() != null)
			{
				notificationHelper.stopRecording();
			}
			notificationHelper.getNotificationManager().cancelAll();
		}
		if (notificationHelper.stopRecording != null)
		{
			Log.d(TAG, "Notification Helper stopRecording is not null!");
			this.unregisterReceiver(notificationHelper.stopRecording);
		}
		if (notificationHelper.startRecording != null)
		{
			Log.d(TAG, "Notification Helper startRecording is not null!");
			this.unregisterReceiver(notificationHelper.startRecording);
		}
		if (notificationHelper.getIdle() != null)
		{
			Log.d(TAG, "Notification Helper IDLE is not null!");
			notificationHelper.setIdle(true);
		}
		notificationHelper.sendDialogBroadcast();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int StartId)
	{
		super.onStartCommand(intent, flags, StartId);

		Log.d(TAG, "Service started...");
		listener = new PhoneStateListener()
		{
			public void onCallStateChanged(int state, String incomingnumber)
			{
				// String stateS = "N/A";
				switch (state)
				{
					case TelephonyManager.CALL_STATE_IDLE:
						stopSelf();
						break;
					case TelephonyManager.CALL_STATE_RINGING:

						break;
					case TelephonyManager.CALL_STATE_OFFHOOK:

						break;
				}

			}
		};

		telephoneM = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		telephoneM.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
		
		new RecordingTask().execute();
		// notificationHelper.createNotification();

		return START_REDELIVER_INTENT;
	}

	public NotificationHelper getNotificationHelper()
	{
		return notificationHelper;
	}

	public void setNotificationHelper(NotificationHelper notificationHelper)
	{
		this.notificationHelper = notificationHelper;
	}

	public class RecordingTask extends AsyncTask<String, Void, Void>
	{

		protected void onPreExecute()
		{

			// Since this is the UI thread we can disable our button so that it is not pressed again!
			// startBtn.setEnabled(false);
			// completed = 0;
			// Create our notification via the helper class
			notificationHelper.createNotification();
			notificationHelper.createDialog();
			notificationHelper.setIdle(false);

		}

		@Override
		protected Void doInBackground(final String... args)
		{

			// In real life we would be doing something a bit more interesting here but this should suffice
			// for (int x = 0; x < 10; x++)
			while (!notificationHelper.getIdle())
			{
				while (notificationHelper.getRecording())
				{

					try
					{
						Thread.sleep(1000);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					// completed += 10;

					// lets call our onProgressUpdate() method which runs on the UI thread
					Log.d(TAG, "in doInBackground");
					publishProgress();
				}
			}

			Log.d(TAG, "in doInBackground: notification helper is idle");
			return null;
		}

		protected void onProgressUpdate(Void... v)
		{

			// lets format a string from the the 'completed' variable
			// long startTime;
			long countUp;

			// double dProgress = (double) completed;
			// DecimalFormat minutes = new DecimalFormat("00");
			// DecimalFormat seconds = new DecimalFormat("00");
			countUp = (SystemClock.elapsedRealtime() - notificationHelper.getStartTime()) / 1000;
			String minutes = String.format(Locale.US, "%02d", countUp / 60);
			String seconds = String.format(Locale.US, "%02d", countUp % 60);
			// int mins = Integer.valueOf(minutes.format(countUp / 60));
			// int sec = Integer.valueOf(seconds.format(countUp % 60));
			String asText = minutes + ":" + seconds;
			Log.d(TAG, "Progress update: " + asText);

			// update notification via the helper on the UI thread
			notificationHelper.progressUpdate(asText);

		}

		protected void onPostExecute(final Void result)
		{

			// this should be self explanatory
			notificationHelper.completed();
			// startBtn.setEnabled(true);

		}
	}

}
