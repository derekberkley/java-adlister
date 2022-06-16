import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements AdsInterface {
    private List<Ad> allAds;

    @Override
    public List<Ad> allAds() {
        if (allAds == null) {
            allAds = dummyContent();
        }
        return allAds;
    }

    public void insertAd(Ad newAd) {
        this.allAds.add(newAd);
    }

    private List<Ad> dummyContent() {
        List<Ad> allAds = new ArrayList<>();
        allAds.add(
                new Ad(1, 100,
                        "couch for sale",
                        "Arrived brand new with a bent arm, company sent us another. DISCOUNTED!"
                ));
        allAds.add(
                new Ad(2,200,
                        "Apple iPhone",
                        "Selling this trash because Samsung Galaxy is better!"
                ));
        allAds.add(new Ad(
                3,
                300,
                "Babysitting Service",
                "Enjoy a night out, while an experienced and certified babysitting cares for your precious kids."
        ));
        allAds.add(new Ad(
                4,
                400,
                "Lawn Care Service",
                "Have lawn mower, will travel. Love grass, competitive prices!"
        ));
        return allAds;
    }

//    public static void main(String[] args) {
//
////        Ad testAd = new Ad(8L, 600L, "test ad title", "test ad description");
////        AdsInterface adsDAO = DAOFactory.getAdsDao();
////        List<Ad> allAds = adsDAO.allAds();
////        adsDAO.insertAd(testAd);
////        for(Ad ad: allAds) {
////            System.out.println(ad.getAdTitle() + " " + ad.getAdDescription());
//        }
//    }

} 