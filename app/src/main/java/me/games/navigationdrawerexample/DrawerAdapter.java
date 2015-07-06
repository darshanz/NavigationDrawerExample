package me.games.navigationdrawerexample;

import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by darshanz on 7/6/15.
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerViewHolder>{

    private ArrayList<DrawerItem> drawerMenuList;


    public DrawerAdapter(ArrayList<DrawerItem> drawerMenuList) {
        this.drawerMenuList = drawerMenuList;
    }


    @Override
    public DrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);

        return new DrawerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DrawerViewHolder holder, int position) {
        holder.title.setText(drawerMenuList.get(position).getTitle());
        holder.icon.setImageResource(drawerMenuList.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return drawerMenuList.size();
    }



    class DrawerViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        ImageView icon;

        public DrawerViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.title);
            icon = (ImageView)itemView.findViewById(R.id.icon);


        }

    }
}
