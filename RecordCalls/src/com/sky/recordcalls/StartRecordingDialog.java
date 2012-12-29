package com.sky.recordcalls;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartRecordingDialog extends Activity
{

	private String TAG = "StartRecordingDialog";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		final AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("RecordCalls");
		alert.setMessage("Start Recording?");
		alert.setPositiveButton("Start", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int whichButton)
			{
				sendBroadcast();
				dialog.dismiss();
			}
		});
		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int whichButton)
			{
				dialog.cancel();
			}
		});
		alert.setOnCancelListener(new OnCancelListener()
		{
			public void onCancel(DialogInterface dialog)
			{
				StartRecordingDialog.this.finish();
			}
		});
		alert.create();
		alert.show();

	}

	public void sendBroadcast()
	{

		Intent broadcast = new Intent("com.sky.recordcalls.StartRecordingDialog");
		broadcast.setAction("startRecording");
		this.sendBroadcast(broadcast);

		Log.d(TAG, "After sending broadcast");

		this.finish();
	}
}
