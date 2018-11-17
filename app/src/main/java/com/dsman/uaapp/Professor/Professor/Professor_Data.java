package com.dsman.uaapp.Professor.Professor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dsman.uaapp.R;

public class Professor_Data extends AppCompatActivity{
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_data);

        btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
}
    private void openDialog() {
        Professor_FragmentDialog cfd = new Professor_FragmentDialog();
        cfd.show(getSupportFragmentManager(), "example");
    }
}