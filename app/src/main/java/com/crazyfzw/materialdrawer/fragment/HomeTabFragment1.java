package com.crazyfzw.materialdrawer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crazyfzw.materialdrawer.R;



public class HomeTabFragment1 extends Fragment{

    private static final String ARG_PARAM1 = "tab1";
    private View myView;
    private TextView textView;

    public static HomeTabFragment1 newInstance(String param1) {
        HomeTabFragment1 fragment = new HomeTabFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    public HomeTabFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_tab1, container, false);
        textView = (TextView) myView.findViewById(R.id.textView1);
        textView.setText(ARG_PARAM1);
        return myView;
    }




}
