package com.example.adriealle.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
int i=0;
    double st ;
    double e;

    private Handler m= new Handler();
    final MediaPlayer mediaplayer[] = new MediaPlayer[3];
    private SeekBar s;
    int onetime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mediaplayer[0] = MediaPlayer.create(this, R.raw.black);
        mediaplayer[1] = MediaPlayer.create(this, R.raw.marsh);

        final ImageButton play = (ImageButton) findViewById(R.id.play);
        final ImageButton pause = (ImageButton) findViewById(R.id.pause);
        final ImageButton pre = (ImageButton) findViewById(R.id.previous);
        final ImageButton next = (ImageButton) findViewById(R.id.next);



        final ImageView im[] = new ImageView[3];
        im[0] = (ImageView) findViewById(R.id.imageView);
        im[1] = (ImageView) findViewById(R.id.imageView);

        s = (SeekBar) findViewById(R.id.seekBar);

        pause.setEnabled(false);

        play.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

        st = mediaplayer[i].getCurrentPosition();
                                        e = mediaplayer[i].getDuration();
                                               if(onetime==0) {
        s.setMax((int)e);
        }
        if (i == 0) {
        im[i].setImageResource(R.drawable.black);
        } else
        im[i].setImageResource(R.drawable.mello);
        mediaplayer[i].start();
        Toast.makeText(getApplicationContext(), "Media play is on", Toast.LENGTH_LONG).show();
        m.postDelayed(UpdateSongtime,100);
        s.setProgress((int)st);
        pause.setEnabled(true);
        play.setEnabled(false);
                                    }
                                }
        );

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaplayer[i].seekTo(0);
                mediaplayer[i].pause();
                if (i == 1) {
                    i = 0;
                    im[i].setImageResource(R.drawable.black);
                } else {
                    i = i + 1;
                    im[i].setImageResource(R.drawable.mello);
                }
                mediaplayer[i].start();
            }
        });


        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaplayer[i].seekTo(0);
                mediaplayer[i].pause();
                if (i == 0) {
                    i = 1;
                    im[i].setImageResource(R.drawable.mello);
                } else
                    i = i - 1;
                im[i].setImageResource(R.drawable.black);
                mediaplayer[i].start();
            }
        });


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "Media play is paused", Toast.LENGTH_LONG).show();
        mediaplayer[i].pause();
        play.setEnabled(true);
        pause.setEnabled(false);

            }
        });

    }
private Runnable UpdateSongtime=new Runnable() {
    public void run() {
        st=mediaplayer[i].getCurrentPosition();
        s.setProgress((int)st);
        m.postDelayed(this,100);
    }
};
}

