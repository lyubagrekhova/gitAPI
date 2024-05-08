package com.example.kart;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PolAdapter extends RecyclerView.Adapter<PolAdapter.ViewHolder> {
    private final static String PHOTO_URL = "https://avatars.githubusercontent.com/u/";
    private final static String BIO_URL = "https://api.github.com/users/";
    private List<Polzovateli> mFlowers;
    private Context mContext;

    PolAdapter(List<Polzovateli> flowers) {
        this.mFlowers = flowers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Polzovateli polzovateli = mFlowers.get(position);
        holder.nameTextView.setText(polzovateli.getLogin());
        holder.opisTextView.setText(BIO_URL + polzovateli.getLogin() + "/subscriptions");

        Picasso.with(mContext)
                .load( PHOTO_URL + polzovateli.getId())
                .resize(200, 200)
                .into(holder.flowerImageView);
    }

    @Override
    public int getItemCount() {
        if (mFlowers == null) {
            return 0;
        }
        return mFlowers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView opisTextView;
        ImageView flowerImageView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            opisTextView = (TextView) itemView.findViewById(R.id.opisTextView);
            flowerImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
        }
    }
}
