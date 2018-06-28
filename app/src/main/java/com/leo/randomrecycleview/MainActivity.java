package com.leo.randomrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static android.R.attr.minHeight;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recycleView;
    private RecycleAdapter adapter;
    private Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        random = new Random();
        recycleView = (RecyclerView) findViewById(R.id.recycleView);

        GridLayoutManager layoutManagerInfo = new GridLayoutManager(this, 6);
        layoutManagerInfo.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
//                int numCurrent = random.nextInt(6);
//                if (numCurrent == 0) {
//                    numCurrent += 1;
//                } else if (numCurrent == 6) {
//                    numCurrent -= 1;
//                }
//
//                return numCurrent;


                if (position % 7 == 0) {
                    return 1;
                } else if (position % 7 == 1) {
                    return 2;
                } else if (position % 7 == 2) {
                    return 3;
                } else if (position % 7 == 3) {
                    return 4;
                } else if (position % 7 == 4) {
                    return 2;
                } else if (position % 7 == 5) {
                    return 5;
                } else if (position % 7 == 6) {
                    return 1;
                } else {
                    return 6;
                }


            }
        });
        recycleView.setLayoutManager(layoutManagerInfo);

        adapter = new RecycleAdapter(this, this);
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            arrayList.add("item");
        }

        adapter.setData(arrayList);
        recycleView.setAdapter(adapter);
        recycleView.addItemDecoration(new SpacesItemDecoration(14));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_item:
                int position = (int) v.getTag();
                Toast.makeText(MainActivity.this, "当前position ====== " + position, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
