package com.example.nikitran.openweathermap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.nikitran.openweathermap.Data.Forecast;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity: ";
    public static final String APP_ID = "5ad7218f2e11df834b0eaf3a33a39d2a";
    private static Forecast mForecast;
    private static int Longitude;
    private static int Latitude;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, LocationFinder.class);
        startActivityForResult(intent,1);

        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text_view);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Longitude = extras.getInt("Longitude");
            Latitude = extras.getInt("Latitude");
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        callRxRetrofit();
    }


    private void callRxRetrofit() {
        Observable<Forecast> resultObservable = WeatherService.Factory.create(Latitude, Longitude, APP_ID);

        resultObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Forecast>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: Observable is done");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: An error occured.", e);
                    }

                    @Override
                    public void onNext(Forecast curForecast) {
                        mForecast = curForecast;

                        // display to the screen
                        textView.setText(mForecast.toString());
                        Log.d(TAG, mForecast.toString());
                    }
                });
    }
}
