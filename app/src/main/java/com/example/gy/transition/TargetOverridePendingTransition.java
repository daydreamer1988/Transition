package com.example.gy.transition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TargetOverridePendingTransition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setWindowAnimations(R.style.WindowAnimationStyle);

        setContentView(R.layout.activity_target_override_pending_transition);
    }

    public void back(View view) {
        finish();

//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

}
