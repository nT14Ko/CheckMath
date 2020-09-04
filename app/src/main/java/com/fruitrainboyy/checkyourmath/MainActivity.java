package com.fruitrainboyy.checkyourmath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.onesignal.OneSignal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBarLoading;
    private SharedPreferences preferences;
    private NoBot noBot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressBarLoading = findViewById(R.id.progressBarLoading);

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        setContentView(R.layout.activity_main);
        noBot = new NoBot();
        noBot.noBot(this);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
            if (preferences.getBoolean("isBot", true)) {
                noBot = new NoBot();
                noBot.noBot(this);
            } else if (preferences.getBoolean("isBot", true)) {
                Intent intent = new Intent(this, MainActivity1.class);
                startActivity(intent);
            } else {
                facebook();
                Intent intent = new Intent(this, WebViewActivity.class);
                startActivity(intent);
            }

    }
    private void facebook() {
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.fullyInitialize();
        AppLinkData.fetchDeferredAppLinkData(this,
                new AppLinkData.CompletionHandler() {
                    @Override
                    public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                        if (appLinkData != null) {
                            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                            Uri targetUri = appLinkData.getTargetUri();
                            assert targetUri != null;
                            intent.putExtra("key", targetUri.toString());
                            startActivity(intent);
                            Log.d("Main", "test" + targetUri);
                        }
                    }
                }
        );
    }


}