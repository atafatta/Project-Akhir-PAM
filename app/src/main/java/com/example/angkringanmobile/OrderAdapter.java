package com.example.angkringanmobile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter <OrderAdapter.ViewHolder>{

    List<Model> modelList;
    Context context;

    public OrderAdapter(Context context, List<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        String nameofDrink = modelList.get(position).getmDrinkName();
        String descriptionofdrink = modelList.get(position).getmDrinkDetail();
        int images = modelList.get(position).getmDrinkPhoto();

        holder.mDrinkName.setText(nameofDrink);
        holder.mDrinkDescription.setText(descriptionofdrink);
        holder.imageView.setImageResource(images);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    //onclicklistener recyclerview
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //mencari views yang akan di inflate di data
        TextView mDrinkName, mDrinkDescription;
        ImageView imageView;


        public ViewHolder( View itemView) {
            super(itemView);

            mDrinkName = itemView.findViewById(R.id.coffeeName);
            mDrinkDescription = itemView.findViewById(R.id.description);
            imageView = itemView.findViewById(R.id.nsikcing);
            itemView.setOnClickListener(this);
        }
        //memanggil dr recycler view
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            if (position == 0){
                Intent intent = new Intent(context, InfoActivity.class);
                context.startActivity(intent);
            }
            if(position == 1){
                Intent intent2 = new Intent(context, SateAtiOrder.class);
                context.startActivity(intent2);
            }
            if(position == 2){
                Intent intent3 = new Intent(context, CekerBeli.class);
                context.startActivity(intent3);
            }
            if (position == 3){
                Intent intent4 = new Intent(context, SateTelurBeli.class);
                context.startActivity(intent4);
            }
            if (position == 4){
                Intent intent5 = new Intent(context, SateUsusBeli.class);
                context.startActivity(intent5);
            }
            if (position == 5){
                Intent intent6 = new Intent(context, TehBeli.class);
                context.startActivity(intent6);
            }
            if (position == 6){
                Intent intent7 = new Intent(context, SusuJaheBeli.class);
                context.startActivity(intent7);
            }
            if (position == 7){
                Intent intent8 = new Intent(context, TahuBacemBeli.class);
                context.startActivity(intent8);
            }
            if (position == 8){
                Intent intent9 = new Intent(context, PiscokBeli.class);
                context.startActivity(intent9);
            }

        }
    }
}
