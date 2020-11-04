package com.example.marvelsvideos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<DataSetList> mPlanetlist = new ArrayList<DataSetList>();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    Context context;
    String link;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<DataSetList> mPlanetlist) {
        this.mInflater = LayoutInflater.from(context);
        this.mPlanetlist = mPlanetlist;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.video_per_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picasso.with(context).load(mPlanetlist.get(position).getImage())
                .into(holder.imageView);

        holder.textView.setText(mPlanetlist.get(position).getText());

        link = mPlanetlist.get(position).getLink();

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mPlanetlist.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.video_view);
            textView = itemView.findViewById(R.id.txt_videotext);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(getAdapterPosition());
        }
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(int position);
    }
}

