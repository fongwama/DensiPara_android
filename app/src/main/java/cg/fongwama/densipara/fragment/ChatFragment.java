package cg.fongwama.densipara.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.curiosity.louka.R;
import com.curiosity.louka.adapter.AdapterRecylerviewChat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP Notebook on 03/10/2017.
 */
public class ChatFragment extends Fragment{

    private List<Integer> image=new ArrayList<>();
    private List<String> data;
    private List<String>message=new ArrayList<>();

    public ChatFragment(){


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

    }
}
