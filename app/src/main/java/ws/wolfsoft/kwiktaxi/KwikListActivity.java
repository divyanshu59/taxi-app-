package ws.wolfsoft.kwiktaxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import Adapter.KwikListRecycleAdapter;
import ModelClass.KwikListModelClass;

public class KwikListActivity extends AppCompatActivity {


    private ArrayList<KwikListModelClass> kwikListModelClasses;
    private RecyclerView recyclerView;
    private KwikListRecycleAdapter bAdapter;

    private String txt[]={"1.SignUpWithSocialActivity","2.KwikSignUpActivity","3.KwikSignUpAlternativeActivity","4.KwikSignUpThree",
    "5.SignUpWithSocialAccountActivity","6.ActivationCodeActivity","7.EnterNumbeActivity","8.E-mailAddressActivity ","9.CreatPasswordActivity",
            "10.CreatPasswordFullViewActivity","11.AlertActivity","12.AlertActivity2","13.HomePageActivity","14.SignUpWithMobileNumberActivity",
            "15.FeedbackActivity","16.ChoosePaymentActivity","17.CreditCardActivity","18.ChoosePaymentOneAcitivty","19.TripActivity","20.TripListActivity",
            "21.ProfileActivity","22.InviteActivity","23.HomePage2Activity","24.HomePageWithConfirmActivity","25.ChooseDestinationActivity", "26.DriverActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kwik_list);


        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(KwikListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        kwikListModelClasses = new ArrayList<>();

        for (int i = 0; i < txt.length; i++) {
            KwikListModelClass beanClassForRecyclerView_contacts = new KwikListModelClass(txt[i]);
            kwikListModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new KwikListRecycleAdapter(KwikListActivity.this,kwikListModelClasses);
        recyclerView.setAdapter(bAdapter);


    }
}
