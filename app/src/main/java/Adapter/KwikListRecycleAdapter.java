package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ModelClass.KwikListModelClass;
import ws.wolfsoft.kwiktaxi.ActivationCodeActivity;
import ws.wolfsoft.kwiktaxi.AlertActivity;
import ws.wolfsoft.kwiktaxi.AletActivtiy2;
import ws.wolfsoft.kwiktaxi.ChooseDestinationActivity;
import ws.wolfsoft.kwiktaxi.ChoosePaymentActivity;
import ws.wolfsoft.kwiktaxi.ChoosePaymentOneActivity;
import ws.wolfsoft.kwiktaxi.CreatPasswordActivity;
import ws.wolfsoft.kwiktaxi.CreatPasswordFullViewActivity;
import ws.wolfsoft.kwiktaxi.CreditCardActivity;
import ws.wolfsoft.kwiktaxi.DriverActivity;
import ws.wolfsoft.kwiktaxi.EmailAddressActivity;
import ws.wolfsoft.kwiktaxi.EnterPhoneNumberActivity;
import ws.wolfsoft.kwiktaxi.FeedbackActivity;
import ws.wolfsoft.kwiktaxi.HomapageWithConfirmActivity;
import ws.wolfsoft.kwiktaxi.HomePage2Activity;
import ws.wolfsoft.kwiktaxi.HomePageActivity;
import ws.wolfsoft.kwiktaxi.InviteActivity;
import ws.wolfsoft.kwiktaxi.KwikSignUpActivity;
import ws.wolfsoft.kwiktaxi.KwikSignUpAlternativeActivity;
import ws.wolfsoft.kwiktaxi.KwikSignUpThree;
import ws.wolfsoft.kwiktaxi.ProfileActivity;
import ws.wolfsoft.kwiktaxi.R;
import ws.wolfsoft.kwiktaxi.SignUpWithSocialAccountActivity;
import ws.wolfsoft.kwiktaxi.SignUpWithSocialActivity;
import ws.wolfsoft.kwiktaxi.SignupWithMobileNumActivity;
import ws.wolfsoft.kwiktaxi.TripActivity;
import ws.wolfsoft.kwiktaxi.TripListActivity;


public class KwikListRecycleAdapter extends RecyclerView.Adapter<KwikListRecycleAdapter.MyViewHolder> {

    Context context;


    private List<KwikListModelClass> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView title;


        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);


        }

    }


    public KwikListRecycleAdapter(Context context, List<KwikListModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public KwikListRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kwik_list, parent, false);


        return new KwikListRecycleAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        KwikListModelClass lists = OfferList.get(position);
        holder.title.setText(lists.getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position == 0) {
                    Intent i = new Intent(context, SignUpWithSocialActivity.class);
                    context.startActivity(i);
                }else if(position == 1) {
                    Intent i = new Intent(context, KwikSignUpActivity.class);
                    context.startActivity(i);
                }else if(position == 2) {
                    Intent i = new Intent(context, KwikSignUpAlternativeActivity.class);
                    context.startActivity(i);
                }else if(position == 3) {
                    Intent i = new Intent(context, KwikSignUpThree.class);
                    context.startActivity(i);
                }else if(position == 4) {
                    Intent i = new Intent(context, SignUpWithSocialAccountActivity.class);
                    context.startActivity(i);
                }else if(position == 5) {
                    Intent i = new Intent(context, ActivationCodeActivity.class);
                    context.startActivity(i);
                }else if(position == 6) {
                    Intent i = new Intent(context, EnterPhoneNumberActivity.class);
                    context.startActivity(i);
                }else if(position == 7) {
                    Intent i = new Intent(context, EmailAddressActivity.class);
                    context.startActivity(i);
                }else if(position == 8) {
                    Intent i = new Intent(context, CreatPasswordActivity.class);
                    context.startActivity(i);
                }else if(position == 9) {
                    Intent i = new Intent(context, CreatPasswordFullViewActivity.class);
                    context.startActivity(i);
                }else if(position == 10) {
                    Intent i = new Intent(context, AlertActivity.class);
                    context.startActivity(i);
                }else if(position == 11) {
                    Intent i = new Intent(context, AletActivtiy2.class);
                    context.startActivity(i);
                }else if(position == 12) {
                    Intent i = new Intent(context, HomePageActivity.class);
                    context.startActivity(i);
                }else if(position == 13) {
                    Intent i = new Intent(context, SignupWithMobileNumActivity.class);
                    context.startActivity(i);
                }else if(position == 14) {
                    Intent i = new Intent(context, FeedbackActivity.class);
                    context.startActivity(i);
                }else if(position == 15) {
                    Intent i = new Intent(context, ChoosePaymentActivity.class);
                    context.startActivity(i);
                }else if(position == 16) {
                    Intent i = new Intent(context, CreditCardActivity.class);
                    context.startActivity(i);
                }else if(position == 17) {
                    Intent i = new Intent(context, ChoosePaymentOneActivity.class);
                    context.startActivity(i);
                }else if(position == 18) {
                    Intent i = new Intent(context, TripActivity.class);
                    context.startActivity(i);
                }else if(position == 19) {
                    Intent i = new Intent(context, TripListActivity.class);
                    context.startActivity(i);
                }else if(position == 20) {
                    Intent i = new Intent(context, ProfileActivity.class);
                    context.startActivity(i);
                }else if(position == 21) {
                    Intent i = new Intent(context, InviteActivity.class);
                    context.startActivity(i);
                }else if(position == 22) {
                    Intent i = new Intent(context, HomePage2Activity.class);
                    context.startActivity(i);
                }else if(position == 23) {
                    Intent i = new Intent(context, HomapageWithConfirmActivity.class);
                    context.startActivity(i);
                }else if(position == 24) {
                    Intent i = new Intent(context, ChooseDestinationActivity.class);
                    context.startActivity(i);
                }else if(position == 25) {
                    Intent i = new Intent(context, DriverActivity.class);
                    context.startActivity(i);
                }

            }

        });


    }


    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


