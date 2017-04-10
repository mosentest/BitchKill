package com.ziqi.bitchkill.utils;

import com.ziqi.bitchkill.actvity.KeepLiveActivity;

import android.content.Context;

public class KeepLiveManager {
	private static KeepLiveManager instance = null;

	public KeepLiveManager() {
		super();
	}

	public static KeepLiveManager getIntance() {
		if (instance == null) {
			synchronized (KeepLiveManager.class) {
				if (instance == null) {
					instance = new KeepLiveManager();
				}
			}
		}
		return instance;
	}

	public void startKeepLiveActivity(Context context) {
		StartActivtiyUtils.startActvityNoAnim(context, KeepLiveActivity.class);
	}

	public void stopKeepLiveActivity(Context context) {
		ActivitysManager.finishActivity(KeepLiveActivity.class);
	}
}