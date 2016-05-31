package com.crazyfzw.materialdrawer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crazyfzw.materialdrawer.R;



public class HomeTabFragment2 extends Fragment{

    private static final String ARG_PARAM1 = "tab2";
    private View myView;
    private TextView textView;

    public static HomeTabFragment2 newInstance(String param1) {
        HomeTabFragment2 fragment = new HomeTabFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    public HomeTabFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_tab2, container, false);
        textView = (TextView) myView.findViewById(R.id.textView2);
        textView.setText(ARG_PARAM1);
        return myView;
    }




}
