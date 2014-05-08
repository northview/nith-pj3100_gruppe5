package no.nith.isaand12.nattogdagprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MinKontoActivity extends MainMenuActivity {
	
	Button backButton;
	
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_min_konto);
		
		backButton = (Button)findViewById(R.id.backButton);
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MinKontoActivity.this, MainMenuActivity.class);
				startActivity(i);
				
			}
		});

	}
}
