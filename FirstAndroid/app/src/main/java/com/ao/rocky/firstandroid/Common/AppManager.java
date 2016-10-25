package com.ao.rocky.firstandroid.Common;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by Administrator on 2016/10/25 0025.
 */

public class AppManager {

	private Stack<Activity> activityStack = new Stack<>();

	public static AppManager appManager = null;

	private AppManager{


	}

	public static AppManager manager(){

		if (appManager == null){

			appManager = new AppManager();
		}

		return appManager;
	}

	/**
	 * 添加Activity
	 * @param activity
	 */
	public void addActivity(Activity activity){

		activityStack.add(activity);
	}

	/**
	 * 删除指定Activity
	 * @param activity
	 */
	public void removeActivity(Activity activity){


		for (Activity temp : activityStack) {

			if (temp.getClass().equals(activity.getClass())){

				temp.finish();
				activityStack.remove(temp);

				break;
			}
		}
	}

	/**
	 * 移除当前Activity
	 */
	public void removeCurrentActivity(){

		Activity lastElement = activityStack.lastElement();

		lastElement.finish();

		activityStack.remove(lastElement);
	}

	/**
	 * 移除所有的Activity
	 */
	public void removeAllActivity(){

		for (int i = activityStack.size() - 1; i >= 0; i--) {

			Activity activity = activityStack.get(i);
			activity.finish();
			activityStack.remove(activity);
		}
	}

	/**
	 * 获取当前栈大小
	 * @return size（int）
	 */
	public int getActivityStackSize(){

		return activityStack.size();
	}

}
