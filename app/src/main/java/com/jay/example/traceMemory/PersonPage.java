package com.jay.example.traceMemory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alanllzw on 2017-04-04.
 */

public class PersonPage extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState)
    {
        View view = inflater.inflate(R.layout.personpage,container,false);
        return view;
    }
}
