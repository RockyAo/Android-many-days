package com.ao.rocky.firstandroid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ao.rocky.firstandroid.Common.AppManager;
import com.ao.rocky.firstandroid.Utils.UIUtils;
import com.ao.rocky.firstandroid.fragement.HomeFragment;
import com.ao.rocky.firstandroid.fragement.InvestFragment;
import com.ao.rocky.firstandroid.fragement.MeFragment;
import com.ao.rocky.firstandroid.fragement.MoreFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

	@BindView(R.id.content)
	FrameLayout content;
	@BindView(R.id.iv_home)
	ImageView ivHome;
	@BindView(R.id.tv_home)
	TextView tvHome;
	@BindView(R.id.ll_home)
	LinearLayout llHome;
	@BindView(R.id.iv_invest)
	ImageView ivInvest;
	@BindView(R.id.tv_invest)
	TextView tvInvest;
	@BindView(R.id.ll_invest)
	LinearLayout llInvest;
	@BindView(R.id.iv_me)
	ImageView ivMe;
	@BindView(R.id.tv_me)
	TextView tvMe;
	@BindView(R.id.ll_me)
	LinearLayout llMe;
	@BindView(R.id.iv_more)
	ImageView ivMore;
	@BindView(R.id.tv_more)
	TextView tvMore;
	@BindView(R.id.ll_more)
	LinearLayout llMore;
	@BindView(R.id.activity_main)
	LinearLayout activityMain;


	private HomeFragment homeFragment;
	private InvestFragment investFragment;
	private MeFragment meFragment;
	private MoreFragment moreFragment;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		AppManager.manager().addActivity(this);
		setSelect(0);
	}

	@OnClick({R.id.ll_home,R.id.ll_me,R.id.ll_invest,R.id.ll_more})
	public void tabClick(View view){
		switch (view.getId()){

			case R.id.ll_home:

				setSelect(0);
				break;
			case R.id.ll_invest:
				setSelect(1);
				break;
			case R.id.ll_me:
				setSelect(2);
				break;
			case R.id.ll_more:
				setSelect(3);
				break;

		}
	}

	//设置对应fragment
	private void setSelect(int i){

		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		hideFragment(ft);
		resetTabbar();
		switch (i){

			case 0:
				//首页

				if (homeFragment == null){
					homeFragment = new HomeFragment();
					ft.add(R.id.content,homeFragment);
				}
				ft.show(homeFragment);
				setTabBarSelected(ivHome,tvHome,R.drawable.bid01,"首页");
				break;
			case 1:
				//投资
				if (investFragment == null){
					investFragment = new InvestFragment();
					ft.add(R.id.content,investFragment);
				}
				ft.show(investFragment);
				setTabBarSelected(ivInvest,tvInvest,R.drawable.bid03,"我要投资");
				break;
			case 2:
				//我的
				if (meFragment == null){
					meFragment = new MeFragment();
					ft.add(R.id.content,meFragment);
				}
				ft.show(meFragment);
				setTabBarSelected(ivMe,tvMe,R.drawable.bid05,"我的资产");
				break;
			case 3:
				//更多
				if (moreFragment == null){
					moreFragment = new MoreFragment();
					ft.add(R.id.content,moreFragment);
				}
				ft.show(moreFragment);
				setTabBarSelected(ivMore,tvMore,R.drawable.bid07,"更多");
				break;
		}

		ft.commit();
	}

	private void setTabBarSelected(ImageView view, TextView textView,int image,String title) {

		view.setImageResource(image);
		textView.setTextColor(UIUtils.getColorById(R.color.home_back_selected));

	}

	private void resetTabbar() {

		ivHome.setImageResource(R.drawable.bid02);
		ivInvest.setImageResource(R.drawable.bid04);
		ivMe.setImageResource(R.drawable.bid06);
		ivMore.setImageResource(R.drawable.bid08);

		tvHome.setTextColor(UIUtils.getColorById(R.color.home_back_unselected));
		tvInvest.setTextColor(UIUtils.getColorById(R.color.home_back_unselected));
		tvMe.setTextColor(UIUtils.getColorById(R.color.home_back_unselected));
		tvMore.setTextColor(UIUtils.getColorById(R.color.home_back_unselected));
	}

	private void hideFragment(FragmentTransaction ft) {

		if (homeFragment != null){

			ft.hide(homeFragment);
		}

		if (investFragment != null){
			ft.hide(investFragment);
		}

		if (meFragment != null){

			ft.hide(meFragment);
		}

		if (moreFragment != null){

			ft.hide(moreFragment);
		}
	}


}
