package ws.wolfsoft.kwiktaxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import Adapter.InviteRecycleAdapter;
import Adapter.KwikListRecycleAdapter;
import ModelClass.InviteModelClass;
import ModelClass.KwikListModelClass;

public class InviteActivity extends AppCompatActivity {


    private ArrayList<InviteModelClass> inviteModelClasses;
    private RecyclerView recyclerView;
    private InviteRecycleAdapter bAdapter;

    private Integer image[] = {R.drawable.car,R.drawable.car,R.drawable.car,R.drawable.car,R.drawable.car};
    private String titlle[] = {"John Berrow","Randy Orten","Abd Villiers","Michal Storn","Love Bird"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);


        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(InviteActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        inviteModelClasses = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            InviteModelClass beanClassForRecyclerView_contacts = new InviteModelClass(image[i],titlle[i]);
            inviteModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new InviteRecycleAdapter(InviteActivity.this,inviteModelClasses);
        recyclerView.setAdapter(bAdapter);
    }
}
