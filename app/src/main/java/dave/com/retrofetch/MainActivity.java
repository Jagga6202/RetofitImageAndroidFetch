package dave.com.retrofetch;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecAdapter adapter;
    RecyclerView rec;
       String imagepath,imagetag;
    ProgressDialog progressDialog;
    List<RecModel> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec=(RecyclerView)findViewById(R.id.rec);
        loadiamge();
    }

    public void loadiamge(){
        progressDialog = ProgressDialog.show(MainActivity.this,"Loading Data",null,true,true);
        //To print Log as url from retrofit
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiFetch.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        ApiFetch apiFetch=retrofit.create(ApiFetch.class);
        Log.e("Url hit",""+apiFetch.getAllpics().request().url().toString());
        Call<MyResponse> call=apiFetch.getAllpics();
        call.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                progressDialog.dismiss();
                MyResponse myResponse=response.body();
                list=myResponse.getImages();
                for(RecModel re:list){
                    imagepath=re.getImage();
                    imagetag=re.getTags();
                    Log.e("Image details","\nimageurl:-"+imagepath+"\nimagetag:-"+imagetag);
                }
                adapter=new RecAdapter(MainActivity.this,list);
                rec.setAdapter(adapter);
                rec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rec.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));

            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                Log.e("Response error",""+t.getMessage());
                progressDialog.dismiss();
            }
        });



    }
}
