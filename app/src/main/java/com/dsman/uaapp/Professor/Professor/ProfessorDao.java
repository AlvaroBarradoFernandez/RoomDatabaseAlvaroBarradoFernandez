package com.dsman.uaapp.Professor.Professor;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.dsman.uaapp.User;

import java.util.List;
@Dao
public interface ProfessorDao {
    @Insert
    void insert(ProfessorObject professorObject);
    @Query("SELECT * from professordata")
    LiveData<List<ProfessorObject>> getAllProfessors();

}
