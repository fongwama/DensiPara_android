package cg.fongwama.densipara.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cg.fongwama.densipara.R;

/**
 * Created by HP Notebook on 03/10/2017.
 */
public class SauvegardeFragment extends Fragment{

    public SauvegardeFragment(){


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v=inflater.inflate(R.layout.content_nouveau,container,false);
    return null;
    }
}
