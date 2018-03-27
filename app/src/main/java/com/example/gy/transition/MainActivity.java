package com.example.gy.transition;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MainActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setWindowAnimations(R.style.WindowAnimationStyle);
        setContentView(R.layout.activity_main);
        context = this;
    }

    public void overridePendingTransition(View view) {
//        startActivity(new Intent(this, TargetOverridePendingTransition.class));
//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
//        Toast.makeText(this, "fuck", Toast.LENGTH_SHORT).show();

       /* AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("fuck")
                .setMessage("message")
                .create();
        alertDialog.show();*/

        Pair<View, String> pare = new Pair<View, String>(context.findViewById(R.id.imageView2), "share");
        Pair<View, String> pare2 = new Pair<View, String>(context.findViewById(R.id.button3), "shareText");

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(context, pare, pare2);

        ActivityCompat.startActivity(context, new Intent(context, TargetOverridePendingTransition.class), options.toBundle());


    }

    public void windowAnimation(View view) {
        startActivity(new Intent(this, TargetOverridePendingTransition.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
