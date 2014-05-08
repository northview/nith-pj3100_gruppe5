package no.nith.isaand12.nattogdagprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MineRuterActivity extends MainMenuActivity {
	
	Button backButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mine_ruter);
		
		backButton = (Button)findViewById(R.id.tilbakeKnappen);
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MineRuterActivity.this, MainMenuActivity.class);
				startActivity(i);
				
			}
		});
	}
}
