package com.ziqi.bitchkill.receiver;

import com.ziqi.bitchkill.utils.KeepLiveManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class KeepLiveReceiver extends BroadcastReceiver {

	private final static String TAG = "KeepLiveReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		Log.e(TAG, "KeepLiveReceiver.action:" + action);
		if ("android.intent.action.USER_PRESENT".equals(action)) {
			// ACTION_SCREEN_OFF
			KeepLiveManager.getIntance().startKeepLiveActivity(context);
		} else if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
			KeepLiveManager.getIntance().startKeepLiveActivity(context);
		} else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
			KeepLiveManager.getIntance().startKeepLiveActivity(context);
		} else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
			KeepLiveManager.getIntance().startKeepLiveActivity(context);
		} else if ("android.net.wifi.STATE_CHANGE".equals(action)) {
			KeepLiveManager.getIntance().startKeepLiveActivity(context);
		} else if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
			KeepLiveManager.getIntance().startKeepLiveActivity(context);
		} else if ("android.intent.action.ANY_DATA_STATE".equals(action)) {
			KeepLiveManager.getIntance().startKeepLiveActivity(context);
		} else if ("android.intent.action.TIME_SET".equals(action)) {
			KeepLiveManager.getIntance().startKeepLiveActivity(context);
		} else if ("android.intent.action.DATE_CHANGED".equals(action)) {
			KeepLiveManager.getIntance().startKeepLiveActivity(context);
		}
	}

}
