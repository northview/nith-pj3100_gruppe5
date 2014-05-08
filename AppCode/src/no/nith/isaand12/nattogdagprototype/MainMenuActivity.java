package no.nith.isaand12.nattogdagprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenuActivity extends MainActivity implements OnClickListener {
	
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		Button logoutButton = (Button) findViewById(R.id.logg_ut);
		logoutButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainMenuActivity.this, MainActivity.class);
				startActivity(i);
				
			}
		});
		
		Button minKontoButton = (Button) findViewById(R.id.min_konto);
		minKontoButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainMenuActivity.this, MinKontoActivity.class);
				startActivity(i);
				
			}
		});
		
		Button mineRuterButton = (Button) findViewById(R.id.mine_ruter);
		mineRuterButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainMenuActivity.this, MineRuterActivity.class);
				startActivity(i);
				
			}
		});
		
		Button finnRuteButton = (Button) findViewById(R.id.finn_rute);
		finnRuteButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainMenuActivity.this, FinnRuteActivity.class);
				startActivity(i);
				
			}
		});
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
}
