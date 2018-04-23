package com.example.adriealle.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);
        final String h2,z,x,b,v;
        TextView q=(TextView)findViewById(R.id.textView);
        TextView r=(TextView)findViewById(R.id.textView2);
        TextView p=(TextView)findViewById(R.id.textView3);
        TextView t=(TextView)findViewById(R.id.textView4);
        h2=getIntent().getExtras().getString("kil");
        Database d=new Database(this);
        SQLiteDatabase g=d.getReadableDatabase();
        if(g!=null) {
            Cursor c = g.query("REG",null,"phone_number=?",new String[]{h2}, null, null, null);
            if (c != null) {
                c.moveToFirst();
                z=c.getString(1);
                x=c.getString(2);
                b=c.getString(3);
                v=c.getString(4);
                q.setText("NAME :" + z);
                r.setText("Phone no. :" +x);
             p.setText("Room no. :" +b);
                t.setText("E-mail id :" +v);
            }
        }
    }
}
