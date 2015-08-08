package com.example.day07_29;

import java.util.ArrayList;
import java.util.List;

import com.example.adapter.MyBaseAdapter;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.Adapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView listView;
	ArrayList<String> list;
	MyBaseAdapter adapter;
	Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        listView = (ListView) findViewById(R.id.listView1);
        list = new ArrayList<String>();
        for(int i = 0;i<=100;i++){
        	list.add(Integer.toString(i));
        }
        adapter = new MyBaseAdapter(context, list);
        listView.setAdapter(adapter);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
