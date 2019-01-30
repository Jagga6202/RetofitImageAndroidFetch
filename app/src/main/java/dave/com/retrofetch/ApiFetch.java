package dave.com.retrofetch;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiFetch {
    public static final String ROOT_URL = "http://192.168.1.28/MyApi/";

    @GET("Api.php?apicall=getpics")
 Call<MyResponse> getAllpics();

    @Multipart
    @POST("Api.php?apicall=uploadpic")
    Call<UploadResponse> getResult(@Part("tags")RequestBody tags, @Part("pic") RequestBody pic,@Part("name") RequestBody name);
}
