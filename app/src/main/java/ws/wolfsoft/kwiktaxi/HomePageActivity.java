package ws.wolfsoft.kwiktaxi;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arsy.maps_library.MapRadar;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {

    LinearLayout linear1,linear2,linear3;
    LinearLayout cart_txt,train_txt,walk_men_txt;
    ImageView car_image,train_image,walk_men_image;
    MapRadar mapRadar;private Context context = HomePageActivity.this;
    private double radius = 1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);




        linear1 = (LinearLayout)findViewById(R.id.linear1);
        linear2 = (LinearLayout)findViewById(R.id.linear2);
        linear3 = (LinearLayout)findViewById(R.id.linear3);


        cart_txt = (LinearLayout)findViewById(R.id.cart_txt);
        train_txt = (LinearLayout)findViewById(R.id.train_txt);
        walk_men_txt = (LinearLayout)findViewById(R.id.walk_men_txt);

        car_image = (ImageView)findViewById(R.id.car_image);
        train_image = (ImageView)findViewById(R.id.train_image);
        walk_men_image = (ImageView)findViewById(R.id.walk_men_image);


        linear1.setOnClickListener(this);
        linear2.setOnClickListener(this);
        linear3.setOnClickListener(this);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }





    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.linear1:


                car_image.setImageResource(R.drawable.ic_car_1_black);
                train_image.setImageResource(R.drawable.ic_car2_gray);
                walk_men_image.setImageResource(R.drawable.ic_car3_gray);


                cart_txt.setVisibility(View.VISIBLE);
                train_txt.setVisibility(View.GONE);
                walk_men_txt.setVisibility(View.GONE);


                break;

            case R.id.linear2:

                car_image.setImageResource(R.drawable.ic_car_1_gray);
                train_image.setImageResource(R.drawable.ic_car2_black);
                walk_men_image.setImageResource(R.drawable.ic_car3_gray);


                cart_txt.setVisibility(View.GONE);
                train_txt.setVisibility(View.VISIBLE);
                walk_men_txt.setVisibility(View.GONE);


                break;

            case R.id.linear3:

                car_image.setImageResource(R.drawable.ic_car_1_gray);
                train_image.setImageResource(R.drawable.ic_car2_gray);
                walk_men_image.setImageResource(R.drawable.ic_car3_black);


                cart_txt.setVisibility(View.GONE);
                train_txt.setVisibility(View.GONE);
                walk_men_txt.setVisibility(View.VISIBLE);


                break;
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng latLng = new LatLng(22.3062518,73.1776364);

        double lat = 22.3062518;
        double lng = 73.1776364;

      /*  mapRipple = new MapRipple(googleMap, latLng, context);

        mapRipple.withNumberOfRipples(3);
        mapRipple.withFillColor(Color.parseColor("#FFA3D2E4"));
        mapRipple.withStrokeColor(Color.BLACK);
        mapRipple.withStrokewidth(0);      // 10dp
        mapRipple.withDistance(2000);      // 2000 metres radius
        mapRipple.withRippleDuration(12000);    //12000ms
        mapRipple.withTransparency(0.5f);
        mapRipple.startRippleMapAnimation();*/


        mapRadar = new MapRadar(googleMap, latLng, context);
        mapRadar.withClockWiseAnticlockwise(true);
        mapRadar.withDistance(2000);
        mapRadar.withClockwiseAnticlockwiseDuration(2);
        mapRadar.withOuterCircleFillColor(Color.parseColor("#12000000"));
        mapRadar.withOuterCircleStrokeColor(Color.parseColor("#fccd29"));
        mapRadar.withRadarColors(Color.parseColor("#00000000"), Color.parseColor("#ff000000"));  //starts from transparent to fuly black
        mapRadar.withRadarColors(Color.parseColor("#00fccd29"), Color.parseColor("#fffccd29"));  //starts from transparent to fuly black
        mapRadar.withOuterCircleStrokewidth(7);
        mapRadar.withRadarSpeed(5);
        mapRadar.withOuterCircleTransparency(0.5f);
        mapRadar.withRadarTransparency(0.5f);



        googleMap.addCircle(new CircleOptions()
                .center(new LatLng(lat,lng))
                .radius(radius)
                .strokeColor(Color.BLUE)
                .strokeWidth(0f)
                .fillColor(Color.parseColor("#500084d3")));
        // create marker
        MarkerOptions marker = new MarkerOptions().position(latLng).title("Your are here");
        marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_caronmap));

// adding marker
        googleMap.addMarker(marker);

        //    marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                latLng).zoom(13).build();

        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }


}
