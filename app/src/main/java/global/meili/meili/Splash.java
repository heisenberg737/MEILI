package global.meili.meili;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Splash extends AppCompatActivity {
     private int SplashTime=2500;
     ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView =  findViewById(R.id.imageView);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.splashLAyout);
        AnimationSet animset = new AnimationSet(true);
        animset.setDuration(2000);
        animset.setFillAfter(true);
        animset.setInterpolator(new OvershootInterpolator());
        DecelerateInterpolator di = new DecelerateInterpolator();
        animset.setInterpolator(di);
        OvershootInterpolator oi = new OvershootInterpolator(2.5f);
        animset.setInterpolator(oi);
        ScaleAnimation scaleAnimation=new ScaleAnimation(0.5f,1.2f,0.5f,1.2f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animset.addAnimation(scaleAnimation);
        int start=getWindowManager().getDefaultDisplay().getHeight();
        Animation anim = new TranslateAnimation(0,0,100,-300);
        animset.addAnimation(anim);
        imageView.startAnimation(animset);
        int t=0;
        for (int i=0;i<16;i++)
        {
            if(i<8)
                t+=200-20*i;
            else
                t+=50;
            final int c =i;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(c%2==0)
                        relativeLayout.setBackgroundColor(Color.parseColor("#41c300"));
                    else
                        relativeLayout.setBackgroundColor(Color.WHITE);
                }
            },t);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash.this,Intro.class);
                startActivity(intent);
                finish();
            }
        },SplashTime);


    }
}
