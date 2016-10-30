package com.ao.rocky.firstandroid.UI;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2016/10/27 0027.
 */

public class SpringScrollView extends ScrollView {


	private View innerView;
	private float touchStartY;
	private Rect originalPosition = new Rect();
	private boolean animationFinish = true;

	public SpringScrollView(Context context) {
		super(context);
	}

	public SpringScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SpringScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onFinishInflate() {

		int childCount = getChildCount();

		if (childCount > 0){

			innerView = getChildAt(0);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {

		if (innerView == null){

			return super.onTouchEvent(ev);
		}

		commonTouchEvent(ev);
		return super.onTouchEvent(ev);
	}

	/**
	 * 自定义touch
	 * @param ev
	 */
	private void commonTouchEvent(MotionEvent ev) {

		if (animationFinish){

			int action = ev.getAction();

			switch (action){

				case MotionEvent.ACTION_DOWN:

					touchStartY = ev.getY();
					break;
				case MotionEvent.ACTION_MOVE:
					float y = touchStartY == 0 ? ev.getY() : touchStartY;
					float currentY = ev.getY();
					int distance = (int) (y - currentY);
					touchStartY = currentY;

					//拖动
					if (isNeedMove()){
						//存储原始位置
						if (originalPosition.isEmpty()){

							originalPosition.set(innerView.getLeft(),innerView.getTop(),innerView.getRight(),innerView.getBottom());
						}
						innerView.layout(innerView.getLeft(),innerView.getTop() - distance/2,innerView.getRight(),innerView.getBottom()-distance/2);
					}

					break;
				case MotionEvent.ACTION_UP:

					touchStartY = 0;

					//滚回原始位置
					if (isNeedAnimation()){

						animation();
					}

					break;
			}
		}

	}

	private void animation() {

		TranslateAnimation ta = new TranslateAnimation(0, 0, 0, originalPosition.top-innerView.getTop());

		ta.setDuration(250);
		ta.setAnimationListener(new Animation.AnimationListener(){

			@Override
			public void onAnimationStart(Animation animation) {

				innerView.clearAnimation();
				animationFinish = false;

			}

			@Override
			public void onAnimationEnd(Animation animation) {

				innerView.layout(originalPosition.left,originalPosition.top,originalPosition.right,originalPosition.bottom);
				originalPosition.setEmpty();
				animationFinish = true;
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});

		innerView.startAnimation(ta);
//		ta.startNow();
	}


	public boolean isNeedMove() {

		int offset = innerView.getMeasuredHeight() - getHeight();
		int scroolY = getScrollY();
		if (scroolY == 0 || scroolY == offset){

			return true;
		}
		return false;
	}

	public boolean isNeedAnimation() {

		if (!originalPosition.isEmpty()){

			return true;
		}
		return false;
	}
}
