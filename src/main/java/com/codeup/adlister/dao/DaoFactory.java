package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Config config = new Config();

//    public static Users users = new Users() {
//
//        @Override
//        public User findByUsername(String username) {
//            return null;
//        }
//
//        @Override
//        public Long insert(User user) {
//            return null;
//        }
//    };

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    // TODO: Add functionality to the DaoFactory class to return an instance of the users data access object.
    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDAO(config);
        }
        return usersDao;
    }


}
