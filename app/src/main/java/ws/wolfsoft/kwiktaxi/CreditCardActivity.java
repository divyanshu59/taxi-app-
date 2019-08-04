package ws.wolfsoft.kwiktaxi;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Adapter.CreditCardPagerAdapter;
import me.relex.circleindicator.CircleIndicator;

public class CreditCardActivity extends AppCompatActivity {

    private CreditCardPagerAdapter creditCardPagerAdapter;

    private ViewPager viewPager;
    private CircleIndicator indicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card);



//        circleindicator and viewpager used


        viewPager = (ViewPager) findViewById(R.id.viewpager);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);

        creditCardPagerAdapter = new CreditCardPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(creditCardPagerAdapter);

        indicator.setViewPager(viewPager);

        creditCardPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());
    }
}
