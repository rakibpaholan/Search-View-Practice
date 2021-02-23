package com.example.searchviewonactionbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private AlertDialog.Builder alert;
    private String [] country_name;
    private ArrayAdapter arrayAdapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.list_view_id);

        country_name = getResources().getStringArray(R.array.country_information);

        arrayAdapter = new ArrayAdapter(MainActivity.this,R.layout.list_view_source,R.id.source_view_id,country_name);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String country_name = (String) arrayAdapter.getItem(i);
        Toast.makeText(getApplicationContext(),country_name,Toast.LENGTH_SHORT).show();
    }






















    @Override
    public void onBackPressed() {
        alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Warning");
        alert.setMessage("Are You Sure");
        alert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alert.create().show();
    }


}