package no.example.nattdag_favoritter;

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
		btn1 = (Button)findViewById(R.id.button1);
		
		registerForContextMenu(btn1);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {

		switch(item.getItemId()){
		case R.id.item1:
			btn1.setText("Rute1");
			break;
			
		case R.id.item2:
			btn1.setText("Rute2");
			break;
			
		case R.id.item3:
			btn1.setText("Rute3");
			break;
			
		case R.id.item4:
			btn1.setText("Rute4");
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