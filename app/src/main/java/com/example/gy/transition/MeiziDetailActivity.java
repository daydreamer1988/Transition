package com.example.gy.transition;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MeiziDetailActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getWindow().setEnterTransition(new Slide(Gravity.BOTTOM));//B
//        getWindow().setReturnTransition(new Slide(Gravity.BOTTOM));//B
//        getWindow().setExitTransition(new Slide(Gravity.LEFT));//A
//        getWindow().setReenterTransition(new Slide(Gravity.LEFT));//A
//        Fade transition = new Fade();
//        transition.excludeTarget(android.R.id.statusBarBackground, true);
//        getWindow().setEnterTransition(transition);//B
//        getWindow().setReturnTransition(transition);//B

        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
        getWindow().setEnterTransition(transition);

        setContentView(R.layout.activity_meizi_detail);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        Picasso.with(this).load(getIntent().getStringExtra("url")).into(imageView);
        Picasso.with(this).load(getIntent().getStringExtra("url")).into(imageView2);
        Picasso.with(this).load(getIntent().getStringExtra("url")).into(imageView3);
        Picasso.with(this).load(getIntent().getStringExtra("url")).into(imageView4);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityCompat.finishAfterTransition(this);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void start(MeiziStaggeredActivity context, String url, View view) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(context);
        Intent intent = new Intent(context, MeiziDetailActivity.class);
        intent.putExtra("url", url);
//        ActivityCompat.startActivity(context, intent, options.toBundle());
        context.startActivity(intent, options.toBundle());
//        context.startActivity(intent);

    }
}
