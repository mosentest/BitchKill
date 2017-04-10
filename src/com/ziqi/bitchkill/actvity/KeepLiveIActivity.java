package com.ziqi.bitchkill.actvity;

import com.ziqi.bitchkill.service.KeepLiveService;
import com.ziqi.bitchkill.utils.StartActivtiyUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

public class KeepLiveIActivity {

	private Activity mActivity;

	public KeepLiveIActivity(Activity mActivity) {
		super();
		this.mActivity = mActivity;
	}

	protected void onCreate(Bundle savedInstanceState) {
		Window window = mActivity.getWindow();
		window.setGravity(Gravity.LEFT | Gravity.TOP);
		LayoutParams params = window.getAttributes();
		params.x = 0;
		params.y = 0;
		params.width = 1;
		params.height = 1;
		window.setAttributes(params);
		startKeepLiveService();
	}

	protected void startKeepLiveService() {
		StartActivtiyUtils.startService(mActivity, KeepLiveService.class);
	}

}
