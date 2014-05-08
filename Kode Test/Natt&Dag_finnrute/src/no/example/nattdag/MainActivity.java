package no.example.nattdag;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btn1;
	Button btn2;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn1 = (Button)findViewById(R.id.btnA);
		btn2 = (Button)findViewById(R.id.btnB);
		
		registerForContextMenu(btn1);
		registerForContextMenu(btn2);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {

		switch(item.getItemId()){
		case R.id.item1:
			btn1.setText("Oslo");
			break;
			
		case R.id.item2:
			btn1.setText("Bergen");
			break;
			
		case R.id.item3:
			btn1.setText("Trondheim");
			break;
			
		case R.id.item4:
			btn1.setText("Stavanger");
			break;
			
		case R.id.item5:
			btn2.setText("Majorstuene");
			break;
			
		case R.id.item6:
			btn2.setText("Grønnladn");
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
