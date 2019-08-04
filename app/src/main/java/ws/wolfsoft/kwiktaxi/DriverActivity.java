package ws.wolfsoft.kwiktaxi;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

public class DriverActivity extends AppCompatActivity implements OnMapReadyCallback {


    MapRadar mapRadar;
    private Context context = DriverActivity.this;
    private double radius = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


        @Override
        public void onMapReady(GoogleMap googleMap) {

            LatLng latLng = new LatLng(22.3062518, 73.1776364);

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
                    .center(new LatLng(lat, lng))
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


