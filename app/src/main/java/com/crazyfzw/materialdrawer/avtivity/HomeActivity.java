package com.crazyfzw.materialdrawer.avtivity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.crazyfzw.materialdrawer.adapter.HomeViewPagerAdapter;
import com.crazyfzw.materialdrawer.base.BaseActivity;
import com.crazyfzw.materialdrawer.fragment.HomeTabFragment1;
import com.crazyfzw.materialdrawer.fragment.HomeTabFragment2;
import com.crazyfzw.materialdrawer.fragment.HomeTabFragment3;
import com.crazyfzw.materialdrawer.fragment.HomeTabFragment4;
import com.crazyfzw.materialdrawer.viewmodule.CircleImageView;
import com.crazyfzw.materialdrawer.R;

public class HomeActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar toolbar;
    private CircleImageView currentUserAvater;
    private TextView currentUserName;
    private TextView currentUserSignature;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HomeViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initContentView();
        initViews();
        initListeners();
        initData();
    }

    @Override
    public void initContentView() {

        setContentView(R.layout.activity_home);
    }

    @Override
    public void initViews() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        mNavigationView = (NavigationView) findViewById(R.id.id_navigationview);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.pager);



        if (viewPager != null) {
            setupViewPager(viewPager);
        }



        /**
         * init DrawLayout+Navigation
         */

        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mNavigationView.inflateHeaderView(R.layout.navigation_header);
        mNavigationView.inflateMenu(R.menu.menu_navigation);

        // 设置NavigationView中menu的item被选中后要执行的操作
        onNavgationViewMenuItemSelected(mNavigationView);


        /**
         * 当前用户信息
         */
        View navheaderView = mNavigationView.getHeaderView(0);  //获取头部布局

        currentUserAvater = (CircleImageView) navheaderView.findViewById(R.id.current_userAvater);
        currentUserName = (TextView) navheaderView.findViewById(R.id.current_userName);
        currentUserSignature = (TextView) navheaderView.findViewById(R.id.current_userSignature);

    }

    @Override
    public void initListeners() {}



    @Override
    public void initData() {

        currentUserAvater.setImageResource(R.drawable.default_avater);
        currentUserName.setText("肉肉仔");
        currentUserSignature.setText("平静温和地前进");

    }



    /**
     * 设置ViewPager+Fragment
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        adapter = new HomeViewPagerAdapter(getSupportFragmentManager(), this);
        adapter.addFragment(new HomeTabFragment1().newInstance("Page1"), "视频");
        adapter.addFragment(new HomeTabFragment2().newInstance("Page2"), "音乐");
        adapter.addFragment(new HomeTabFragment3().newInstance("Page3"), "新闻");
        adapter.addFragment(new HomeTabFragment4().newInstance("Page4"), "娱乐");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }



    /**
     * 设置NavigationView中menu的item被选中后要执行的操作
     *
     * @param mNav
     */
    private void onNavgationViewMenuItemSelected(NavigationView mNav) {
        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                String msgString = "";

                switch (menuItem.getItemId()) {

                    // do your business here eg:
                    // case R.id.nav_menu_home:
                    //    msgString = (String) menuItem.getTitle();
                    //     break;

                }

                // Menu item点击后选中，并关闭Drawerlayout
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
