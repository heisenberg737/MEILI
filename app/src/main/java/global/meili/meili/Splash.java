package global.meili.meili;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
     private int SplashTime=3000;
     ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView =  findViewById(R.id.imageView);
        final ScaleAnimation scaleAnimation=new ScaleAnimation(1,2,1,2, Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash.this,Intro.class);
                startActivity(intent);
                finish();
            }
        },SplashTime);
        imageView.startAnimation(scaleAnimation);


    }
}
