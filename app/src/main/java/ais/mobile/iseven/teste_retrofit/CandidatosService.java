package ais.mobile.iseven.teste_retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rodrigo on 30/08/2016.
 */
public interface CandidatosService {

    @GET("get/candidato")
    Call<List<CandidatosModel>> getCandidato();

    }

