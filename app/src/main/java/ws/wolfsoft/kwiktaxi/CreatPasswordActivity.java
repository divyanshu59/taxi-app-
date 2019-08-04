package ws.wolfsoft.kwiktaxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CreatPasswordActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_password);

        textView = (TextView)findViewById(R.id.time);
        textView.setVisibility(View.GONE);
    }
}
