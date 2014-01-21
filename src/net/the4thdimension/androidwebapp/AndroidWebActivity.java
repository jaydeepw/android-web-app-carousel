package net.the4thdimension.androidwebapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class AndroidWebActivity extends Activity {
	
	String TAG = "AndroidWebApp";
	
	private Context mContext;
	
	WebView mWebView;
	LinearLayout mLayout;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mContext = this;

        // Lookup R.layout.main
        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
		
        mWebView = new WebView(AndroidWebActivity.this);
        mWebView.setWebViewClient(new myWebViewClient());
        mWebView.loadUrl( CommonUtils.PATH_ASSESTS_WWW + "index.html");
        mWebView.setLayoutParams(mLayout.getLayoutParams());
        mWebView.setScrollBarStyle(WebView.SCROLLBARS_INSIDE_OVERLAY);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mLayout.addView(mWebView); 
    }
    
    private void showProgressDialog() {
		LinearLayout progressBarLinLayout = (LinearLayout) mLayout.findViewById(R.id.webview_progress_bar_linlayout);
		
		progressBarLinLayout.setVisibility( View.VISIBLE );
	}
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	if ( keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack() ) {
            mWebView.goBack();
            return true;
        }
        
        return super.onKeyDown(keyCode, event);
    }
	
	private void hideProgressDialog(){
		LinearLayout progressBarLinLayout = (LinearLayout) mLayout.findViewById(R.id.webview_progress_bar_linlayout);
		
		progressBarLinLayout.setVisibility( View.GONE );
	}
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 3, 3, "Exit");
		return true;
	}
	  
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
	  
		  switch (item.getItemId()) {
				
			case 3:
					this.finish();
					break;
		
			default:
					break;
		}
	  	
        return true;
    }
  
  private class myWebViewClient extends WebViewClient {
      
      @Override
      public void onPageStarted(WebView view, String url, Bitmap favicon) {
    	  showProgressDialog();
      } 

      @Override 
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
          view.loadUrl(url);
          return true; 
      }

      @Override
      public void onPageFinished (WebView view, String url) {
    	  hideProgressDialog(); 
      }
  }
}