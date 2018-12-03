package com.dsman.uaapp.Comunities;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.dsman.uaapp.Comunities.FragmentComunity.ComunityObject;
import com.dsman.uaapp.DatabaseGeneral;
import com.dsman.uaapp.User;

import java.util.List;

public class ComunityRepository {
    private ComunityDao mComunityDao;
    private LiveData<List<ComunityObject>> mAllComunity;

    ComunityRepository(Application application) {
        DatabaseGeneral db = DatabaseGeneral.getDatabase(application);
        mComunityDao = db.comunityDao();
        mAllComunity = mComunityDao.getAllComunity();
    }

    LiveData<List<ComunityObject>> getmAllComunity() {
        return mAllComunity;
    }

    public void insert (ComunityObject word) {
        new insertAsyncTask(mComunityDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<ComunityObject, Void, Void> {

        private ComunityDao mAsyncTaskDao;

        insertAsyncTask(ComunityDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ComunityObject... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}