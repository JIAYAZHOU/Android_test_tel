package com.example.bodadianhua;

import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	private EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText = (EditText)MainActivity.this.findViewById(R.id.editText1);
		
		Button button1=(Button)findViewById(R.id.button1);
		//button1.setOnClickListener(new mylisener());
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				callphone();
			}
		});
	
	}
	
	
	
//	private class mylisener implements OnClickListener{
//
//		@Override
//		public void onClick(View v) {
//			
//			callphone();
//			
//			
//		}

		private void callphone() {
			String num = editText.getText().toString().trim();//去掉空格
			
			if (TextUtils.isEmpty(num)) {
				
				Toast.makeText(MainActivity.this, "号码不能为空", 0).show();;
				
			}
			else
			{Intent intent = new Intent();
			intent.setAction(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:"+num));
			
			startActivity(intent);}
		}

	
//	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
