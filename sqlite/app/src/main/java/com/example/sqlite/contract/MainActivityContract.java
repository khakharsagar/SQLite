package com.example.sqlite.contract;

import android.content.Context;
import com.example.sqlite.database.Contact;
import java.util.List;

public interface MainActivityContract {
  interface Model{

    void initModel();

    List<Contact> getContactList();
  }

  interface View {
    Context getContext();

    void setAdapter();
  }

  interface Presenter{

    void initPresenter();

    Context getContext();

    List<Contact> getContactList();

    void dataLoaded();
  }
}
