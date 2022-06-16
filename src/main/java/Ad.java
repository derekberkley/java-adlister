public class Ad {
    private long id;
    private long userId;
    private String adTitle;
    private String adDescription;

    public Ad() {};

    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.adTitle = title;
        this.adDescription = description;
    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public long getUserId() {return userId;}

    public void setUserId(long userId) {this.userId = userId;}

    public String getAdTitle() {return adTitle;}

    public void setAdTitle(String adTitle) {this.adTitle = adTitle;}

    public String getAdDescription() {return adDescription;}

    public void setAdDescription(String adDescription) {this.adDescription = adDescription;}


}