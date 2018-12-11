package com.hfad.starbuzz;

import android.app.Activity;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;
import android.widget.CursorAdapter;
import android.widget.Toast;

public class TopLevelActivity extends Activity {

    private SQLiteDatabase db;
    private Cursor favoriteCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);
        setupOptionsListView();
        setupFavoritesListView();
        /*
        //Create an OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(TopLevelActivity.this,
                            DrinkCategoryActivity.class);
                    startActivity(intent);
                }       
            }
        };
        //Add the listener to the list view
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
        */
    }

    private void setupOptionsListView() {
        //Create an OnItemCLickListener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView,
                                    View itemView,
                                    int position,
                                    long id) {
                if (position == 0) {
                    Intent intent = new Intent(TopLevelActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }
            }
        };
        //Add the listener to the list view
        ListView listView = (ListView)findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }

    private void setupFavoritesListView() {
        //Populate the list_favorites ListView from a cursor
        ListView listFavorites = (ListView)findViewById(R.id.list_favorites);
        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            db = starbuzzDatabaseHelper.getReadableDatabase();
            //favoriteCursor
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
