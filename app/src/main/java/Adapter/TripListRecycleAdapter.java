package Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ModelClass.InviteModelClass;
import ModelClass.TripListModelClass;
import de.hdodenhof.circleimageview.CircleImageView;
import ws.wolfsoft.kwiktaxi.R;


public class TripListRecycleAdapter extends RecyclerView.Adapter<TripListRecycleAdapter.MyViewHolder> {

    Context context;


    private List<TripListModelClass> OfferList;

    int myPos = 0;


    public class MyViewHolder extends RecyclerView.ViewHolder {




        TextView title,via,car,date,date_num,clock,clock_time;
        LinearLayout dark_linear,white_linear;
        ImageView car_image,bg_image;


        public MyViewHolder(View view) {
            super(view);


            title = (TextView)view.findViewById(R.id.title);
            via = (TextView)view.findViewById(R.id.via);
            car = (TextView)view.findViewById(R.id.car);
            date = (TextView)view.findViewById(R.id.date);
            date_num = (TextView)view.findViewById(R.id.date_num);
            clock = (TextView)view.findViewById(R.id.clock);
            clock_time = (TextView)view.findViewById(R.id.clock_time);
            dark_linear = (LinearLayout)view.findViewById(R.id.dark_linear);
            white_linear = (LinearLayout)view.findViewById(R.id.white_linear);
            car_image = (ImageView)view.findViewById(R.id.car_image);
            bg_image = (ImageView)view.findViewById(R.id.bgimage);


        }

    }


    public TripListRecycleAdapter(Context context, List<TripListModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public TripListRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_trip_list, parent, false);


        return new TripListRecycleAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        TripListModelClass lists = OfferList.get(position);
        holder.title.setText(lists.getTitle());



        if (myPos == position){
            holder.title.setTextColor(Color.parseColor("#ffffff"));
            holder.via.setTextColor(Color.parseColor("#ffffff"));
            holder.car.setTextColor(Color.parseColor("#ffffff"));
            holder.date.setTextColor(Color.parseColor("#ffffff"));
            holder.date_num.setTextColor(Color.parseColor("#ffffff"));
            holder.clock.setTextColor(Color.parseColor("#ffffff"));
            holder.clock_time.setTextColor(Color.parseColor("#ffffff"));
            holder.car_image.setImageResource(R.drawable.ic_car);
            holder.bg_image.setImageResource(R.drawable.cardmapbg);
            holder.dark_linear.setBackground(ContextCompat.getDrawable(context, R.drawable.gradient_dark_rect));;
        }else {

            holder.title.setTextColor(Color.parseColor("#000000"));
            holder.via.setTextColor(Color.parseColor("#000000"));
            holder.car.setTextColor(Color.parseColor("#000000"));
            holder.date.setTextColor(Color.parseColor("#000000"));
            holder.date_num.setTextColor(Color.parseColor("#000000"));
            holder.clock.setTextColor(Color.parseColor("#000000"));
            holder.clock_time.setTextColor(Color.parseColor("#000000"));
            holder.car_image.setImageResource(R.drawable.ic_car_black);
            holder.bg_image.setImageResource(R.drawable.cardmapbg);
            holder.dark_linear.setBackgroundResource(R.drawable.trip_list_rect);
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPos = position;
                notifyDataSetChanged();

            }


        });



    }


    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


