package com.example.ashutosh_pc.scribble;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class noting_space extends AppCompatActivity {
    ImageButton Save;
    ImageButton Delete;
    EditText titledescrip;
    EditText contentdescrip;
    Intent i;
    int pos = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noting_elements);
        Save = findViewById(R.id.save);
        Delete = findViewById(R.id.delete);
        titledescrip = findViewById(R.id.title_name);
        contentdescrip = findViewById(R.id.conent_text);
        final String currenttime = DateFormat.getDateTimeInstance().format(new Date());
        i = getIntent();

        if (i.hasExtra("KEY")){
            TextActivity textActivity = i.getParcelableExtra("KEY");
            titledescrip.setText(textActivity.getHeadtext());
            contentdescrip.setText(textActivity.getDescription());

            pos = i.getIntExtra("POS",0);
        }
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextActivity CurrentElement = new TextActivity(titledescrip.getText().toString(), currenttime, contentdescrip.getText().toString());
                MainActivity.ListItems.add(CurrentElement);
                Toast.makeText(getBaseContext(), "Item Added", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.ListItems.remove(pos);
                Toast.makeText(getBaseContext(), "Item Deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });



    }
}
