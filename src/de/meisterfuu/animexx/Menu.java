package de.meisterfuu.animexx;

import de.meisterfuu.animexx.ENS.ENSMenu;
import de.meisterfuu.animexx.GB.GBViewList;
import de.meisterfuu.animexx.Home.ContactsActivityList;
import de.meisterfuu.animexx.other.ContactList;
import de.meisterfuu.animexx.other.Settings;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Menu extends Activity {
	// private SharedPreferences config;
	static final String[] List = new String[] { "ENS", "News",
			"Kontaktaktivitäten", "Gästebuch", "Kontakte", "Einstellungen", "About"};
	ListView listView;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu2);
		listView = (ListView) findViewById(R.id.mylist);
		setlist();
		//Intent intent2 = new Intent();
		//intent2.setAction("de.meisterfuu.animexx.karotaler");
		//intent2.putExtra("action", "stats" ); 
		//intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		//sendBroadcast(intent2);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}


	@Override
	public void onBackPressed() {
		Intent startMain = new Intent(Intent.ACTION_MAIN);
		startMain.addCategory(Intent.CATEGORY_HOME);
		startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(startMain);
		return;
	}

	private void setlist() {
		listView.setAdapter(new ArrayAdapter<String>(this, R.layout.menu, List));
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				switch (position) {
				case 0:
					startActivity(new Intent().setClass(
							getApplicationContext(), ENSMenu.class));
					break;
				case 2:
					startActivity(new Intent().setClass(
							getApplicationContext(), ContactsActivityList.class));
					break;
				case 3:
					startActivity(new Intent().setClass(
							getApplicationContext(), GBViewList.class));
					break;
				case 4:
					startActivity(new Intent().setClass(
							getApplicationContext(), ContactList.class));
					break;
				case 5:
					startActivity(new Intent().setClass(
							getApplicationContext(), Settings.class));
					break;
				case 6:
					startActivity(new Intent().setClass(
							getApplicationContext(), about.class));
					break;
				/*
				 *   case 7:
				 *   startActivity(new Intent().setClass(getApplicationContext(), Debug.class));
				 *   break;
				 */				
				default:
					Request.doToast("Gibts noch nicht :P",
							getApplicationContext());
					break;
				}

			}
		});
	}

}
