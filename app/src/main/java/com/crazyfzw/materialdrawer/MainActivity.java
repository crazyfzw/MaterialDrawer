package com.crazyfzw.materialdrawer;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar toolbar;
    private CircleImageView currentUserAvater;
    private TextView currentUserName;
    private TextView currentUserSignature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initContentView();
        initViews();
    }


    public void initContentView() {

        setContentView(R.layout.activity_main);
    }


    public void initViews() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        mNavigationView = (NavigationView) findViewById(R.id.id_navigationview);

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

        currentUserAvater.setImageResource(R.drawable.default_avater);
        currentUserName.setText("crazyfzw");
        currentUserSignature.setText("平静温和地前进");

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
//                    case R.id.nav_menu_home:
//                        msgString = (String) menuItem.getTitle();
//                        break;
//                    case R.id.nav_menu_categories:
//                        msgString = (String) menuItem.getTitle();
//                        break;
//                    case R.id.nav_menu_feedback:
//                        msgString = (String) menuItem.getTitle();
//                        break;
//                    case R.id.nav_menu_setting:
//                        msgString = (String) menuItem.getTitle();
//                        break;
                }

                // Menu item点击后选中，并关闭Drawerlayout
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }


}