package no.nith.isaand12.nattogdagprototype;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
//import android.view.Menu;
//import android.view.Window;

public class MainActivity extends Activity implements OnClickListener {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button loginButton = (Button) findViewById(R.id.login_button);
		loginButton.setOnClickListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(MainActivity.this, MainMenuActivity.class);
		startActivity(i);
	}
	
	@Override
	public void onBackPressed() {
		MainActivity.this.finish();
	}
}
