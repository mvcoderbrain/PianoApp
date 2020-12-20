package com.example.pianoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import static com.example.pianoapp.MainActivity.mFileName1;
import static com.example.pianoapp.MainActivity.mFileName2;
import static com.example.pianoapp.MainActivity.mFileName3;
import static com.example.pianoapp.MainActivity.mFileName4;
import static com.example.pianoapp.MainActivity.mFileName5;
import static com.example.pianoapp.MainActivity.mFileName6;

public class PlayingActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private Button record1, record2, record3, record4, record5, record6;


    private boolean isPlaying1;
    private boolean isPlaying2;
    private boolean isPlaying3;
    private boolean isPlaying4;
    private boolean isPlaying5;
    private boolean isPlaying6;


    private boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        record1 = findViewById(R.id.button);
        record2 = findViewById(R.id.button2);
        record3 = findViewById(R.id.button3);
        record4 = findViewById(R.id.button4);
        record5 = findViewById(R.id.button5);
        record6 = findViewById(R.id.button6);

        record1.setBackgroundResource(R.drawable.playsongshape);
        record2.setBackgroundResource(R.drawable.playsongshape);
        record3.setBackgroundResource(R.drawable.playsongshape);
        record4.setBackgroundResource(R.drawable.playsongshape);
        record5.setBackgroundResource(R.drawable.playsongshape);
        record6.setBackgroundResource(R.drawable.playsongshape);

        isPlaying =false;

        isPlaying1 = false;
        isPlaying2 = false;
        isPlaying3 = false;
        isPlaying4 = false;
        isPlaying5 = false;
        isPlaying6 = false;
    }

    public void play1(View view) {
        if (!isPlaying1 && !isPlaying){
            record1.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(1);
            isPlaying = true;
            isPlaying1 = true;
        }
        else if (!isPlaying1 && !isPlaying){
            stopPlaying();
            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);

            isPlaying = false;
            isPlaying1 = false;
            isPlaying2 = false;
            isPlaying3 = false;
            isPlaying4 = false;
            isPlaying5 = false;
            isPlaying6 = false;

            record1.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(1);
            isPlaying1 = true;
        }
        else {
            record1.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isPlaying = false;
            isPlaying1 = false;
        }
    }

    public void play2(View view) {
        if (!isPlaying2 && !isPlaying){
            record2.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(2);
            isPlaying = true;
            isPlaying2 = true;
        }
        else if (!isPlaying2 && !isPlaying){
            stopPlaying();
            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);

            isPlaying = false;
            isPlaying1 = false;
            isPlaying2 = false;
            isPlaying3 = false;
            isPlaying4 = false;
            isPlaying5 = false;
            isPlaying6 = false;

            record2.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(2);
            isPlaying2 = true;
        }
        else {
            record2.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isPlaying = false;
            isPlaying2 = false;
        }
    }

    public void play3(View view) {
        if (!isPlaying3 && !isPlaying){
            record3.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(3);
            isPlaying = true;
            isPlaying3 = true;
        }
        else if (!isPlaying3 && !isPlaying){
            stopPlaying();
            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);

            isPlaying = false;
            isPlaying1 = false;
            isPlaying2 = false;
            isPlaying3 = false;
            isPlaying4 = false;
            isPlaying5 = false;
            isPlaying6 = false;

            record3.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(3);
            isPlaying3 = true;
        }
        else {
            record3.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isPlaying = false;
            isPlaying3 = false;
        }
    }

    public void play4(View view) {
        if (!isPlaying4 && !isPlaying){
            record4.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(4);
            isPlaying = true;
            isPlaying4 = true;
        }
        else if (!isPlaying4 && !isPlaying){
            stopPlaying();
            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);

            isPlaying = false;
            isPlaying1 = false;
            isPlaying2 = false;
            isPlaying3 = false;
            isPlaying4 = false;
            isPlaying5 = false;
            isPlaying6 = false;

            record4.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(4);
            isPlaying4 = true;
        }
        else {
            record4.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isPlaying = false;
            isPlaying4 = false;
        }
    }

    public void play5(View view) {
        if (!isPlaying5 && !isPlaying){
            record5.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(5);
            isPlaying = true;
            isPlaying5 = true;
        }
        else if (!isPlaying5 && !isPlaying){
            stopPlaying();
            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);

            isPlaying = false;
            isPlaying1 = false;
            isPlaying2 = false;
            isPlaying3 = false;
            isPlaying4 = false;
            isPlaying5 = false;
            isPlaying6 = false;

            record5.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(5);
            isPlaying5 = true;
        }
        else {
            record5.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isPlaying = false;
            isPlaying5 = false;
        }
    }

    public void play6(View view) {
        if (!isPlaying6 && !isPlaying){
            record6.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(6);
            isPlaying = true;
            isPlaying6 = true;
        }
        else if (!isPlaying6 && !isPlaying){
            stopPlaying();
            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);

            isPlaying = false;
            isPlaying1 = false;
            isPlaying2 = false;
            isPlaying3 = false;
            isPlaying4 = false;
            isPlaying5 = false;
            isPlaying6 = false;

            record6.setBackgroundResource(R.drawable.playsongshapepressed);
            startPlaying(6);
            isPlaying6 = true;
        }
        else {
            record6.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isPlaying = false;
            isPlaying6 = false;
        }
    }

    private void startPlaying(int recordingNo) {

        mPlayer = new MediaPlayer();
        try {
            switch (recordingNo){
                case 1:
                    mPlayer.setDataSource(mFileName1);
                    break;
                case 2:
                    mPlayer.setDataSource(mFileName2);
                    break;
                case 3:
                    mPlayer.setDataSource(mFileName3);
                    break;
                case 4:
                    mPlayer.setDataSource(mFileName4);
                    break;
                case 5:
                    mPlayer.setDataSource(mFileName5);
                    break;
                case 6:
                    mPlayer.setDataSource(mFileName6);
                    break;

            }
            mPlayer.prepare();
            mPlayer.start();
        }catch (IOException e){

            Log.e("failed", "Fails");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }
}