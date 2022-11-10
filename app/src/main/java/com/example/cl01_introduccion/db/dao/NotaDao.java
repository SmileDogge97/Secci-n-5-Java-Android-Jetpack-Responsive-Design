package com.example.cl01_introduccion.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import androidx.lifecycle.LiveData;


import com.example.cl01_introduccion.db.entity.NotaEntity;

import java.util.List;

@Dao
public interface NotaDao {
    @Insert
    void insert(NotaEntity nota);

    @Update
    void update(NotaEntity nota);

    @Query("DELETE FROM notas")
    void deleteAll();

    @Query("DELETE FROM notas WHERE id = :idNota")
    void deleteById(int idNota);

    @Query("SELECT * FROM notas ORDER BY titulo ASC")
    LiveData<List<NotaEntity>> getAll();

    @Query("SELECT * FROM notas WHERE favorita LIKE 'true'")
    LiveData<List<NotaEntity>> getAllFavoritas();
}
