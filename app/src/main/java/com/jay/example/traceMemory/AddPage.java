package com.jay.example.traceMemory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class AddPage extends Fragment {

	private ImageButton addPhoto;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.addpage, container,false);
		addPhoto=(ImageButton)view.findViewById(R.id.addPhoto);
		return view;
	}

}
