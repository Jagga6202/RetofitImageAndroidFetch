package dave.com.retrofetch;

public class RecModel {


    public RecModel(String image, String tags) {
        this.image = image;
        this.tags = tags;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    String image;
    String tags;

}
