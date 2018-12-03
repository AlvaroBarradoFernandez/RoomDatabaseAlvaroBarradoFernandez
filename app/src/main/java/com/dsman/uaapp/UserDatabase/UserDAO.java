package com.dsman.uaapp.UserDatabase;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.dsman.uaapp.DatabaseGeneral;
import com.dsman.uaapp.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insert(User user);
    @Query("SELECT * from usertable")
    LiveData<List<User>> getAllUsers();

}
