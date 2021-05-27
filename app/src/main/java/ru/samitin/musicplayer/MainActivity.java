package ru.samitin.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
MediaPlayer mediaPlayer;
    ImageView playPause;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.stuff);

        playPause=findViewById(R.id.imageViewPlayIcon);
        ImageView play=findViewById(R.id.imageViewPlay);
        play.setOnClickListener(this);
        ImageView previous=findViewById(R.id.imageViewPrevious);
        previous.setOnClickListener(this);
        ImageView next=findViewById(R.id.imageViewNext);
        next.setOnClickListener(this);

        seekBar=findViewById(R.id.seekBar);
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b)
                    mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,1000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageViewPlay:
                play();
                break;
            case R.id.imageViewPrevious:
                previos();
                break;
            case R.id.imageViewNext:
                next();
                break;
        }
    }

    public void play(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            playPause.setImageResource(R.drawable.ic_baseline_play_orange_24);
        }else {
            mediaPlayer.start();
            playPause.setImageResource(R.drawable.ic_baseline_pause_24);
        }
    }
    public void previos(){

    }
    public void next(){

    }
}