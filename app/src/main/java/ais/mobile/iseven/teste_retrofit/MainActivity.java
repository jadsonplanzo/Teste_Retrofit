package ais.mobile.iseven.teste_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL= "http://192.168.56.1:8080/EleicoesWS/webresources/generic/Candidato";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson g = new GsonBuilder().registerTypeAdapter(CandidatosModel.class, new CandidatosDeck()).create();

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create(g))
                .build();

        CandidatosService service = retrofit.create(CandidatosService.class);
        Call<List<CandidatosModel>> candidatos = service.getCandidato();
        candidatos.enqueue(new Callback<List<CandidatosModel>>() {
            @Override
            public void onResponse(Call<List<CandidatosModel>> call, Response<List<CandidatosModel>> response) {
                if(response.isSuccessful()){
                    List<CandidatosModel> users = response.body();
                    for(CandidatosModel c:users){
                        Log.i("id", c.getIdCandidato()+"nome-------------------------------" +c.getNome() +"Numero"  +c.getNumero()+"Votos"+c.getVotos());



                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Erro" +response.code(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<CandidatosModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro" +t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }
}
