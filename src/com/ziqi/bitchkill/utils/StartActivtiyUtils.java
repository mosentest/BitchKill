package com.ziqi.bitchkill.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class StartActivtiyUtils {

	public static void startActvityNoAnim(Context context, Class clazz) {
		Intent intent = new Intent(context, clazz);
		if (context instanceof Activity) {
		} else {
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		}
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		context.startActivity(intent);
	}

	public static void startService(Context context, Class clazz) {
		Intent intent = new Intent(context, clazz);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startService(intent);
	}
}
