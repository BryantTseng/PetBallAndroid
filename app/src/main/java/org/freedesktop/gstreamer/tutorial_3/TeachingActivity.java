package org.freedesktop.gstreamer.tutorials.tutorial_3;
//package comzhf.android_viewpager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class TeachingActivity extends Activity {
    private ViewPager mViewPager;
    List<View> viewList;
    //private List titleList;


    private ViewGroup group;
    private ImageView imageView;
 //定義一個ImageVIew數組，來存放生成的小園點
    private ImageView[] imageViews;
    private View v1;
    private View v2;
    private View v3;
    private View v4;
    private View v5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teaching);

        cut_title();
        initPages();
        initPointer();
        initViewPager();

    }

    public void click(View v){
        Intent intent = new Intent();
        intent .putExtra("First","Y"); // first time need teaching guideline
        intent.setClass(TeachingActivity.this , org.freedesktop.gstreamer.tutorials.tutorial_3.Tutorial3.class);
        startActivity(intent);

    }
    private void cut_title(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    private void initPages(){
        LayoutInflater mInflater = getLayoutInflater().from(this);

        v1 = mInflater.inflate(R.layout.teaching_1, null);
        v2 = mInflater.inflate(R.layout.teaching_2, null);
        v3 = mInflater.inflate(R.layout.teaching_3, null);
        v4 = mInflater.inflate(R.layout.teaching_4, null);
        v5 = mInflater.inflate(R.layout.teaching_5, null);
        viewList = new ArrayList<View>();
        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        viewList.add(v4);
        viewList.add(v5);


        mViewPager = (ViewPager) findViewById(R.id.viewpager);
    }
    private void initPointer() {
        group = (ViewGroup) findViewById(R.id.viewGroup);

        imageViews = new ImageView[viewList.size()];
        for (int i = 0; i < imageViews.length; i++) {
            LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            margin.setMargins(60, 0, 0, 0);

            imageView = new ImageView(this);

            imageView.setLayoutParams(new ViewGroup.LayoutParams(25, 25));

            //imageView.setPadding(30, 0, 30, 0);

            imageViews[i] = imageView;

            if (i == 0) {
                imageViews[i].setBackgroundResource(R.drawable.red_circle);


                } else {
                imageViews[i].setBackgroundResource(R.drawable.gray_circle);
                }
            group.addView(imageViews[i],margin);
            }
        }
    private void initViewPager(){
        mViewPager.setAdapter(new MyAdapter());
        mViewPager.setCurrentItem(0);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < imageViews.length; i++) {
                    if (i == position) {
                        imageViews[i].setBackgroundResource(R.drawable.red_circle);


                    } else {
                        imageViews[i].setBackgroundResource(R.drawable.gray_circle);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public class MyAdapter extends PagerAdapter {
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {

            return arg0 == arg1;
        }

        @Override
        public int getCount() {

            return viewList.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));

        }

        @Override
        public int getItemPosition(Object object) {

            return super.getItemPosition(object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));

            return viewList.get(position);
        }

    };

}
