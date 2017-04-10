package com.ziqi.bitchkill.service;

import com.ziqi.bitchkill.service.RemoteServiceAidl.Stub;
import com.ziqi.bitchkill.utils.WakeLockUtils;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;

public class KeepLiveService extends Service {

	private static final int foregroundPushId = 0;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		WakeLockUtils.acquireWakeLock(this);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		bindService(new Intent(this, RemoteService.class), connection, Context.BIND_ABOVE_CLIENT);
		keepAlive(getApplicationContext(), this);
		return Service.START_NOT_STICKY;
	}

	@Override
	public void onDestroy() {
		WakeLockUtils.releaseWakeLock();
		Intent localService = new Intent(this, RemoteService.class);
		startService(localService);
		// super.onDestroy();
	}

	@Override
	public void onLowMemory() {
		Intent localService = new Intent(this, RemoteService.class);
		startService(localService);
	}

	static class RemoteBilder extends Stub {

		private KeepLiveService mService;

		public RemoteBilder(KeepLiveService mService) {
			super();
			this.mService = mService;
		}

		@Override
		public void doSomething() throws RemoteException {
			Intent localService = new Intent(mService, RemoteService.class);
			mService.startService(localService);
			mService.bindService(new Intent(mService, RemoteService.class), mService.connection, Context.BIND_ABOVE_CLIENT);
		}
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

	public static void keepAlive(Context context, final Service keepLiveService) {
		try {
			Notification notification = new Notification();
			notification.flags |= Notification.FLAG_NO_CLEAR;
			notification.flags |= Notification.FLAG_ONGOING_EVENT;
			if (Build.VERSION.SDK_INT < 18) {
				// ，此方法能有效隐藏Notification上的图标
				keepLiveService.startForeground(foregroundPushId, notification);
			} else {
				keepLiveService.startForeground(foregroundPushId, notification);
				Intent innerIntent = new Intent(context, InnerService.class);
				context.startService(innerIntent);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
