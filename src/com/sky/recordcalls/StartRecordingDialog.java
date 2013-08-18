package com.sky.recordcalls;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class StartRecordingDialog extends Activity
{

	private String TAG = "StartRecordingDialog";
	private BroadcastReceiver removeDialog;
	private Dialog adialog;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		removeDialog = new BroadcastReceiver()
		{
			@Override
			public void onReceive(Context context, Intent intent)
			{
				String action_name = intent.getAction();
				if (action_name.equals("removeDialog"))
				{
					Log.d(TAG, "Removing Dialog...");
					if (adialog != null)
					{
						adialog.cancel();
					}
				}
			};
		};
		this.registerReceiver(removeDialog, new IntentFilter("removeDialog"));
		

		
	}
	
	@Override
	public void onPostCreate(Bundle savedInstanceState)
	{
		super.onPostCreate(savedInstanceState);
		showDialog();
	}
	
	public void showDialog()
	{
		Window window = this.getWindow();
		window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
		window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
		window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		final AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("RecordCalls");
		alert.setMessage("Start Recording?");
		alert.setPositiveButton("Start", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int whichButton)
			{
				sendBroadcast();
				dialog.dismiss();
				//return back to dialer activity
				Intent intent = new Intent(Intent.ACTION_CALL_BUTTON);
				startActivity(intent);
			}
		});
		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int whichButton)
			{
				dialog.cancel();
				Intent intent = new Intent(Intent.ACTION_CALL_BUTTON);
				startActivity(intent);
			}
		});
		alert.setOnCancelListener(new OnCancelListener()
		{
			public void onCancel(DialogInterface dialog)
			{
				StartRecordingDialog.this.finish();
			}
		});
		adialog = alert.create();
//		alert.show();
		adialog.show();
	}

	public void sendBroadcast()
	{

		Intent broadcast = new Intent("com.sky.recordcalls.StartRecordingDialog");
		broadcast.setAction("startRecording");
		this.sendBroadcast(broadcast);

		Log.d(TAG, "After sending broadcast");

		this.finish();
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		if (removeDialog != null)
		{
			this.unregisterReceiver(removeDialog);
		}
	}
}
