package com.example.fugla.polbriller.MVP;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public abstract class ActivityBase extends AppCompatActivity {
    abstract protected Presenter presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter().onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter().onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter().onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter().onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter().onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        presenter().onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter().onDestroy();
    }
}