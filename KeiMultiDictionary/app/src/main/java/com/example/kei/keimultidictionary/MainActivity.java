package com.example.kei.keimultidictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView searchView;
    ListView listView;
    String[] wordList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = (SearchView)findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(this);

        listView = (ListView)findViewById(R.id.listsugview);


        wordList = new String[]{"Lion", "Tiger", "Dog",
                "Cat", "Tortoise", "Rat", "Elephant", "Fox",
                "Cow","Donkey","Monkey"};

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,wordList);
        listView.setAdapter(arrayAdapter);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        wordList = new String[]{"Na", "Kei", "Dung"};
        arrayAdapter.notifyDataSetChanged();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        /*String text = newText;
        adapter.filter(text);
        */
        wordList = new String[]{"Na", "Kei", "Dung"};
        arrayAdapter.notifyDataSetChanged();
        return false;
    }
}
