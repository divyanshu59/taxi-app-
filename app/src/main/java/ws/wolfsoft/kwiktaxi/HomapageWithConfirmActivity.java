package ws.wolfsoft.kwiktaxi;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ahmadrosid.lib.drawroutemap.DrawMarker;
import com.arsy.maps_library.MapRadar;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomapageWithConfirmActivity extends AppCompatActivity implements View.OnClickListener,OnMapReadyCallback {



    private GoogleMap mMap;
    private Marker customMarker;
    private LatLng origin, destination, three, four, five, six, seven;

    MapRadar mapRadar;
    private Context context = HomapageWithConfirmActivity.this;
    private double radius = 1000;



    LinearLayout linear1,linear2,linear3;
    LinearLayout cart_txt,train_txt,walk_men_txt;
    ImageView car_image,train_image,walk_men_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homapage_with_confirm);
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





        //        Google map code is here.


        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map2);
        mapFragment.getMapAsync((OnMapReadyCallback) this);

        //lat & long for the points on map
        origin = new LatLng(-7.788969, 110.338382);
        destination = new LatLng(-7.781200, 110.349709);
        three = new LatLng(-7.781800, 110.347001);
        four = new LatLng(-7.785002, 110.349010);
        five = new LatLng(-7.787050, 110.343000);
        six = new LatLng(-7.790020, 110.343000);
        seven = new LatLng(-7.780020, 110.333000);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        DrawMarker.getInstance(this).draw(mMap, origin, R.drawable.ic_caronmap, "My Location");
        DrawMarker.getInstance(this).draw(mMap, destination, R.drawable.ic_caronmap, "Destination");
        DrawMarker.getInstance(this).draw(mMap, three, R.drawable.ic_caronmap, "Destination");
        DrawMarker.getInstance(this).draw(mMap, four, R.drawable.ic_caronmap, "Destination");
        DrawMarker.getInstance(this).draw(mMap, five, R.drawable.ic_caronmap, "Destination");
        DrawMarker.getInstance(this).draw(mMap, six, R.drawable.ic_caronmap, "Destination");
        DrawMarker.getInstance(this).draw(mMap, seven, R.drawable.ic_caronmap, "Destination");

        //it binds the camera postition to the above two points
        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(origin)
                .include(destination)
                .include(three)
                .include(four)
                .include(five)
                .include(six).build();
        Point displaySize = new Point();
        getWindowManager().getDefaultDisplay().getSize(displaySize);
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, displaySize.x, 260, 30));

        //for automatic zoomin when you open the activity....
        //the vaalue can be changed according to your use.....
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.3f));






        LatLng latLng = new LatLng(-7.781200,110.349709);

        double lat = -7.781200;
        double lng = 110.349709;

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
}
