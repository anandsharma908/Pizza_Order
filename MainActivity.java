package com.example.anand.pizza;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void order(View v)
    {
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
       // ad.setIcon(R.drawable.pizza);
        ad.setTitle("Veg or Non-Veg");
        String item[]= {"Select", "Veg", "Non-veg"};
        Spinner spinner= new Spinner(this);
        ArrayAdapter aa = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, item);
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        startActivity(new Intent(MainActivity.this, VegActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, NonVegActivity.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        ad.setCancelable(false);
        ad.setView(spinner);
        ad.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        ad.show();
    }
    public void track(View v)
    {

    }
}
