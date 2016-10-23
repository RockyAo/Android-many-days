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

import com.ao.rocky.firstandroid.fragement.HomeFragment;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
	}



	@OnClick({R.id.ll_home,R.id.ll_me,R.id.ll_invest,R.id.ll_more})
	public void tabClick(View view){

		switch (view.getId()){

			case R.id.ll_home:
				setSelect(0);
				break;
			case R.id.ll_invest:
				break;
			case R.id.ll_me:
				break;
			case R.id.ll_more:
				break;

		}
	}

	//设置对应fragment
	private void setSelect(int i){

		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();

		switch (i){

			case 0:
				//首页
				if (homeFragment == null){
					homeFragment = new HomeFragment();
					ft.add(R.id.content,homeFragment);
				}
				ft.show(homeFragment);
				break;
			case 1:
				//投资
				break;
			case 2:
				//我的
				break;
			case 3:
				//更多
				break;
		}

		ft.commit();
	}
}
