package com.dsman.uaapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.dsman.uaapp.Comunities.ComunityDao;
import com.dsman.uaapp.Courses.Classes.ClassDao;
import com.dsman.uaapp.Courses.Classes.ClassObject;
import com.dsman.uaapp.Professor.Professor.ProfessorDao;
import com.dsman.uaapp.Professor.Professor.ProfessorObject;
import com.dsman.uaapp.UserDatabase.UserDAO;

@Database(entities = {User.class, ProfessorObject.class, ClassObject.class}, version = 1, exportSchema = false)

public abstract class DatabaseGeneral extends RoomDatabase {

        public abstract UserDAO userDAO();
        public abstract ProfessorDao professorDao();
        public abstract ClassDao classDao();
        public abstract ComunityDao comunityDao();
        public static DatabaseGeneral INSTANCE;

        public static DatabaseGeneral getDatabase(final Context context) {
            if (INSTANCE == null) {
                synchronized (DatabaseGeneral.class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                DatabaseGeneral.class, "databasee")
                                // Wipes and rebuilds instead of migrating
                                // if no Migration object.
                                // Migration is not part of this practical.
                                .fallbackToDestructiveMigration()
                                .build();
                    }
                }
            }
            return INSTANCE;
        }
    }