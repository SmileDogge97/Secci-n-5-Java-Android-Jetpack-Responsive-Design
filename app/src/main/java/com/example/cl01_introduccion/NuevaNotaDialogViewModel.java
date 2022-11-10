package com.example.cl01_introduccion;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.cl01_introduccion.db.entity.NotaEntity;

import java.util.List;

public class NuevaNotaDialogViewModel extends AndroidViewModel {
    private LiveData<List<NotaEntity>> allNotas;
    private NotaRepository notaRepository;

    public NuevaNotaDialogViewModel(Application application){
        super(application);
        notaRepository= new NotaRepository(application);
        allNotas = notaRepository.getAll();
    }

    //El fragment que necesita recibir la nueva lista de datos
    public LiveData<List<NotaEntity>> getAllNotas(){
        return allNotas;
    }

    //El fragment que inserte una nueva nota, deberá comunicarlo a este ViewModel
    public void insertarNota(NotaEntity nuevaNotaEntity){
        notaRepository.insert(nuevaNotaEntity);
    }
}