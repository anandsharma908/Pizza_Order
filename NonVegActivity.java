package com.example.anand.pizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;


public class NonVegActivity extends Activity
{
    CheckBox checkBox[]= new CheckBox[10];
    int price[] = {79, 89, 79, 130, 120, 110, 120, 109, 112, 95};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.non_veg_layout);
        checkBox[0]= (CheckBox)findViewById(R.id.checkBox);
        checkBox[1]= (CheckBox)findViewById(R.id.checkBox2);
        checkBox[2]= (CheckBox)findViewById(R.id.checkBox3);
        checkBox[3]= (CheckBox)findViewById(R.id.checkBox4);
        checkBox[4]= (CheckBox)findViewById(R.id.checkBox5);
        checkBox[5]= (CheckBox)findViewById(R.id.checkBox6);
        checkBox[6]= (CheckBox)findViewById(R.id.checkBox7);
        checkBox[7]= (CheckBox)findViewById(R.id.checkBox8);
        checkBox[8]= (CheckBox)findViewById(R.id.checkBox9);
        checkBox[9]= (CheckBox)findViewById(R.id.checkBox10);
    }
    public void cancelPage(View v)
    {
        startActivity(new Intent(this, MainActivity.class));
    }
    public void orderPizza(View v)
    {
        String va = "value";
        String n= "name";
        int c = 0;
        int total= 0;
        String name[] = {"NON VEGGIE MAGIC SOLO : Chicken Keema",
                "NON VEGGIE MAGIC SOLO : Chunks of Chicken",
                "NON VEGGIE MAGIC SOLO : Kadai Chicken",
                "NON VEGGIE MAGIC DUO : Kadai Chicken and Green Chillies",
                "NON VEGGIE MAGIC DUO : Chunks of Chicken and Green Capsicum",
                "NON VEGGIE MAGIC DUO : Kadai Chicken and Green Chillies",
                "NON VEGGIE MAGIC DUO : Chicken Hot N Spicy",
                "NON VEGGIE MAGIC DUO :Chunks of Chicken and Green Capsicum",
                "NON VEGGIE MAGIC DUO : Chunks of Chicken and Tomato",
                "NON VEGGIE MAGIC DUO : Chicken Keema & Corn."};
        Intent in = new Intent(this, OrderedActivity.class);
        for (int i=0; i<checkBox.length; i++)
        {
               if(checkBox[i].isChecked())
               {
                   total += price[i];
                   in.putExtra(va+c, price[i]);
                   in.putExtra(n+c, name[i]);
                   c++;
               }
        }
        in.putExtra("total", total);
        in.putExtra("count", c);
        startActivity(in);
    }
}
