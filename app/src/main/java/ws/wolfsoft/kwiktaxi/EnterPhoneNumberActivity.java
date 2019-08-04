package ws.wolfsoft.kwiktaxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import Adapter.FlagRecycleAdapter;
import ModelClass.FlagModelClass;

public class EnterPhoneNumberActivity extends AppCompatActivity {



    private ArrayList<FlagModelClass> flagModelClasses;
    private RecyclerView recyclerview;
    private FlagRecycleAdapter mAdapter2;
    private Integer image[]={R.drawable.f3,R.drawable.f1,R.drawable.f2,R.drawable.f4,R.drawable.f5,R.drawable.f1,R.drawable.f2,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_phone_number);



        //        Category Recyclerview Code is here

        recyclerview = (RecyclerView)findViewById(R.id.recyclerView);

        flagModelClasses = new ArrayList<>();



        for (int i = 0; i < image.length; i++) {
            FlagModelClass beanClassForRecyclerView_contacts = new FlagModelClass(image[i]);

            flagModelClasses.add(beanClassForRecyclerView_contacts);
        }


        mAdapter2 = new FlagRecycleAdapter(EnterPhoneNumberActivity.this, flagModelClasses);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(EnterPhoneNumberActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerview.setLayoutManager(mLayoutManager1);


        recyclerview.setLayoutManager(mLayoutManager1);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(mAdapter2);
    }
}
