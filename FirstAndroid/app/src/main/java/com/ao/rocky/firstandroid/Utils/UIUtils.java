package com.ao.rocky.firstandroid.Utils;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import com.ao.rocky.firstandroid.Common.MyApplication;

/**
 * Created by Administrator on 2016/10/25 0025.
 */

public class UIUtils {

	/**
	 * 通过id获取颜色
	 * @param colorId
	 * @return 颜色
	 */
	public static int getColorById(int colorId){

		return getContext().getResources().getColor(colorId);
	}

	public static View getXMLViewById(int layoutID){

		return View.inflate(getContext(),layoutID,null);
	}

	public static String[] getStringFromArrayPosition(int position){

		return getContext().getResources().getStringArray(position);
	}

	/**
	 * dp 转px
	 * @param dp
	 * @return
	 */
	public static int dpToPx(int dp){

		final float density = getContext().getResources().getDisplayMetrics().density;

		return (int)(density*dp+0.5);
	}

	/**
	 * px 转 dp
	 * @param px
	 * @return
	 */
	public static int pxToDp(int px){

		final float density = getContext().getResources().getDisplayMetrics().density;

		return (int)(px/density+0.5);
	}

	public static Context getContext(){

		return MyApplication.context;
	}

	public static Handler getHandler(){

		return MyApplication.handler;
	}
}
