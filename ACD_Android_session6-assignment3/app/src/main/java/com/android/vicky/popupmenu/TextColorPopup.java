package com.android.vicky.popupmenu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class TextColorPopup extends AppCompatActivity {
    TextView txtViewActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_color_popup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        txtViewActivity = (TextView)findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_text_color_popup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_text) {
            View menuItemView = findViewById(R.id.action_text);
            PopupMenu popTextColor = new PopupMenu(TextColorPopup.this,menuItemView);
            popTextColor.getMenuInflater().inflate(R.menu.popup_menu_item, popTextColor.getMenu());
            popTextColor.show();
            popTextColor.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(TextColorPopup.this,"You Click On : "+item.getTitle(),Toast.LENGTH_SHORT).show();
                    String colorOption = item.getTitle().toString();
                    switch (colorOption){
                        case "Red" :        txtViewActivity.setTextColor(getResources().getColor(R.color.colorRed));
                                            break;
                        case "Green" :      txtViewActivity.setTextColor(getResources().getColor(R.color.colorGreen));
                                            break;
                        case "Blue" :       txtViewActivity.setTextColor(getResources().getColor(R.color.colorBlue));
                                            break;
                    }
                    return true;
                }
            });
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
