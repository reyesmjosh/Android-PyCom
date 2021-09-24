package com.python.pycom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView outPut = findViewById(R.id.output);
        EditText codeArea = findViewById(R.id.codearea);
        Button runButton = findViewById(R.id.run);

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Python py = Python.getInstance();
                PyObject pyObject = py.getModule("script");
                PyObject obj = pyObject.callAttr("main",codeArea.getText().toString());
                outPut.setText(obj.toString());

            }
        });



    }
}