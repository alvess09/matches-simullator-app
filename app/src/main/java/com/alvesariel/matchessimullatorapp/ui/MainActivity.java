package com.alvesariel.matchessimullatorapp.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.alvesariel.matchessimullatorapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupMatchesList();
        setupMatchesRefresh();
        setupFloatingActionButton()
    }



    private void setupMatchesList() {
        //TODO listar as partidas, consumindo a API.
    }

    private void setupFloatingActionButton() {
        //TODO criar evento de click e simulação de partidas
    }

    private void setupMatchesRefresh() {
        //TODO atualizar as partidas na ação de swipe
    }

}
