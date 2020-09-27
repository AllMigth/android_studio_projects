package com.example.cf_rewardedvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {
    private RewardedVideoAd rewardedVideoAd;
    private TextView txtCoins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCoins = (TextView)findViewById(R.id.txtCoins);
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.loadAd("ca-app-pub-2074653592569906/3259459988", new AdRequest.Builder().build());
        //saber si el usuario termino de ver el video
        rewardedVideoAd.setRewardedVideoAdListener(this);
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Toast.makeText(getApplicationContext(),"onRewardedVideoAdLoaded",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Toast.makeText(getApplicationContext(),"onRewardedVideoAdOpened",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewardedVideoStarted() {
        Toast.makeText(getApplicationContext(),"onRewardedVideoStarted",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onRewardedVideoAdClosed() {
        Toast.makeText(getApplicationContext(),"onRewardedVideoAdClosed",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        txtCoins.setText("Bonificacion  "+rewardItem.getType()+ "Total "+rewardItem.getAmount());
        Toast.makeText(getApplicationContext(),"onRewarded",Toast.LENGTH_LONG).show();
        //EN ESTE METODO RECIBIMOS LA RECOMPENSA

        //agregamos monedas, el getAmount lo definimos en el admob al crear el bloque de anuncio
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

        Toast.makeText(getApplicationContext(),"onRewardedVideoAdLeftApplication",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        Toast.makeText(getApplicationContext(),"onRewardedVideoAdFailedToLoad",Toast.LENGTH_LONG).show();
    }

    public void showVideo(View view) {
        if (rewardedVideoAd.isLoaded()){
            rewardedVideoAd.show();
        }
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        rewardedVideoAd.pause(getApplicationContext());
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        rewardedVideoAd.destroy(getApplicationContext());
        super.onDestroy();
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.
     */
    @Override
    protected void onResume() {
        rewardedVideoAd.resume(getApplicationContext());
        super.onResume();
    }
}
