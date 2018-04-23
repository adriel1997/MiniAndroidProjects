package com.example.adriealle.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class LIST extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView v = (ListView)findViewById(R.id.the);
        Database d=new Database(this);
        SQLiteDatabase g=d.getReadableDatabase();
        Cursor c = g.query("REG",null,null,null, null, null, null);
        SimpleCursorAdapter p = new SimpleCursorAdapter(this,R.layout.order,c,new String[] {"name","phone_number","room","mail"},new int [] {R.id.a,R.id.b,R.id.c,R.id.d},0);
        v.setAdapter(p);
        v.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                Toast.makeText(getApplicationContext(),i, Toast.LENGTH_LONG).show();
            }
        });

    }

}
