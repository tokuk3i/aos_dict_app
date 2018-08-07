package com.example.kei.keimultidictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView searchView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = (SearchView)findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(this);

        listView = (ListView)findViewById(R.id.listsugview);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        /*String text = newText;
        adapter.filter(text);
        */
        return false;
    }
}
