package dave.com.retrofetch;

import java.util.List;

public class MyResponse {
String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<RecModel> getImages() {
        return images;
    }

    public void setImages(List<RecModel> images) {
        this.images = images;
    }

    List<RecModel> images;


    public MyResponse(String error, List<RecModel> images) {
        this.error = error;
        this.images = images;
    }
}

