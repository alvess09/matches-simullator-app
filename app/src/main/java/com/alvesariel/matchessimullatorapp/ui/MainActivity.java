package com.alvesariel.matchessimullatorapp.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alvesariel.matchessimullatorapp.R;
import com.alvesariel.matchessimullatorapp.data.MatchesApi;
import com.alvesariel.matchessimullatorapp.databinding.ActivityMainBinding;
import com.alvesariel.matchessimullatorapp.domain.Match;
import com.alvesariel.matchessimullatorapp.ui.adapter.MatchesAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MatchesApi matchesApi;
    private RecyclerView.Adapter matchesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //métodos do app
        setupHttpClient();
        setupMatchesList();
        setupMatchesRefresh();
        setupFloatingActionButton();

    }

    //criando a instancia do Retrofit para pegar a URL base da API
    private void setupHttpClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://alvess09.github.io/matches-simulator-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        matchesApi = retrofit.create(MatchesApi.class);
    }


    private void setupMatchesList() {
        binding.rvMatches.setHasFixedSize(true);
        binding.rvMatches.setLayoutManager(new LinearLayoutManager(this));

       matchesApi.getMatches().enqueue(new Callback<List<Match>>() {

           @Override
           public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
               if(response.isSuccessful()){
                   //recuperando as informaçõe em lista
                   List<Match> matches = response.body();
                   matchesAdapter = new MatchesAdapter(matches);
                   binding.rvMatches.setAdapter(matchesAdapter);
               }else{
                   showErrorMessage();
               }
           }

           @Override
           public void onFailure(Call<List<Match>> call, Throwable t) {
                showErrorMessage();
           }
       });
    }

    private void setupFloatingActionButton() {
        //TODO criar evento de click e simulação de partidas
    }

    private void setupMatchesRefresh() {
        //TODO atualizar as partidas na ação de swipe
    }

    private void showErrorMessage() {
        Snackbar.make(binding.fabSimulate, R.string.error_api,Snackbar.LENGTH_LONG).show();
    }

}
