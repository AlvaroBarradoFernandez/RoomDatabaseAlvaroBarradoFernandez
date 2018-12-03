package com.dsman.uaapp.Professor.Professor;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.dsman.uaapp.DatabaseGeneral;
import com.dsman.uaapp.Professor.Professor.ProfessorDao;
import com.dsman.uaapp.User;

import java.util.List;

public class ProfessorRepository {
    private ProfessorDao mProfessorDao;
    private LiveData<List<ProfessorObject>> mAllUsers;

    ProfessorRepository(Application application) {
        DatabaseGeneral db = DatabaseGeneral.getDatabase(application);
        mProfessorDao = db.professorDao();
        mAllUsers = mProfessorDao.getAllProfessors();
    }

    LiveData<List<ProfessorObject>> getmAllUsers() {
        return mAllUsers;
    }

    public void insert (ProfessorObject word) {
        new insertAsyncTask(mProfessorDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<ProfessorObject, Void, Void> {

        private ProfessorDao mAsyncTaskDao;

        insertAsyncTask(ProfessorDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ProfessorObject... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}