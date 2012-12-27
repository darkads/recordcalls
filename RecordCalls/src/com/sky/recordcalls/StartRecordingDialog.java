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
	private final int DIALOG_REC = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		showDialog(DIALOG_REC);
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
	protected Dialog onCreateDialog(int id)
	{
		switch (id)
		{
			case DIALOG_REC:
				LayoutInflater factory = LayoutInflater.from(this);
				final View recordView = factory.inflate(R.layout.record_dialog, null);
				Dialog dialog = new AlertDialog.Builder(this).setView(recordView).setOnCancelListener(new OnCancelListener()
				{
					public void onCancel(DialogInterface dialog)
					{
						StartRecordingDialog.this.finish();
					}
				}).create();

				Button startRec = (Button) recordView.findViewById(R.id.startRecBtnDlg);
				startRec.setOnClickListener(new OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						sendBroadcast();
					}
				});
				Button cancelRec = (Button) recordView.findViewById(R.id.cancelRecBtnDlg);
				cancelRec.setOnClickListener(new OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						StartRecordingDialog.this.finish();
					}
				});
				dialog.show();
				
		}

		  return super.onCreateDialog(id);

	}
}
