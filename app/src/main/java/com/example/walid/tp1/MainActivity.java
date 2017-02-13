package com.example.walid.tp1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private int value=0;
     EditText text;
    Button inc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText)findViewById(R.id.text);
        text.setText(""+value);
        inc = (Button)findViewById(R.id.btn);
        inc.setOnClickListener(new OnClickListener());
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        value++;
        outState.putInt("value", value);
        Toast.makeText(this,"Sauvegarde!", Toast.LENGTH_LONG).show();
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        value = savedInstanceState.getInt("value");
        text.setText(""+value);
        Toast.makeText(this,"Restauration!", Toast.LENGTH_LONG).show();

    }
    public void incrementer() {
        text.setText(""+value);
    }
    private class OnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            value++;
            incrementer();
        }
    }
}
