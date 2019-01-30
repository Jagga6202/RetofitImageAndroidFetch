package dave.com.retrofetch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.MyViewHolder> {

    Context context;
   List<RecModel> arrayList;

    public RecAdapter(Context context, List<RecModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.recitems,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.imagetag.setText(arrayList.get(i).getTags());
        Glide.with(context)
                .load(arrayList.get(i).getImage())
                .apply(new RequestOptions().override(300,300))
                .into(myViewHolder.imagepath);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
ImageView imagepath;
TextView imagetag;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imagepath=(ImageView)itemView.findViewById(R.id.imagepath);
            imagetag=(TextView) itemView.findViewById(R.id.imagetag);
        }
    }
}
