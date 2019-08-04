package ws.wolfsoft.kwiktaxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class FeedbackActivity extends AppCompatActivity {
    Spinner sp_insuarance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        sp_insuarance = (Spinner)findViewById(R.id.sp_car_name);

        List<String> list = new ArrayList<String>();
        list.add("Please select");
        list.add("UAP Insuarance");
        list.add("UAP Insuarance");
        list.add("UAP Insuarance");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(FeedbackActivity.this, R.layout.spinner_item, R.id.spinner_text, list);
        sp_insuarance.setAdapter(dataAdapter);

    }
}
