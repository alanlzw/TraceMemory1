package com.jay.example.traceMemory;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class MainActivity extends FragmentActivity {

	private HomePage homePage;
	private SeqrchPage searchPage;
	private AddPage addPage;
	private FollowPage followPage;
	private PersonPage personPage;

	private ViewPager mPager;
	private ArrayList<Fragment> fragmentsList;
	private MyFragmentPageAadpter mAdapter;

	private RelativeLayout homePage_layout;
	private RelativeLayout addPage_layout;
	private RelativeLayout followPage_layout;
	private RelativeLayout person_layout;
	private RelativeLayout search_layout;

	private ImageView homePage_image;
	private ImageView addPage_image;
	private ImageView followPage_image;
	private ImageView personPage_image;
	private ImageView search_image;

	private TextView homePage_text;
	private TextView addPage_text;
	private TextView followPage_text;
	private TextView personPage_text;
	private TextView searchPage_text;

	private int Gray = 0xFF999999;
	private int Green =0xFF45C01A;


	public FragmentManager fManager;


	public MyOnClick myclick;
	public MyPageChangeListener myPageChange;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().hide();
		fManager = getSupportFragmentManager();
		initViewPager();
		initViews();
		initState();
	}
	
	
	
	
	private void initViews() {
		myclick = new MyOnClick();
		myPageChange = new MyPageChangeListener();

		mPager = (ViewPager) findViewById(R.id.vPager);
		homePage_layout = (RelativeLayout) findViewById(R.id.homePage_layout);
		addPage_layout = (RelativeLayout) findViewById(R.id.add_layout);
		search_layout = (RelativeLayout) findViewById(R.id.search_layout);
		person_layout = (RelativeLayout) findViewById(R.id.me_layout);
		followPage_layout=(RelativeLayout)findViewById(R.id.follow_layout);

		homePage_image = (ImageView) findViewById(R.id.homePage_image);
		addPage_image = (ImageView) findViewById(R.id.add_image);
		search_image = (ImageView) findViewById(R.id.search_image);
		personPage_image = (ImageView) findViewById(R.id.me_image);
		followPage_image=(ImageView)findViewById(R.id.follow_image);

		homePage_text = (TextView) findViewById(R.id.homePage_text);
		addPage_text = (TextView) findViewById(R.id.add_text);
		searchPage_text = (TextView) findViewById(R.id.search_text);
		personPage_text = (TextView) findViewById(R.id.me_text);
		followPage_text=(TextView)findViewById(R.id.follow_text);

		mPager.setAdapter(mAdapter);
		mPager.setOnPageChangeListener(myPageChange);
		homePage_layout.setOnClickListener(myclick);
		addPage_layout.setOnClickListener(myclick);
		search_layout.setOnClickListener(myclick);
		person_layout.setOnClickListener(myclick);
		followPage_layout.setOnClickListener(myclick);
	}
	
	private void initViewPager()
	{
		fragmentsList = new ArrayList<Fragment>();    
        homePage = new HomePage();
        searchPage = new SeqrchPage();
        addPage = new AddPage();
        followPage = new FollowPage();
		personPage = new PersonPage();

        fragmentsList.add(homePage);
        fragmentsList.add(searchPage);
        fragmentsList.add(addPage);
        fragmentsList.add(followPage);
		fragmentsList.add(personPage);
        mAdapter = new MyFragmentPageAadpter(fManager,fragmentsList);
	}
	
	//设置初始状态
	private void initState()
	{
		homePage_image.setImageResource(R.drawable.homepage);
		homePage_text.setTextColor(Green);
		mPager.setCurrentItem(0);
	}
	
	
	
	
	public class MyOnClick implements OnClickListener
	{
		@Override
		public void onClick(View view) {
			clearChioce();
			iconChange(view.getId());
		}
	}
	
	public class MyPageChangeListener implements OnPageChangeListener
	{

		@Override
		public void onPageScrollStateChanged(int arg0)
		{
			if(arg0 == 2)
			{
				int i = mPager.getCurrentItem();
				clearChioce();
				iconChange(i);
			}
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {}

		@Override
		public void onPageSelected(int index){}
		
	}
	
	
	
	//清空选中状态
	public void clearChioce()
	{
		homePage_image.setImageResource(R.drawable.homepage);
		homePage_text.setTextColor(Gray);
		search_image.setImageResource(R.drawable.search);
		searchPage_text.setTextColor(Gray);
		addPage_image.setImageResource(R.drawable.add);
		addPage_text.setTextColor(Gray);
		personPage_image.setImageResource(R.drawable.people);
		personPage_text.setTextColor(Gray);
		followPage_image.setImageResource(R.drawable.follow);
		followPage_text.setTextColor(Gray);
	}
	
	//底部图标变换
	public void iconChange(int num)
	{
		switch (num) {

		case R.id.homePage_layout:case 0:
			homePage_image.setImageResource(R.drawable.homepage_pressed);
			homePage_text.setTextColor(Green);
			mPager.setCurrentItem(0,false);
			break;
		case R.id.search_layout:case 1:
			search_image.setImageResource(R.drawable.search_pressed);
			searchPage_text.setTextColor(Green);
			mPager.setCurrentItem(1,false);
			break;
		case R.id.add_layout:case 2:
			addPage_image.setImageResource(R.drawable.add_pressed);
			addPage_text.setTextColor(Green);
			mPager.setCurrentItem(2,false);
			break;
		case R.id.follow_layout:case 3:
			followPage_image.setImageResource(R.drawable.follow_pressed);
			followPage_text.setTextColor(Green);
			mPager.setCurrentItem(3,false);
			break;
		case R.id.me_layout:case 4:
			personPage_image.setImageResource(R.drawable.people_pressed);
			personPage_text.setTextColor(Green);
			mPager.setCurrentItem(4,false);
			break;

		}
		
	}
	
	
}
