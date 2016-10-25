package com.ao.rocky.firstandroid.Common;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by Administrator on 2016/10/25 0025.
 */

public class MyApplication extends Application {

	public static Context context = null;

	public static Handler handler = null;

	public static Thread mainThread = null;

	public static int mainThreadID = 0;



	@Override
	public void onCreate() {

		context = getApplicationContext();
		handler = new Handler();
		mainThread = Thread.currentThread();
		mainThreadID = android.os.Process.myTid();
	}

}

