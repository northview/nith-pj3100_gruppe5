package no.nith.isaand12.nattogdagprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class FinnRuteActivity extends MainActivity {
	
	Button velgByButton;
	Button velgRuteButton;
	Button startRuteButton;
	Button btnTilbake;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finn_rute);
		
		startRuteButton = (Button)findViewById(R.id.start_rute);
		startRuteButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(FinnRuteActivity.this, MapActivity.class);
				startActivity(i);
				
			}
		});
		
		btnTilbake = (Button)findViewById(R.id.btnTilbake);
		btnTilbake.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(FinnRuteActivity.this, MainMenuActivity.class);
				startActivity(i);
				
			}
		});
		
		velgByButton = (Button)findViewById(R.id.velg_by);
		velgRuteButton = (Button)findViewById(R.id.velg_rute);
		
		registerForContextMenu(velgByButton);
		registerForContextMenu(velgRuteButton);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {

		switch(item.getItemId()){
		
		case R.id.item1:
			velgByButton.setText("Oslo");
			break;
			
		case R.id.item2:
			velgByButton.setText("Bergen");
			break;
			
		case R.id.item3:
			velgByButton.setText("Trondheim");
			break;
			
		case R.id.item4:
			velgByButton.setText("Stavanger");
			break;
			
		case R.id.item5:
			velgRuteButton.setText("Majorstuen");
			break;
			
		case R.id.item6:
			velgRuteButton.setText("Gr¿nnland");
			break;
			
		}
		return super.onContextItemSelected(item);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {

		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.context, menu);
	}

}
