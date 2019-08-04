package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ModelClass.FlagModelClass;
import ModelClass.InviteModelClass;
import de.hdodenhof.circleimageview.CircleImageView;
import ws.wolfsoft.kwiktaxi.R;


public class InviteRecycleAdapter extends RecyclerView.Adapter<InviteRecycleAdapter.MyViewHolder> {

    Context context;


    private List<InviteModelClass> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {



        CircleImageView imageView;
        TextView title;


        public MyViewHolder(View view) {
            super(view);

            imageView = (CircleImageView) view.findViewById(R.id.image);
            title = (TextView)view.findViewById(R.id.title);


        }

    }


    public InviteRecycleAdapter(Context context, List<InviteModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public InviteRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_invite_lsit, parent, false);


        return new InviteRecycleAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        InviteModelClass lists = OfferList.get(position);
        holder.imageView.setImageResource(lists.getImage());
        holder.title.setText(lists.getTitle());





    }


    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


