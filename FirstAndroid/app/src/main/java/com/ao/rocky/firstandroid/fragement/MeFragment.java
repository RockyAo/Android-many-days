package com.ao.rocky.firstandroid.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ao.rocky.firstandroid.R;

/**
 * Created by Administrator on 2016/10/23 0023.
 */

public class MeFragment extends Fragment{
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = View.inflate(container.getContext(), R.layout.fragment_me,null);

		return view;
	}
}
