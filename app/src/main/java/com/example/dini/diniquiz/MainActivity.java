package com.example.dini.diniquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_button=(Button)findViewById(R.id.button);

        final EditText name_text=(EditText)findViewById(R.id.editTextPersonName);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_text.getText().toString();
                Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
                intent.putExtra("myname",name);
                startActivity(intent);
            }
        });

    }
}