package com.example.atto;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.atto.database.AppDatabase;
import com.example.atto.database.ProductDao;
import com.example.atto.database.ProductWithBrandName;

import org.w3c.dom.Text;

import java.util.List;

public class Fragment_marcket_category extends Fragment {

    public Fragment_marcket_category() {

    }

    public void printAllProductByCategory(View fv, String category) {
        AppDatabase appDatabase = AppDatabase.getInstance(getActivity().getApplicationContext());
        ProductDao productDao = appDatabase.productDao();

        List<ProductWithBrandName> productWithBrandNameList;
        if(category.equals("all")) productWithBrandNameList = productDao.getAll();
        else productWithBrandNameList = productDao.findAllByCategory(category);

        printProductToView(fv, productWithBrandNameList);
    }

    public void printProductToView(View fv, List<ProductWithBrandName> productWithBrandNameList) {
        TextView numOfProduct = fv.findViewById(R.id.numOfProduct);
        numOfProduct.setText(Integer.toString(productWithBrandNameList.size()));

        TableLayout categoryTableLayout = (TableLayout) fv.findViewById(R.id.categoryTablelayout);
        categoryTableLayout.removeAllViews();
//        categoryTableLayout.removeAllViewsInLayout();
        for (ProductWithBrandName productWithBrandName : productWithBrandNameList) {
            //테이블 레이아웃에 새로운 행 추가해서 상품 출력
            TableRow tableRow = new TableRow(getActivity().getApplicationContext());
            tableRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            TextView textView = new TextView(getActivity().getApplicationContext());
            textView.setText(productWithBrandName.category);
            textView.setGravity(Gravity.LEFT);
            textView.setTextSize(14);
            tableRow.addView(textView);

            TextView textView2 = new TextView(getActivity().getApplicationContext());
            String productName = productWithBrandName.name;
            if(productName.length() > 20) productName = productName.substring(0, 20) + "\n" + productName.substring(20);
            textView2.setText(productName);
            textView2.setGravity(Gravity.LEFT);
            textView2.setTextSize(14);
            tableRow.addView(textView2);

            TextView textView3 = new TextView(getActivity().getApplicationContext());
            if (productWithBrandName.price == -1) textView3.setText("품절");
            else textView3.setText(productWithBrandName.price + " $");
            textView3.setGravity(Gravity.LEFT);
            textView3.setTextSize(14);
            tableRow.addView(textView3);

            categoryTableLayout.addView(tableRow);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fv = inflater.inflate(R.layout.fragment_marcket_category, container, false);

        Resources res = getResources();
        String[] categories = res.getStringArray(R.array.category);

        Spinner spinner = (Spinner) fv.findViewById(R.id.categorySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.categoryKOR, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                printAllProductByCategory(fv, categories[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                printAllProductByCategory(fv, "all");
            }
        });

        LinearLayout chooseCategoryButtons = fv.findViewById(R.id.chooseCategoryButtons);
        for (int i=0; i<categories.length; i++) {
            Button button = new Button(getActivity().getApplicationContext());
            button.setBackgroundResource(R.drawable.roundbutton);
            button.setText(res.getStringArray(R.array.categoryKOR)[i]);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(10, 10, 10, 10);
            button.setLayoutParams(params);

            String category = categories[i];
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    printAllProductByCategory(fv, category);
                }
            });

            chooseCategoryButtons.addView(button);
        }

        return fv;
    }
}