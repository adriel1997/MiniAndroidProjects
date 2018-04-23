package com.example.adriealle.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final EditText name = (EditText) findViewById(R.id.editText);
        final EditText phone = (EditText) findViewById(R.id.editView2);
        final EditText room = (EditText) findViewById(R.id.editView3);
        final EditText email = (EditText) findViewById(R.id.editText4);
        Button submit=(Button)findViewById(R.id.button3);
     submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nl=new Intent(Main2Activity.this,MainActivity.class);
                final  Database db = new Database(Main2Activity.this);
                db.addContact(name.getText().toString(),phone.getText().toString(),email.getText().toString(),room.getText().toString());
                Toast.makeText(Main2Activity.this, "Successful Submission", Toast.LENGTH_SHORT).show();
                        startActivity(nl);
            }
        });


    }
}
