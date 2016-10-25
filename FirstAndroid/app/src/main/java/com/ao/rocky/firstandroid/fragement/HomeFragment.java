package com.ao.rocky.firstandroid.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ao.rocky.firstandroid.R;
import com.ao.rocky.firstandroid.Utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/23 0023.
 */

public class HomeFragment extends Fragment {

	@BindView(R.id.title_left)
	ImageView titleLeft;
	@BindView(R.id.top_title)
	TextView topTitle;
	@BindView(R.id.title_right)
	ImageView titleRight;
	@BindView(R.id.common_top)
	LinearLayout commonTop;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = UIUtils.getXMLViewById(R.layout.fragment_home);

		ButterKnife.bind(this, view);

		initTitle();
		return view;
	}

	private void initTitle() {

		titleLeft.setVisibility(View.INVISIBLE);
		titleRight.setVisibility(View.INVISIBLE);
		topTitle.setText("首页");
	}
}
