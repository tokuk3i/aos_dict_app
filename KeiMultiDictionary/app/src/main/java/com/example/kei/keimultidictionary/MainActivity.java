package com.example.kei.keimultidictionary;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    DictionaryData handle;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        handle = new DictionaryData(this.getApplicationContext());
        db = handle.getReadableDatabase();
//        WordEntry entry1 = new WordEntry("kei","xin chao",1);
//        WordEntry entry2 = new WordEntry("dung","nihao",2);
//        handle.addNewWord(entry1);
//        handle.addNewWord(entry2);

        Cursor check  = handle.getData();
        Log.d("main","num : "+check.getCount());

        searchView = (SearchView)findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(this);

        listView = (ListView)findViewById(R.id.listsugview);

        contentView = (TextView) findViewById(R.id.contentview);
        contentView.setVisibility(View.INVISIBLE);


        entriesList = new ArrayList<WordEntry>();
        //entriesList = handle.getAllData();
        entriesList = handle.getSugesstionList("ke");

        entriesAdapter = new ListEntryAdapter(this);
        entriesAdapter.setWordList(entriesList);


        //db.execSQL("INSERT INTO master_dict　(dict_id,word,mean) VALUES (1,'test','dfghj')");
        //Message.message(this.getApplicationContext(),"TABLE CREATED" + db.getPath());
        //entriesList = handle.getSugesstionList(db,null);

        //Cursor test = db.rawQuery("SELECT * FROM master_dict",null);
        //Log.d("kei","test");
        //Message.message(this.getApplicationContext(),"TABLE CREATED : " + test.getCount());




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

        listView.setVisibility(View.INVISIBLE);
        contentView.setText(query);
        contentView.setVisibility(View.VISIBLE);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        /*String text = newText;
        adapter.filter(text);
        */
        entriesList.clear();
        entriesList = handle.getSugesstionList(newText);
        entriesAdapter.setWordList(entriesList);
        //entriesList = new ArrayList<WordEntry>(handle.getSugesstionList(newText));
        //Log.d("main","number : "+entriesList.size());
        entriesAdapter.notifyDataSetChanged();
        listView.setVisibility(View.VISIBLE);
        contentView.setVisibility(View.INVISIBLE);
        return false;
    }
}
