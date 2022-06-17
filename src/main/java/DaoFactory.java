public class DaoFactory {
    private static Ads adsDao;

//    TODO: When you create an instance of MySQLAdsDao, create an instance of your Config class to pass to the MySQLAdsDao constructor
    private static Config config = new Config();

    //TODO: In the DaoFactory class, switch out the ListAdsDao for your MySQLAdsDao
    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDAO(config);
        }
        return adsDao;
    }
}
