package com.example.kaitzer.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        //this is the data for our recycler view
        ItemData itemsData[] = {new ItemData("Alkane", R.drawable.one),
                new ItemData("Ethane", R.drawable.two),
                new ItemData("Aljyne", R.drawable.three),
                new ItemData("Benzene", R.drawable.four),};

        //StaggeredLayout
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,0)); //3 columns & 1 represent orientation (1 is vertical, 0 horizontal)
     //create an adapter
       myAdapter mAdapter = new myAdapter(itemsData, getApplicationContext());
     //set adapter
        recyclerView.setAdapter(mAdapter);
      //set item animator to DefaultAnimator
      recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
