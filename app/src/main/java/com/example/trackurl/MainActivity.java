package com.afzal.trackurl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.example.trackurl.R;

public class MainActivity extends AppCompatActivity {

    EditText Et1;
    Button btn;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Et1 = (EditText)findViewById(R.id.et1);
        btn = (Button)findViewById(R.id.button);
        tv = (TextView)findViewById(R.id.t_v);


        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));

        Python py = Python.getInstance();
        final PyObject pyobj = py.getModule("url");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PyObject obj = pyobj.callAttr("main",Et1.getText());
                tv.setText(obj.toString());

            }
        });

    }
}