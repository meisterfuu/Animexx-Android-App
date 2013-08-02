package de.meisterfuu.animexx;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;


public class Debug extends Activity {

	private Button Button;
	private WebView Web;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.debug);
		Web = (WebView) findViewById(R.id.webView1);
		Button = (Button) findViewById(R.id.fragment_microblog_send);
		Button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				
				
				new Thread(new Runnable() {

					public void run() {

							try {
								final String s = Request.makeSecuredReq("https://ws.animexx.de/json/persstart5/get_widget_data/?api=2&widget_id=kontakte&img_max_x=1000&img_max_y=1000&img_format=jpg&img_quality=90&return_typ=app&zeit_von=1374524430017");
	
								Web.post(new Runnable() {
						                public void run() {
										Web.loadDataWithBaseURL("fake://fake.de", s, "text/html", "UTF-8", null);
										Log.i("Debug Request", s);
						                 }
						             });

							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				}).start();
				
				
			}
		});
	}
	
}
