package com.example.adriealle.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer mediaplayer = new MediaPlayer();
        mediaplayer = MediaPlayer.create(this, R.raw.deb_clai);
        mediaplayer.start();
        final EditText e = (EditText) findViewById(R.id.editText4);
        Button log = (Button) findViewById(R.id.button4);
        Button sign = (Button) findViewById(R.id.button2);
        Button master=(Button)findViewById(R.id.button);

        master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = e.getText().toString();
                String j = "00";
                if (s.equals(j)) {
                    Intent q = new Intent(MainActivity.this, LIST.class);
                    startActivity(q);
                } else
                    Toast.makeText(getApplicationContext(), "NICE TRY  ;)", Toast.LENGTH_LONG).show();
            }
        });


            log.setOnClickListener(new View.OnClickListener() {
       @Override
     public void onClick(View view) {
           Intent f = new Intent(MainActivity.this, Main3Activity.class);
           s = e.getText().toString();
           f.putExtra("kil",s);
               Toast.makeText(getApplicationContext(), "Welcome Back Dude!!!", Toast.LENGTH_LONG).show();
            startActivity(f);


   }
   });


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "WELCOME SIR", Toast.LENGTH_LONG).show();
                Intent j = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(j);

            }
        });

}
}