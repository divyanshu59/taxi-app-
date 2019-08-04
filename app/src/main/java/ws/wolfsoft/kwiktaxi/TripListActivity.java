package ws.wolfsoft.kwiktaxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import Adapter.InviteRecycleAdapter;
import Adapter.TripListRecycleAdapter;
import ModelClass.InviteModelClass;
import ModelClass.TripListModelClass;

public class TripListActivity extends AppCompatActivity {

    TextView save,title;

    private ArrayList<TripListModelClass> tripListModelClasses;
    private RecyclerView recyclerView;
    private TripListRecycleAdapter bAdapter;

    private  String titlle[] = {"Ahmedabad\n" +
            "Ring Road","Jetalpur\n" +
            "Indabulls Mall","Jetalpur\n" +
            "Indabulls Mall"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);
//        save  = (TextView)findViewById(R.id.save);
//        title = (TextView)findViewById(R.id.title);
//
//        title.setText("Recent Trips");
//        save.setVisibility(View.GONE);


        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TripListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        tripListModelClasses = new ArrayList<>();

        for (int i = 0; i < titlle.length; i++) {
            TripListModelClass beanClassForRecyclerView_contacts = new TripListModelClass(titlle[i]);
            tripListModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new TripListRecycleAdapter(TripListActivity.this,tripListModelClasses);
        recyclerView.setAdapter(bAdapter);


    }
}
