package no.nith.nattogdag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

public class MapActivity extends Activity {
	
	private SharedPreferences prefs;
	private String maptype;
	
	private GoogleMap map;
	private MyMarker myMarker;
	private String user;
	private String password;
	private static MyMarker[] markerArray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		
		
		Intent intent = getIntent();
		user = intent.getStringExtra("user");
		password = intent.getStringExtra("password");
		
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		maptype = prefs.getString("pref_map", "MAP_TYPE_NORMAL");
		setUpMapIfNeeded();
	}
	
	
	@Override
	protected void onPause() {
		super.onPause();
		
		map = null;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case R.id.menu_settings:
				startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
				return true;
			default: 
				return false;
		}
	}
	

	private void setUpMapIfNeeded() {
	    // Do a null check to confirm that we have not already instantiated the map.
	    if (map == null) {
	        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
	                            .getMap();
	        // Check if we were successful in obtaining the map.
	        if (map != null) {
	            // The Map is verified. It is now safe to manipulate the map.
	        	LatLng oslo = new LatLng(59.90202436, 10.75698853);
	        	setMapType();
	        	map.setMyLocationEnabled(true);
	        	map.getUiSettings().setMyLocationButtonEnabled(true);
	        	map.moveCamera(CameraUpdateFactory.newLatLngZoom(oslo, 10));

	        	new GetMyMarkers().execute(user, password);

	        }
	    }
	    
	    
	}
	
	private void setMapType() {
		if(maptype.equals("MAP_TYPE_NORMAL")) {
			map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		} else if(maptype.equals("MAP_TYPE_HYBRID")) {
			map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		} else  if(maptype.equals("MAP_TYPE_HYBRID")) {
			map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		} else if(maptype.equals("MAP_TYPE_TERRAIN")) {
			map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
		} else if(maptype.equals("MAP_TYPE_SATELLITE")) {
			map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		} else if(maptype.equals("MAP_TYPE_NONE")) {
			map.setMapType(GoogleMap.MAP_TYPE_NONE);
		}
	}
	

	
	class GetMyMarkers extends AsyncTask<String, Void, MyMarker[]> {

		@Override
		protected MyMarker[] doInBackground(String... params) {
			BufferedReader rd;
			String user = params[0];
			String password = params[1];
			String jsonString = ""; // <-- The JsonArray downloaded from server as a String.
			Gson gson = new Gson(); // <-- Using Gson to convert the Json to an array of 
									// marker objects
			MyMarker[] markerArray = null;
			try {
				URL url = new URL("https://nattogdagprosjekt-nith.rhcloud.com/NattogDag/" +
						"JsonServlet?user=" + user + "&password=" + password +
								"&command=getMarkers");
				rd = new BufferedReader(
				        new InputStreamReader(url.openStream(), "ISO-8859-1"));
				Scanner scanner = new Scanner(rd);
				// Uses the regex \A, which matches the beginning of input, telling Scanner 
				// to tokenize the entire stream.
				jsonString = scanner.useDelimiter("\\A").next();
				
				//closing resources.
				scanner.close();
				rd.close();
				// Get an array of Marker objects.
				markerArray = gson.fromJson(jsonString, MyMarker[].class);
				
			} catch (Exception e) {
				Log.e("GetMarkers", e.toString());
			} 
			return markerArray;
		}
		
		@Override
		protected void onPostExecute(MyMarker[] result) {
			markerArray = result;
			addMarkers();

		}
		
	}
	
	private void addMarkers() {
		for(MyMarker mymarker: markerArray) {
			String snippet = mymarker.getAddress() + " " + mymarker.getCity();
			map.addMarker(new MarkerOptions().position(mymarker.getLatlng())
					.title(mymarker.getName())
					.snippet(snippet));
		}
		
	}
	

}
