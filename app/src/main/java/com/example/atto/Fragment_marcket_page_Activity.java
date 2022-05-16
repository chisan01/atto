package com.example.atto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment_marcket_page_Activity extends Fragment {
    public Fragment_marcket_page_Activity(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fv=inflater.inflate(R.layout.activity_fragment_marcket_page, container, false);

        Button categorybtn, brandbtn;
        categorybtn=(Button) fv.findViewById(R.id.categorybtn);
        brandbtn=(Button) fv.findViewById(R.id.brandbtn);

        categorybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getChildFragmentManager().beginTransaction();
                Fragment_marcket_category categoryFragment = new Fragment_marcket_category();
                transaction.replace(R.id.marcketframe, categoryFragment);
                transaction.commit();
            }
        });

        brandbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getChildFragmentManager().beginTransaction();
                Fragment_marcket_brand brandFragment = new Fragment_marcket_brand();
                transaction.replace(R.id.marcketframe, brandFragment);
                transaction.commit();
            }
        });

        return fv;
    }
}