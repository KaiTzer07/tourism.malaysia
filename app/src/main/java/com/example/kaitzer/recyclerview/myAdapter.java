package com.example.kaitzer.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by KaiTzer on 14-May-16.
 */
public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {

    private ItemData[] itemsData;
    private Context mContext;

    public myAdapter(ItemData[] itemsData, Context contexts)
    {
        this.itemsData = itemsData;
        this.mContext = contexts;
    }



    @Override
    public myAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_layout, null);

        //create viewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        Log.e("OnCreateviewHolder", "viewHolder created");
        return viewHolder;
    }

    @Override
    //replace the contents of a view (ViewHolder) (invoke by the layout manager)
    public void onBindViewHolder(myAdapter.ViewHolder holder, int position) {
        //get data from your itemsData at this position
        //replace the contents of the ciew with that itemsData
        holder.txtViewTitle.setText(itemsData[position].getTitle());
        holder.imgViewIcon.setImageResource(itemsData[position].getImageURL());


        final String value = itemsData[position].getTitle();
        final String value2 = String.valueOf(itemsData[position].getImageURL());

        final String getData = itemsData[position].getTitle();
        Log.e("OnBindViewHolder", "Data set");

        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick)
                {
                    Toast.makeText(mContext, "Long Clicked | Position: " + position+"  " + value+"  \n" +
                            "ID: " + value2+"  " , Toast.LENGTH_SHORT).show();

                }else
                {
                    Toast.makeText(mContext, "Clicked | Position: " + position+"  " + value +"  \nID: " + value2+"  " , Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsData.length;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener
    {
        TextView txtViewTitle;
        ImageView imgViewIcon;
        private ItemClickListener itemClickListener;

        public ViewHolder(View itemLayoutView)
        {
            super(itemLayoutView);
            //find the view
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            Log.e ("ViewHolder", "Constructor Method");
        }


        public void setClickListener (ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }
        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getPosition(), true);
            return true;
        }

    }

}
