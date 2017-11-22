package com.example.sqlite.presenter;

import android.content.Context;
import com.example.sqlite.contract.MainActivityContract;
import com.example.sqlite.contract.MainActivityContract.View;
import com.example.sqlite.database.Contact;
import com.example.sqlite.model.MainActivityModel;
import java.util.List;

public class MainActivityPresenter implements MainActivityContract.Presenter {

  private MainActivityContract.View mView;
  private MainActivityContract.Model mModel;

  public MainActivityPresenter(View view) {
    mView = view;
    mModel = new MainActivityModel(this);
  }

  @Override
  public void initPresenter() {
    mModel.initModel();
  }

  @Override
  public Context getContext() {
    return mView.getContext();
  }

  @Override
  public List<Contact> getContactList() {
    return mModel.getContactList();
  }

  @Override
  public void dataLoaded() {
    mView.setAdapter();
  }
}
