package com.example.kei.keimultidictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView searchView;
    ListView listView;
    /*String[] wordList;
    ArrayAdapter<String> arrayAdapter;*/
    ListEntryAdapter entriesAdapter;
    ArrayList<WordEntry> entriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = (SearchView)findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(this);

        listView = (ListView)findViewById(R.id.listsugview);


        entriesList = new ArrayList<WordEntry>();
        WordEntry entry1 = new WordEntry("hello","xin chao",1);
        WordEntry entry2 = new WordEntry("hi","nihao",2);
        entriesList.add(entry1);
        entriesList.add(entry2);

        entriesAdapter = new ListEntryAdapter(this);
        entriesAdapter.setWordList(entriesList);

        listView.setAdapter(entriesAdapter);

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
