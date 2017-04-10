package com.ziqi.bitchkill.utils;

import java.util.concurrent.LinkedBlockingQueue;

import android.app.Activity;

public class ActivitysManager {

	private static LinkedBlockingQueue<Activity> queueActivity;

	static {
		queueActivity = new LinkedBlockingQueue<Activity>();
	}

	public static void pull(Activity activity) {
		if (queueActivity == null) {
			queueActivity = new LinkedBlockingQueue<Activity>();
		}
		queueActivity.add(activity);
	}

	public void push(Activity activity) {
		if (queueActivity == null || queueActivity.isEmpty()) {
			return;
		}
		queueActivity.remove(activity);
	}

	public static void finishAllActivity() {
		if (queueActivity == null || queueActivity.isEmpty()) {
			return;
		}
		for (Activity activity : queueActivity) {
			activity.finish();
		}
		queueActivity.clear();
	}

	public static void finishActivity(Activity activity) {
		if (queueActivity == null || queueActivity.isEmpty()) {
			return;
		}
		if (activity != null) {
			queueActivity.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	public static void finishActivity(Class<?> cls) {
		if (queueActivity == null || queueActivity.isEmpty()) {
			return;
		}
		for (Activity activity : queueActivity) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}
}
