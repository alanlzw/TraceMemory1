package com.jay.example.traceMemory;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPageAadpter extends FragmentPagerAdapter {
		
	private ArrayList<Fragment> fragmentsList;

	public MyFragmentPageAadpter(FragmentManager manager)
	{
		super(manager);
	}
	public MyFragmentPageAadpter(FragmentManager manager, ArrayList<Fragment> fragments) {
        super(manager);
        this.fragmentsList = fragments;
    }
	
	
	@Override
	public Fragment getItem(int index)
	{

		return fragmentsList.get(index);

	}

	@Override
	public int getCount()
	{
		return fragmentsList.size();
	}

}
