package com.crazyfzw.materialdrawer.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crazyfzw.materialdrawer.R;



public class HomeTabFragment3 extends Fragment{

    private static final String ARG_PARAM1 = "tab3";
    private View myView;
    private TextView textView;

    public static HomeTabFragment3 newInstance(String param1) {
        HomeTabFragment3 fragment = new HomeTabFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    public HomeTabFragment3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_tab3, container, false);
        textView = (TextView) myView.findViewById(R.id.textView3);
        textView.setText(ARG_PARAM1);
        return myView;
    }


}
