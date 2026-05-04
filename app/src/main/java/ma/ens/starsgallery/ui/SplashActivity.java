package ma.ens.starsgallery.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ma.ens.starsgallery.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView splashTitle;
    private TextView splashSubtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        logo = findViewById(R.id.logo);
        splashTitle = findViewById(R.id.splashTitle);
        splashSubtitle = findViewById(R.id.splashSubtitle);

        logo.setScaleX(0.2f);
        logo.setScaleY(0.2f);
        logo.setAlpha(0f);

        splashTitle.setAlpha(0f);
        splashSubtitle.setAlpha(0f);

        logo.animate()
                .alpha(1f)
                .scaleX(1.15f)
                .scaleY(1.15f)
                .rotation(360f)
                .setDuration(1800)
                .withEndAction(() -> logo.animate()
                        .scaleX(0.95f)
                        .scaleY(0.95f)
                        .translationY(20f)
                        .setDuration(600)
                        .start())
                .start();

        splashTitle.animate()
                .alpha(1f)
                .translationY(-8f)
                .setStartDelay(800)
                .setDuration(900)
                .start();

        splashSubtitle.animate()
                .alpha(1f)
                .translationY(-6f)
                .setStartDelay(1200)
                .setDuration(900)
                .start();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, ListActivity.class);
            startActivity(intent);
            finish();
        }, 3300);
    }
}