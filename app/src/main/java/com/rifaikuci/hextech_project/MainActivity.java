package com.rifaikuci.hextech_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.rifaikuci.hextech_project.API.ApiClient;
import com.rifaikuci.hextech_project.API.ApiInterface;
import com.rifaikuci.hextech_project.datas.Pins;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Switch s1, s2, s3, s4;
    int periodic = 16000; // geri sayim için süre burada belirlenir burada değiştirilir.
    CountDownTimer countDownTimer;
    Call<List<Pins>> call;
    TextView countTimerTxt;

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // değişkenler fonksiyonlarda toplandı.
        variableDesc();

        //
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        call = apiInterface.getValues();

        // verileri burada çağırdık
        call.enqueue(new Callback<List<Pins>>() {
            @Override
            public void onResponse(Call<List<Pins>> call, Response<List<Pins>> response) {
                responseFunction(response); // verilere göre switchlerin açık kapalı olmasına bakılır
                //burada iki kere çağrıldı bir uygulamanın ilk açıldığı zaman diğeri de bir sonraki aşamada
            }

            @Override
            public void onFailure(Call<List<Pins>> call, Throwable t) {
                //eğer verile alınamazsa
                Toast.makeText(getApplicationContext(), "İnternet bağlantısını kontrol ediniz.", Toast.LENGTH_SHORT).show();
            }
        });

        countDownTimer = new CountDownTimer(periodic, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                countTimerTxt.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                countDownTimer.start();
                call.clone().enqueue(new Callback<List<Pins>>() {
                    @Override
                    public void onResponse(Call<List<Pins>> call, Response<List<Pins>> response) {

                        responseFunction(response);
                    }

                    @Override
                    public void onFailure(Call<List<Pins>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "İnternet bağlantısını kontrol ediniz.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }.start();


    }

    private void responseFunction(Response<List<Pins>> response) {
        List<Pins> pins = response.body();
        // gelen veriler pins listesine atanır. ve kontrollere göre işlemler yapılır.
        for (Pins pin : pins) {
            if (pin.getP1() == 1) {
                s1.setChecked(true);
            } else {
                s1.setChecked(false);

            }

            if (pin.getP2() == 1) {
                s2.setChecked(true);
            } else {
                s2.setChecked(false);

            }

            if (pin.getP3() == 1) {
                s3.setChecked(true);
            } else {
                s3.setChecked(false);

            }

            if (pin.getP4() == 1) {
                s4.setChecked(true);
            } else {
                s4.setChecked(false);

            }


        }
    }

    // değişkenler tanımlandı
    private void variableDesc() {

        s1 = (Switch) findViewById(R.id.switch1);
        s2 = (Switch) findViewById(R.id.switch2);
        s3 = (Switch) findViewById(R.id.switch3);
        s4 = (Switch) findViewById(R.id.switch4);

        countTimerTxt = (TextView) findViewById(R.id.countTimerTxt);
    }
}