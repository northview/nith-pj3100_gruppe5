package no.nith.isaand12.nattogdagprototype;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class RuteInfoActivity extends MainActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ruteinfo);
		
		Button backButton = (Button)findViewById(R.id.btnBack);
		backButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(RuteInfoActivity.this, MapActivity.class);
				startActivity(i);
				
			}
		});
	}

}
