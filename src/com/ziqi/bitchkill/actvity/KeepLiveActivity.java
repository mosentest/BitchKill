package com.ziqi.bitchkill.actvity;

import com.ziqi.bitchkill.utils.ActivitysManager;

import android.app.Activity;
import android.os.Bundle;

public class KeepLiveActivity extends Activity {

	private KeepLiveIActivity mKeepLiveIActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (mKeepLiveIActivity == null) {
			mKeepLiveIActivity = new KeepLiveIActivity(this);
		}
		mKeepLiveIActivity.onCreate(savedInstanceState);
		ActivitysManager.pull(this);
	}

	@Override
	protected void onDestroy() {
		ActivitysManager.finishActivity(this);
		super.onDestroy();
	}
}
