package com.ao.rocky.firstandroid.Common;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/10/26 0026.
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler{

	private static CrashHandler crashHandler = null;

	private CrashHandler(){

	}

	public static CrashHandler handler(){

		if (crashHandler == null){

			crashHandler = new CrashHandler();
		}

		return crashHandler;
	}


	private Context mContext;
	private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;

	public void init(Context context){

		this.mContext = context;
		defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {

		new Thread(){

			@Override
			public void run() {
				Looper.prepare();
				Toast.makeText(mContext,"系统出现未知异常,2秒后退出",Toast.LENGTH_SHORT).show();
				Looper.loop();
			}
		}.start();


		collectionException(throwable);

		try {
			Thread.sleep(2000);
			AppManager.manager().removeAllActivity();
			android.os.Process.killProcess(android.os.Process.myPid());
			System.exit(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void collectionException(Throwable throwable) {

		String deviceInfo = Build.DEVICE+Build.VERSION.SDK_INT+Build.MODEL+Build.PRODUCT;

		String errorInfo = throwable.getMessage();

		
	}
}
