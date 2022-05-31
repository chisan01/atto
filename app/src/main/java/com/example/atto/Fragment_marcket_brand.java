package com.example.atto;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_marcket_brand extends Fragment {

    public Fragment_marcket_brand(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fv=inflater.inflate(R.layout.fragment_marcket_brand, container, false);

        //브랜드별 화면 불러오기
        TextView btn;
        btn=fv.findViewById(R.id.callBrand);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),BrandActivity.class);
                startActivity(intent);
            }
        });

        return fv;
    }
}