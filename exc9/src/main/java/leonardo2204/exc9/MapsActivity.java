package leonardo2204.exc9;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button menosZoomButton;
    private Button maisZoomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        this.menosZoomButton = (Button) findViewById(R.id.menosZoom);
        this.maisZoomButton = (Button) findViewById(R.id.maisZoom);


        this.menosZoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.animateCamera(CameraUpdateFactory.zoomBy(-1f));
            }
        });

        this.maisZoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.animateCamera(CameraUpdateFactory.zoomBy(1f));
            }
        });
    }

    private void addMarker(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions()
        .position(new LatLng(37.422000f,-122.084057f))
        .title("Google")
        .snippet("Casa do Android")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_android)));
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sydney = new LatLng(-23.566171f, -46.652617f);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Quaddro"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        addMarker(googleMap);
    }
}
