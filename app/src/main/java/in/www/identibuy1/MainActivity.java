package in.www.identibuy1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView bounceBallImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,
                        Login.class);
                startActivity(i);


                //the current activity will get finished.
            }
        }, 4000);
        bounceBallImage = (ImageView) findViewById(R.id.bounceBallImage);
        bounceBallImage.clearAnimation();
        bounceBallImage.setVisibility(View.INVISIBLE);
        TranslateAnimation transAnim = new TranslateAnimation(0, 0, 0,
                (float) (getDisplayHeight()/2.5));
        transAnim.setStartOffset(500);
        transAnim.setDuration(2000);
        transAnim.setFillAfter(true);
        transAnim.setInterpolator(new BounceInterpolator());
        transAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                bounceBallImage.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                /*bounceBallImage.clearAnimation();
                final int left = bounceBallImage.getLeft();
                final int top = bounceBallImage.getTop();
                final int right = bounceBallImage.getRight();
                final int bottom = bounceBallImage.getBottom();
                bounceBallImage.layout(left, top, right, bottom);*/


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        bounceBallImage.startAnimation(transAnim);
    }

    private float getDisplayHeight() {
        return this.getResources().getDisplayMetrics().heightPixels;

    }



}

