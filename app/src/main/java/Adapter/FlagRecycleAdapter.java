package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ModelClass.FlagModelClass;
import ModelClass.KwikListModelClass;
import de.hdodenhof.circleimageview.CircleImageView;
import ws.wolfsoft.kwiktaxi.ActivationCodeActivity;
import ws.wolfsoft.kwiktaxi.AlertActivity;
import ws.wolfsoft.kwiktaxi.ChoosePaymentActivity;
import ws.wolfsoft.kwiktaxi.CreatPasswordActivity;
import ws.wolfsoft.kwiktaxi.CreatPasswordFullViewActivity;
import ws.wolfsoft.kwiktaxi.CreditCardActivity;
import ws.wolfsoft.kwiktaxi.EmailAddressActivity;
import ws.wolfsoft.kwiktaxi.KwikSignUpActivity;
import ws.wolfsoft.kwiktaxi.KwikSignUpAlternativeActivity;
import ws.wolfsoft.kwiktaxi.KwikSignUpThree;
import ws.wolfsoft.kwiktaxi.R;
import ws.wolfsoft.kwiktaxi.SignUpWithSocialAccountActivity;
import ws.wolfsoft.kwiktaxi.SignUpWithSocialActivity;


public class FlagRecycleAdapter extends RecyclerView.Adapter<FlagRecycleAdapter.MyViewHolder> {

    Context context;


    private List<FlagModelClass> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        CircleImageView imageView;


        public MyViewHolder(View view) {
            super(view);

            imageView = (CircleImageView) view.findViewById(R.id.image);


        }

    }


    public FlagRecycleAdapter(Context context, List<FlagModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public FlagRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_flag_list, parent, false);


        return new FlagRecycleAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        FlagModelClass lists = OfferList.get(position);
        holder.imageView.setImageResource(lists.getImage());





    }


    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


