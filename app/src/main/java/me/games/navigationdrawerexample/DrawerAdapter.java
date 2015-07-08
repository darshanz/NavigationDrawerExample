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

    public final static int TYPE_HEADER = 0;
    public final static int TYPE_MENU = 1;

    private ArrayList<DrawerItem> drawerMenuList;
    private OnItemSelecteListener mListener;
    private String name;


    public DrawerAdapter(ArrayList<DrawerItem> drawerMenuList, String name) {
        this.drawerMenuList = drawerMenuList;
        this.name = name;
    }




    @Override
    public DrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == TYPE_HEADER){

             view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_drawer_header, parent, false);

        }else{

             view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        }


        return new DrawerViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(DrawerViewHolder holder, int position) {
        if(position == 0) {
            holder.headerText.setText(name);
        }else{
            holder.title.setText(drawerMenuList.get(position - 1).getTitle());
            holder.icon.setImageResource(drawerMenuList.get(position - 1).getIcon());
        }

    }

    @Override
    public int getItemCount() {
        return drawerMenuList.size()+1;
    }



    class DrawerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
         TextView title;
         TextView headerText;
         ImageView icon;

        public DrawerViewHolder(View itemView, int viewType) {
            super(itemView);


            if(viewType == 0){
                headerText = (TextView)itemView.findViewById(R.id.headerText);
            }else {
                title = (TextView) itemView.findViewById(R.id.title);
                icon = (ImageView) itemView.findViewById(R.id.icon);
            }

            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View view) {
             mListener.onItemSelected(view, getAdapterPosition());
        }
    }


    @Override
    public int getItemViewType(int position) {

        if(position == 0){
            return  TYPE_HEADER;
        }
        return TYPE_MENU;

    }

    public void setOnItemClickLister(OnItemSelecteListener mListener) {
        this.mListener = mListener;
    }

    interface OnItemSelecteListener{
        public void onItemSelected(View v, int position);
    }
}
