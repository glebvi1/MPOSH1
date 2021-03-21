package com.example.mposh.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mposh.SurfaceView1;

import java.util.ArrayList;

public class TabOne extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ArrayList<Float> f = new ArrayList<Float>();
        f.add(1f);
        f.add(2f);
        f.add(3f);
        f.add(4f);
        f.add(5f);
        f.add(6f);

        SurfaceView1 s = new SurfaceView1(super.getContext());
        s.get1(f);
        return s;
        //return inflater.inflate( R.layout.life_fragment, container, false );
    }
}
