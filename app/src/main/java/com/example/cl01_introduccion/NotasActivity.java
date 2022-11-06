package com.example.cl01_introduccion;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public class NotasActivity extends AppCompatActivity implements NotasInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_activity_notas);
        NavController navController = navHostFragment.getNavController();

    }

    @Override
    public void editNotaClick(Nota nota) {

    }

    @Override
    public void eliminaNotaClick(Nota nota) {

    }

    @Override
    public void favoritaNotaClick(Nota nota) {

    }
}