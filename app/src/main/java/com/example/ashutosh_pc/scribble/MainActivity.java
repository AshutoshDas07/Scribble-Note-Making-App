package com.example.ashutosh_pc.scribble;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<TextActivity> ListItems = new ArrayList<>();
    FloatingActionButton fab;
    RecyclerView mylist;
    maindisplayadapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myadapter = new maindisplayadapter(ListItems,this);
        fab=findViewById(R.id.fab);
        mylist=findViewById(R.id.recyclerview);
        mylist.setLayoutManager(new StaggeredGridLayoutManager(2,1));
        mylist.setItemAnimator(new DefaultItemAnimator());
        mylist.setAdapter(myadapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, noting_space.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "onResume: " + ListItems.size());
        myadapter.notifyDataSetChanged();
    }
}
