package com.dsman.uaapp.Comunities;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.dsman.uaapp.Comunities.FragmentComunity.ComunityObject;
import com.dsman.uaapp.User;

import java.util.List;

@Dao
public interface ComunityDao {
    @Insert
    void insert(ComunityObject comunityObject);
    @Query("SELECT * from professordata")
    LiveData<List<ComunityObject>> getAllComunity();

}