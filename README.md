# MaterialDrawer
DrawerLayout+NavigationView打造Google原生Material Design风格侧滑菜单


实现细节可以看我博客：
[DrawerLayout+NavigationView打造Google原生Material Design风格侧滑菜单](http://blog.csdn.net/fzw_faith/article/details/51536911)

###运行效果图

![images](https://github.com/crazyfzw/ProjectImages/blob/master/MaterialDrawer/materialdesign.gif)


### Make step：

####1.add activity_main.xml
```xml
  <android.support.v4.widget.DrawerLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/id_drawerlayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!-- 第一个位置 主界面内容 main content-->
    <include layout="@layout/content_main" />


    <!-- 第二个位置  来放Drawerlayout中的内容-->
    <android.support.design.widget.NavigationView
        android:id="@+id/id_navigationview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:itemTextColor="@color/selector_nav_menu_textcolor"
        android:layout_gravity="left" />

</android.support.v4.widget.DrawerLayout>
```

####2.custom your drawer header  navigation_header.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="220dp"
    android:background="@drawable/nav_header"
    android:gravity="center"
    android:orientation="vertical">
    <com.crazyfzw.materialdrawer.CircleImageView
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/current_userAvater"
        android:layout_width="70dp"
        android:layout_height="70dp"
        app:civ_border_width="0dp"
        app:civ_border_color="#FFFFFF"/>

    <TextView
        android:id="@+id/current_userName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="4dp"
        android:textColor="@color/text__white"
        android:textSize="16sp"
        android:text="crazyfzw"/>


    <TextView
        android:id="@+id/current_userSignature"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="5dp"
        android:textColor="@color/text__white"
        android:textSize="18sp"
        android:text="野蛮体魄"/>

</LinearLayout>
```

####3.custom your drawer menu item  menu_navigation.xml

````xml
<?xml version="1.0" encoding="utf-8"?>
<menu android:checkableBehavior="single"
    xmlns:android="http://schemas.android.com/apk/res/android"><group android:id="@+id/nav_group1" android:checkableBehavior="single">
        <item
            android:icon="@drawable/ic_home_black_24dp"
            android:id="@+id/nav_home"
            android:title="@string/nav_home"
            android:checkable="true" />
        <item
            android:icon="@drawable/ic_file_download_black_24dp"
            android:id="@+id/nav_offline_manager"
            android:title="@string/nav_offline_manager"
            android:checkable="true" />
    </group>

    <group android:id="@+id/nav_group2" android:checkableBehavior="single">
        <item
            android:icon="@drawable/ic_star_black_24dp"
            android:id="@+id/nav_favorites"
            android:title="@string/nav_favorites"
            android:checkable="true" />

        <item
            android:icon="@drawable/ic_history_black_24dp"
            android:id="@+id/nav_histories"
            android:title="@string/nav_histories"
            android:checkable="true" />

        <item
            android:icon="@drawable/ic_people_black_24dp"
            android:id="@+id/nav_following"
            android:title="@string/nav_following"
            android:checkable="true" />

        <item
            android:icon="@drawable/ic_account_balance_wallet_black_24dp"
            android:id="@+id/nav_pay"
            android:title="@string/nav_growth_process"
            android:checkable="true" />

    </group>

    <group android:id="@+id/nav_group3" android:checkableBehavior="single">

        <item
            android:icon="@drawable/ic_color_lens_black_24dp"
            android:id="@+id/nav_theme"
            android:orderInCategory="1"
            android:title="@string/title_theme_store"
            android:checkable="true" />

        <item
            android:icon="@drawable/ic_settings_black_24dp"
            android:id="@+id/nav_settings"
            android:orderInCategory="3"
            android:title="@string/nav_settings"
            android:checkable="true" />
    </group>
</menu>
````

####4.use java init in your activity  

```java
     public void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);
        mNavigationView = (NavigationView) findViewById(R.id.id_navigationview);

        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mNavigationView.inflateHeaderView(R.layout.navigation_header);
        mNavigationView.inflateMenu(R.menu.menu_navigation);

        // 设置NavigationView中menu的item被选中后要执行的操作
        onNavgationViewMenuItemSelected(mNavigationView);

        View navheaderView = mNavigationView.getHeaderView(0);  //获取头部布局

        currentUserAvater = (CircleImageView) navheaderView.findViewById(R.id.current_userAvater);
        currentUserName = (TextView) navheaderView.findViewById(R.id.current_userName);
        currentUserSignature = (TextView) navheaderView.findViewById(R.id.current_userSignature);

        currentUserAvater.setImageResource(R.drawable.default_avater);
        currentUserName.setText("crazyfzw");
        currentUserSignature.setText("平静温和地前进");

    }



    /**
     * add item select listener
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
```

done.
