package no.nith.isaand12.nattogdagprototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_map);
		
		Button tilbakeButton = (Button) findViewById(R.id.tilbake);
		tilbakeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MapActivity.this, FinnRuteActivity.class);
				startActivity(i);
				
			}
		});
		
		Button ruteInfoButton = (Button) findViewById(R.id.ruteinfo);
		ruteInfoButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MapActivity.this, RuteInfoActivity.class);
				startActivity(i);
				
			}
		});
		
		GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		
		LatLng oslo = new LatLng(59.912122, 10.749369);
		
		LatLng byporten = new LatLng(59.912159, 10.751578);
		LatLng sessionOsloCity = new LatLng(59.912611, 10.753123);
		LatLng urbanOsloCity = new LatLng(59.912837, 10.751535);
		LatLng grim = new LatLng(59.913031, 10.750548);
		LatLng ploensGate = new LatLng(59.914085, 10.748981);
		LatLng torgGata = new LatLng(59.913568, 10.746707);
		LatLng carlingsKarlJohan = new LatLng(59.911912, 10.746192);
		LatLng burgerkingKarlJohan = new LatLng(59.911729, 10.746922);
		LatLng arkadenKarlJohan = new LatLng(59.911718, 10.747823);
		
		map.setMyLocationEnabled(true);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(oslo, 16));
		
		map.addPolyline(new PolylineOptions().geodesic(true)
				.add(byporten)
				.add(sessionOsloCity)
				.add(urbanOsloCity)
				.add(grim)
				.add(ploensGate)
				.add(torgGata)
				.add(carlingsKarlJohan)
				.add(burgerkingKarlJohan)
				.add(arkadenKarlJohan)
				.add(byporten));
		
		map.addMarker(new MarkerOptions()
				.title("Byporten")
				.snippet("Platekompaniet, Urban")
				.position(byporten));
		map.addMarker(new MarkerOptions()
				.title("Session")
				.snippet("Session Oslo City")
				.position(sessionOsloCity));
		map.addMarker(new MarkerOptions()
				.title("Urban")
				.snippet("Urban Oslo City")
				.position(urbanOsloCity));
		map.addMarker(new MarkerOptions()
				.title("Grim")
				.snippet("Grim")
				.position(grim));
		map.addMarker(new MarkerOptions()
				.title("Cafe Mono")
				.snippet("Pl¿ens Gate 4")
				.position(ploensGate));
		map.addMarker(new MarkerOptions()
				.title("Rema 1000")
				.snippet("Torggata 2")
				.position(torgGata));
		map.addMarker(new MarkerOptions()
				.title("Carlings")
				.snippet("Carlings Karl Johan")
				.position(carlingsKarlJohan));
		map.addMarker(new MarkerOptions()
				.title("Burger King")
				.snippet("Burger King Karl Johan")
				.position(burgerkingKarlJohan));
		map.addMarker(new MarkerOptions()
				.title("Arkaden")
				.snippet("Arkaden Karl Johan")
				.position(arkadenKarlJohan));
	}
	

}
