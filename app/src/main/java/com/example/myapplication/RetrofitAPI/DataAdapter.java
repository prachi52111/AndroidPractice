package com.example.myapplication.RetrofitAPI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.viewHolder> {

    List<DataModel> arrayList;
    Context context;


    public DataAdapter(List<DataModel> arrayList, Context
                        context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_list_api,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        DataModel model = arrayList.get(position);
        holder.name.setText(model.getName());
        holder.realname.setText(model.getRealname());
        holder.bio.setText(model.getBio());
        holder.createdby.setText(model.getCreatedby());
        holder.firstappear.setText(model.getFirstappearance());
        holder.pubisher.setText(model.getPublisher());
        holder.team.setText(model.getTeam());
        Glide.with(context).load(model.getImageurl()).into(holder.circleImageView);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView name,realname,team,bio,pubisher,firstappear,createdby;
        CircleImageView circleImageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            realname = itemView.findViewById(R.id.tv_realname);
            team = itemView.findViewById(R.id.tv_team);
            bio = itemView.findViewById(R.id.tv_bio);
            pubisher = itemView.findViewById(R.id.tv_publisher);
            firstappear = itemView.findViewById(R.id.tv_firstappear);
            createdby = itemView.findViewById(R.id.tv_createdby);
            circleImageView = itemView.findViewById(R.id.circleImage);





        }
    }
}
