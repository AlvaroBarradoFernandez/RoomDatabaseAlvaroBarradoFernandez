package com.dsman.uaapp.Courses.Classes;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ClassDao {
    @Insert
    void insert(ClassObject classObject);
    @Query("SELECT * from classData")
    LiveData<List<ClassObject>> getAllClass();

}
