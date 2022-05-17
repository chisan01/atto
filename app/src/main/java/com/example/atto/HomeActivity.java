package com.example.atto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeActivity extends AppCompatActivity {

    ImageButton mybtn;
    Button marcketbtn, restaurantbtn, scrapbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //기본 프레임 -> 인기 상품 표시 프레임
        {
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            Fragment_marcket_page_Activity marcketFragment = new Fragment_marcket_page_Activity();
            transaction.replace(R.id.frame, marcketFragment);
            transaction.commit();
        }

        //마이페이지 버튼
        mybtn=(ImageButton) findViewById(R.id.mybtn);
        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {  //프레그먼트 지우고 마이페이지 화면 출력 왜안대?
                //프레그먼트땜에 화면이 가려져서 안보이는 건가?????????
                Fragment fragment=getSupportFragmentManager().findFragmentById(R.id.frame);
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment);
                //setTransaction을 이용해 애니메이션을 추가해서 프레그먼트가 지워지는걸 자연스럽게 보여줄 수 잇다.
                Intent intent=new Intent(getApplicationContext(), MypageActivity.class);
                startActivity(intent);
            }
        });

        marcketbtn=(Button) findViewById(R.id.marcketbtn);
        marcketbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                Fragment_marcket_page_Activity marcketFragment = new Fragment_marcket_page_Activity();
                transaction.replace(R.id.frame, marcketFragment);
                transaction.commit();
            }
        });

        restaurantbtn=(Button) findViewById(R.id.restaurantbtn);
        restaurantbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                Fragment_restaurant_page_Activity restaurantFragment = new Fragment_restaurant_page_Activity();
                transaction.replace(R.id.frame, restaurantFragment);
                transaction.commit();
            }
        });

        scrapbtn=(Button) findViewById(R.id.scrapbtn);
        scrapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                Fragment_myscrap_page_Activity myscrapFragment = new Fragment_myscrap_page_Activity();
                transaction.replace(R.id.frame, myscrapFragment);
                transaction.commit();
            }
        });

    }
}