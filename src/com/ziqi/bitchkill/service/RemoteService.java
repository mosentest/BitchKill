package com.ziqi.bitchkill.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RemoteService extends Service {

	private static final int foregroundPushId = 0;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	public static class InnerService extends Service {

		@Override
		public IBinder onBind(Intent intent) {
			return null;
		}

		@Override
		public int onStartCommand(Intent intent, int flags, int startId) {
			Notification notification = new Notification();
			notification.flags |= Notification.FLAG_NO_CLEAR;
			notification.flags |= Notification.FLAG_ONGOING_EVENT;
			startForeground(foregroundPushId, notification);
			stopForeground(true);
			stopSelf();
			return super.onStartCommand(intent, Service.START_STICKY, startId);
		}
	}

}
