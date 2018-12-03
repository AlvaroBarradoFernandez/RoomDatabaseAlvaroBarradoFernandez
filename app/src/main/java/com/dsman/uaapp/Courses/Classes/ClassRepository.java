package com.dsman.uaapp.Courses.Classes;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.dsman.uaapp.DatabaseGeneral;

import java.util.List;

public class ClassRepository {
    private ClassDao mClassDao;
    private LiveData<List<ClassObject>> mAllUsers;

    ClassRepository(Application application) {
        DatabaseGeneral db = DatabaseGeneral.getDatabase(application);
        mClassDao = db.classDao();
        mAllUsers = mClassDao.getAllClass();
    }

    LiveData<List<ClassObject>> getmAllClass() {
        return mAllUsers;
    }

    public void insert (ClassObject word) {
        new insertAsyncTask(mClassDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<ClassObject, Void, Void> {

        private ClassDao mAsyncTaskDao;

        insertAsyncTask(ClassDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ClassObject... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}