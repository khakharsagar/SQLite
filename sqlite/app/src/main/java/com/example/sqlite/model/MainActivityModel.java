package com.example.sqlite.model;

import android.util.Log;
import com.example.sqlite.contract.MainActivityContract;
import com.example.sqlite.contract.MainActivityContract.Presenter;
import com.example.sqlite.database.Contact;
import com.example.sqlite.database.DatabaseHandler;
import java.util.List;

/**
 * Created by sagarkhakhar on 22/11/17.
 */

public class MainActivityModel implements MainActivityContract.Model {

  private MainActivityContract.Presenter mPresenter;

  public MainActivityModel(Presenter presenter) {
    mPresenter = presenter;
  }

  @Override
  public void initModel() {
    DatabaseHandler db = new DatabaseHandler(mPresenter.getContext());

    db.deleteAllData();
    /**
     * CRUD Operations
     * */
    // Inserting Contacts
    Log.d("Insert: ", "Inserting ..");
    for (int i=1; i<=100;i++){
      db.addContact(new Contact("Sagar "+i, Integer.toString(i)));
    }
    Log.d("Insert: ", "Finished inserting ..\n");

    // Reading all contacts
    Log.d("Reading: ", "Reading all contacts..");
    List<Contact> contacts = db.getAllContacts();

    for (Contact cn : contacts) {
      String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
      // Writing Contacts to log
      Log.d("Name: ", log);
    }

    mPresenter.dataLoaded();

  }

  @Override
  public List<Contact> getContactList() {
    DatabaseHandler db = new DatabaseHandler(mPresenter.getContext());
    return db.getAllContacts();
  }
}
