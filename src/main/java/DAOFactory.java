
public class DAOFactory {
    private static AdsInterface adsDao;

    public static AdsInterface getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }


}