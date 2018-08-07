package com.example.kei.keimultidictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView searchView;
    ListView listView;
    TextView contentView;
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

        contentView = (TextView) findViewById(R.id.contentview);
        contentView.setVisibility(View.INVISIBLE);


        entriesList = new ArrayList<WordEntry>();
        WordEntry entry1 = new WordEntry("hello","xin chao",1);
        WordEntry entry2 = new WordEntry("hi","nihao",2);
        entriesList.add(entry1);
        entriesList.add(entry2);

        entriesAdapter = new ListEntryAdapter(this);
        entriesAdapter.setWordList(entriesList);

        listView.setAdapter(entriesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                WordEntry entry = (WordEntry) o;
                listView.setVisibility(View.INVISIBLE);
                contentView.setText(entry.getMean());
                contentView.setVisibility(View.VISIBLE);
                //Toast.makeText(MainActivity.this, "Selected :" + " " + country, Toast.LENGTH_LONG).show();
            }
        });

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
