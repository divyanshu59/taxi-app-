package ws.wolfsoft.kwiktaxi;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import Adapter.CreditCardPagerAdapter;
import Adapter.FlagRecycleAdapter;
import Adapter.SignupWithMobileNumPagerAdapter;
import ModelClass.FlagModelClass;
import me.relex.circleindicator.CircleIndicator;

public class SignupWithMobileNumActivity extends AppCompatActivity {

    private SignupWithMobileNumPagerAdapter signupWithMobileNumPagerAdapter;

    private ViewPager viewPager;
    private CircleIndicator indicator;



    private ArrayList<FlagModelClass> flagModelClasses;
    private RecyclerView recyclerview;
    private FlagRecycleAdapter mAdapter2;
    private Integer image[]={R.drawable.f3,R.drawable.f1,R.drawable.f2,R.drawable.f4,R.drawable.f5,R.drawable.f2,R.drawable.f4,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_with_mobile_num);


       //        circleindicator and viewpager used


        viewPager = (ViewPager) findViewById(R.id.viewpager);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);

        signupWithMobileNumPagerAdapter = new SignupWithMobileNumPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(signupWithMobileNumPagerAdapter);

        indicator.setViewPager(viewPager);

        signupWithMobileNumPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());



        //        Category Recyclerview Code is here

        recyclerview = (RecyclerView)findViewById(R.id.recyclerView);

        flagModelClasses = new ArrayList<>();



        for (int i = 0; i < image.length; i++) {
            FlagModelClass beanClassForRecyclerView_contacts = new FlagModelClass(image[i]);

            flagModelClasses.add(beanClassForRecyclerView_contacts);
        }


        mAdapter2 = new FlagRecycleAdapter(SignupWithMobileNumActivity.this, flagModelClasses);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(SignupWithMobileNumActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerview.setLayoutManager(mLayoutManager1);


        recyclerview.setLayoutManager(mLayoutManager1);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(mAdapter2);


    }
}
