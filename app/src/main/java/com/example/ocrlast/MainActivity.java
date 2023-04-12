package com.example.ocrlast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int PERMISSION_REQUEST_CODE =200;
    String[] permissions={Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ActivityCompat.requestPermissions(MainActivity.this,permissions,PERMISSION_REQUEST_CODE);
//                getFilePermission();
            }
        });


    }
    public void getFilePermission(){
        try {
            if(Build.VERSION.SDK_INT >= 33){
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                        Manifest.permission.READ_MEDIA_IMAGES}, PERMISSION_REQUEST_CODE);

            }
            ActivityCompat.requestPermissions(MainActivity.this,permissions,PERMISSION_REQUEST_CODE);

        }catch (Exception e){

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISSION_REQUEST_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText( this, "Download Code", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText( this, "No Code", Toast.LENGTH_SHORT).show();

            }
        }
    }
}