package com.example.atto;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment_marcket_page_Activity extends Fragment {
    private TableLayout tableLayout;
    ImageButton mybtn;
    Button categorybtn, brandbtn;

    public Fragment_marcket_page_Activity(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fv=inflater.inflate(R.layout.activity_fragment_marcket_page, container, false);

        //마이페이지 버튼 ->마이페이지로 이동
        mybtn=(ImageButton) fv.findViewById(R.id.mybtn);
        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //fragment에서 intent 호출할 땐 getActivity()사용
                Intent intent=new Intent(getActivity(), MypageActivity.class);
                startActivity(intent);
            }
        });

        categorybtn=(Button) fv.findViewById(R.id.categorybtn);
        brandbtn=(Button) fv.findViewById(R.id.brandbtn);
        //카테고리 별 상품보기 fragment 호출
        categorybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getChildFragmentManager().beginTransaction();
                Fragment_marcket_category categoryFragment = new Fragment_marcket_category();
                transaction.replace(R.id.marcketframe, categoryFragment);
                transaction.commit();
            }
        });

        //브랜드별 상품보기 fragment 호출
        brandbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getChildFragmentManager().beginTransaction();
                Fragment_marcket_brand brandFragment = new Fragment_marcket_brand();
                transaction.replace(R.id.marcketframe, brandFragment);
                transaction.commit();
            }
        });

        //인기상품 출력

        return fv;
    }
}