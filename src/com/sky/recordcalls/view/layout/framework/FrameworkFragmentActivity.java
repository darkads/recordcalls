package com.sky.recordcalls.view.layout.framework;
//
//import android.app.Activity;
//import android.os.Bundle;
//import com.actionbarsherlock.app.ActionBar;
//import com.actionbarsherlock.app.SherlockFragmentActivity;
//import com.actionbarsherlock.view.MenuItem;
//import com.record.my.call.controller.n;
//
//public class FrameworkFragmentActivity extends SherlockFragmentActivity
//{
//  protected boolean d;
//  protected Activity e;
//  protected ActionBar f;
//
//  protected void onCreate(Bundle paramBundle)
//  {
//    setTheme(2131492948);
//    super.onCreate(paramBundle);
//    this.d = true;
//    this.e = this;
//    this.f = getSupportActionBar();
//    this.f.setDisplayHomeAsUpEnabled(true);
//  }
//
//  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
//  {
//    boolean bool = true;
//    if (paramMenuItem.getTitle().equals(getString(2131558525)))
//      n.a(this.e);
//    while (true)
//    {
//      return bool;
//      switch (paramMenuItem.getItemId())
//      {
//      default:
//        bool = super.onOptionsItemSelected(paramMenuItem);
//        break;
//      case 16908332:
//        finish();
//      }
//    }
//  }
//
//  protected void onSaveInstanceState(Bundle paramBundle)
//  {
//    super.onSaveInstanceState(paramBundle);
//    paramBundle.putString("outState", "outState");
//  }
//
//  protected void onStart()
//  {
//    super.onStart();
//  }
//
//  protected void onStop()
//  {
//    super.onStop();
//  }
//}
//
///* Location:           C:\Users\Sky\Desktop\RecordMyCalls\RecordMyCalls.jar
// * Qualified Name:     com.record.my.call.view.layout.framework.FrameworkFragmentActivity
// * JD-Core Version:    0.6.2
// */