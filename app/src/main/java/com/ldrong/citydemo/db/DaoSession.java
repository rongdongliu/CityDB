package com.ldrong.citydemo.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.ldrong.citydemo.db.City;
import com.ldrong.citydemo.db.User;

import com.ldrong.citydemo.db.CityDao;
import com.ldrong.citydemo.db.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig cityDaoConfig;
    private final DaoConfig userDaoConfig;

    private final CityDao cityDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        cityDaoConfig = daoConfigMap.get(CityDao.class).clone();
        cityDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        cityDao = new CityDao(cityDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(City.class, cityDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        cityDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
