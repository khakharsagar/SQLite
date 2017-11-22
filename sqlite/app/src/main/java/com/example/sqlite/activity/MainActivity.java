package com.example.sqlite.activity;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.sqlite.adapter.MoviesAdapter;
import com.example.sqlite.contract.MainActivityContract;
import com.example.sqlite.database.Contact;
import com.example.sqlite.database.DatabaseHandler;
import com.example.sqlite.R;
import com.example.sqlite.presenter.MainActivityPresenter;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity implements MainActivityContract.View {

  private MainActivityContract.Presenter mPresenter;
  private RecyclerView mRecyclerView;
  private MoviesAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

    mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    mRecyclerView.setLayoutManager(mLayoutManager);
    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mPresenter = new MainActivityPresenter(this);
		mPresenter.initPresenter();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

  @Override
  public Context getContext() {
    return this;
  }

  @Override
  public void setAdapter() {
    mAdapter = new MoviesAdapter(mPresenter.getContactList());
    mRecyclerView.setAdapter(mAdapter);
  }
}
