package com.dsman.uaapp.UserDatabase;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.dsman.uaapp.DatabaseGeneral;
import com.dsman.uaapp.User;

import java.util.List;

public class UserRepository {
    private UserDAO mUserDao;
    private LiveData<List<User>> mAllUsers;

    UserRepository(Application application) {
        DatabaseGeneral db = DatabaseGeneral.getDatabase(application);
        mUserDao = db.userDAO();
        mAllUsers = mUserDao.getAllUsers();
    }

    LiveData<List<User>> getmAllUsers() {
        return mAllUsers;
    }

    public void insert (User word) {
        new insertAsyncTask(mUserDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDAO mAsyncTaskDao;

        insertAsyncTask(UserDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}