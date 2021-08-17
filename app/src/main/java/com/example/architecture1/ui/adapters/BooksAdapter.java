package com.example.architecture1.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.architecture1.Click;
import com.example.architecture1.R;
import com.example.architecture1.model.BooksModel;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    ArrayList<BooksModel> list = new ArrayList<>();
    Click onClick;


    public void getList(ArrayList<BooksModel> models){
        this.list = models;
        notifyDataSetChanged();
    }
     public void setClick (Click click) {
        this.onClick =  click;
     }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_item);
            imageView = itemView.findViewById(R.id.image_item);
        }

        public void onBind(BooksModel booksModel) {
            title.setText(booksModel.getTitle());
            imageView.setImageResource(booksModel.getImage());
             itemView.setOnClickListener(v -> {
                 onClick.onItemClick(getAdapterPosition(), booksModel, v);
             });


        }
    }
}
