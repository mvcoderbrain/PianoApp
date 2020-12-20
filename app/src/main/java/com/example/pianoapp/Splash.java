package com.example.pianoapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class Splash extends AppCompatActivity {


    private final static int EXIT_CODE = 100;


    ImageView imageSplash;
    TextView textSplash;

    private static final int PERMISSION_CONSTANT = 100;
    private static final int REQUEST_PERMISSION_SETTING = 101;


    String[] permissionRequired = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO
    };

    private SharedPreferences permissionStatus;
    private boolean sentToSettings = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        imageSplash = findViewById(R.id.splashImage);
        textSplash = findViewById(R.id.splashText);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition);
        textSplash.startAnimation(animation);
        imageSplash.startAnimation(animation);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    permissionStatus = getSharedPreferences("permissionStaus", MODE_PRIVATE);

                    if (ActivityCompat.checkSelfPermission(Splash.this, permissionRequired[0]) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(Splash.this, permissionRequired[1]) != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(Splash.this, permissionRequired[0]) || ActivityCompat.shouldShowRequestPermissionRationale(Splash.this, permissionRequired[1])) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Splash.this);
                            builder.setTitle("Need Multiple Permission");
                            builder.setMessage("This app needs Storage and Record Audio Permission");
                            builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ActivityCompat.requestPermissions(Splash.this, permissionRequired, PERMISSION_CONSTANT);
                                }
                            });
                            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            builder.show();
                        } else if (permissionStatus.getBoolean(permissionRequired[0], false)) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Splash.this);
                            builder.setTitle("Need Multiple Permission");
                            builder.setMessage("This app needs Storage and Record Audio Permission");
                            builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    sentToSettings = true;
                                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                                    intent.setData(uri);
                                    startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
                                }
                            });
                            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            builder.show();
                        } else {
                            ActivityCompat.requestPermissions(Splash.this, permissionRequired, PERMISSION_CONSTANT);
                        }
                    } else {
                        proceedAfterPermission();
                    }
                }
            }
        });
        thread.start();


    }

    private void proceedAfterPermission() {
//        Toast.makeText(this, "Got All Permission", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);

        startActivityForResult(new Intent(Splash.this,MainActivity.class), EXIT_CODE);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_CONSTANT){
            boolean allGranted = true;
            for (int i = 0; i<grantResults.length; i++){
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    allGranted = true;
                }
                else {
                    allGranted = false;
                }
            }
            if (allGranted){
                proceedAfterPermission();
            }
            else if (ActivityCompat.shouldShowRequestPermissionRationale(Splash.this, permissionRequired[0]) || ActivityCompat.shouldShowRequestPermissionRationale(Splash.this, permissionRequired[1])){
                AlertDialog.Builder builder = new AlertDialog.Builder(Splash.this);
                builder.setTitle("Need Multiple Permission");
                builder.setMessage("This app needs Storage and Record Audio Permission");
                builder.setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(Splash.this, permissionRequired, PERMISSION_CONSTANT);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
            else {
                Toast.makeText(this, "Unable to get Permission", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "App will not work properly", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_PERMISSION_SETTING){
            if (ActivityCompat.checkSelfPermission(Splash.this, permissionRequired[0]) == PackageManager.PERMISSION_GRANTED){
                proceedAfterPermission();
            }
        }
        if(requestCode == EXIT_CODE){
            if (requestCode == RESULT_OK){
                if (data.getBooleanExtra("EXIT", true));
                finish();
            }
        }
    }
}