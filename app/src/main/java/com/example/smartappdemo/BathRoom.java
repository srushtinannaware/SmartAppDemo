package com.example.smartappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BathRoom extends AppCompatActivity {

    boolean offstatus,onstatus;
    int brightstatus1,brightstatus2,brightstatus3;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bath_room);

        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        SeekBar seekBar,seekBar1,seekBar2;
        LinearLayout linearLayout, linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5;

        Switch aSwitch,bSwitch,cSwitch,dSwitch,eSwitch,fSwitch;


        ImageView imageView,imageView1,imageView2,imageView3,imageView4,imageView5;

        TextView textView,textView1,textView2,textView3,textView4,textView5,textView6,textView7;

        seekBar = findViewById(R.id.seekbright1);
        seekBar1 = findViewById(R.id.seekbright2);
        seekBar2 = findViewById(R.id.seekbright3);

        imageView = findViewById(R.id.img1);
        imageView1 = findViewById(R.id.img2);
        imageView2 = findViewById(R.id.img3);
        imageView3 = findViewById(R.id.img4);
        imageView4 = findViewById(R.id.img5);
        imageView5 = findViewById(R.id.img6);

        aSwitch = findViewById(R.id.switch1);
        bSwitch = findViewById(R.id.switch2);
        cSwitch = findViewById(R.id.switch3);
        dSwitch = findViewById(R.id.switch4);
        eSwitch = findViewById(R.id.switch5);
        fSwitch = findViewById(R.id.switch6);


        linearLayout = findViewById(R.id.linear1);
        linearLayout1 = findViewById(R.id.linear2);
        linearLayout2 = findViewById(R.id.linear3);
        linearLayout3 = findViewById(R.id.linear4);
        linearLayout4 = findViewById(R.id.linear5);
        linearLayout5 = findViewById(R.id.linear6);

        textView = findViewById(R.id.title1);
        textView1 = findViewById(R.id.title2);
        textView2 = findViewById(R.id.title3);
        textView3 = findViewById(R.id.title4);
        textView4 = findViewById(R.id.title5);
        textView5 = findViewById(R.id.title6);
        textView6 = findViewById(R.id.smalltitle1);
        textView7 = findViewById(R.id.smalltitle2);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://forapi-dc639-default-rtdb.firebaseio.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonInterface jsonInterface = retrofit.create(JsonInterface.class);

        Call<DataModel> call = jsonInterface.getData();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                if(response.code() != 200){

                }

                if(response.body().getLightoff() == 1){
                    offstatus = true;
                }
                else {
                    onstatus = false;
                }

                brightstatus1 = response.body().getBrightness1();
                brightstatus2 = response.body().getBrightness2();
                brightstatus3 = response.body().getBrightness3();

                seekBar.setProgress(brightstatus1);
                seekBar1.setProgress(brightstatus2);
                seekBar2.setProgress(brightstatus3);

            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });

        if(offstatus){
            bSwitch.setChecked(false);

        }
        else {
            bSwitch.setChecked(true);
            linearLayout1.setBackground(getDrawable(R.drawable.bg));
            imageView1.setColorFilter(R.color.black);
            textView1.setTextColor(getResources().getColor(R.color.black));
            textView7.setTextColor(getResources().getColor(R.color.black));
        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){

                    linearLayout.setBackground(getDrawable(R.drawable.bg));
                    imageView.setColorFilter(R.color.black);
                    textView.setTextColor(getResources().getColor(R.color.black));
                    textView6.setTextColor(getResources().getColor(R.color.black));

                }
                else {
                    linearLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    imageView.setColorFilter(getResources().getColor(R.color.bg));
                    textView.setTextColor(getResources().getColor(R.color.bg));
                    textView6.setTextColor(getResources().getColor(R.color.bg));
                }
            }
        });

        bSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    linearLayout1.setBackground(getDrawable(R.drawable.bg));
                    imageView1.setColorFilter(R.color.black);
                    textView1.setTextColor(getResources().getColor(R.color.black));
                    textView7.setTextColor(getResources().getColor(R.color.black));
                }
                else {
                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.white));
                    imageView1.setColorFilter(getResources().getColor(R.color.bg));
                    textView1.setTextColor(getResources().getColor(R.color.bg));
                    textView7.setTextColor(getResources().getColor(R.color.bg));
                }
            }
        });

        cSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    linearLayout2.setBackground(getDrawable(R.drawable.bg));
                    imageView2.setColorFilter(R.color.black);
                    textView2.setTextColor(getResources().getColor(R.color.black));
                }
                else {
                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.white));
                    imageView2.setColorFilter(getResources().getColor(R.color.bg));
                    textView2.setTextColor(getResources().getColor(R.color.bg));
                }
            }
        });

        dSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    linearLayout3.setBackground(getDrawable(R.drawable.bg));
                    imageView3.setColorFilter(R.color.black);
                    textView3.setTextColor(getResources().getColor(R.color.black));
                }
                else {
                    linearLayout3.setBackgroundColor(getResources().getColor(R.color.white));
                    imageView3.setColorFilter(getResources().getColor(R.color.bg));
                    textView3.setTextColor(getResources().getColor(R.color.bg));
                }
            }
        });

        eSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    linearLayout4.setBackground(getDrawable(R.drawable.bg));
                    imageView4.setColorFilter(R.color.black);
                    textView4.setTextColor(getResources().getColor(R.color.black));
                }
                else {
                    linearLayout4.setBackgroundColor(getResources().getColor(R.color.white));
                    imageView4.setColorFilter(getResources().getColor(R.color.bg));
                    textView4.setTextColor(getResources().getColor(R.color.bg));
                }
            }
        });

        fSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    linearLayout5.setBackground(getDrawable(R.drawable.bg));
                    imageView5.setColorFilter(R.color.black);
                    textView5.setTextColor(getResources().getColor(R.color.black));
                }
                else {
                    linearLayout5.setBackgroundColor(getResources().getColor(R.color.white));
                    imageView5.setColorFilter(getResources().getColor(R.color.bg));
                    textView5.setTextColor(getResources().getColor(R.color.bg));
                }
            }
        });



    }
}