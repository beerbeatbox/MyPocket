package com.example.jarvis.mypocket.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jarvis.mypocket.R;

/**
 * Created by Jarvis on 04-Sep-17.
 */

public class MainFragment extends Fragment {

    int someVar;
    TextView tv;
    public static MainFragment newInstance(int someVar) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt("someVar",someVar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        someVar = getArguments().getInt("someVar");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container , false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        tv = (TextView)rootView.findViewById(R.id.tv);
    }

    public void setTextview(String txt) {
        tv.setText(txt);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save state
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // restore state
        }
    }
}
