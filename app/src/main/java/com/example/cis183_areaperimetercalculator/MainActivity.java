package com.example.cis183_areaperimetercalculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> spinnerAdapter;
    EditText et_main_length;
    EditText et_main_width;
    EditText et_main_radius;
    EditText et_main_height;
    EditText et_main_base;
    EditText et_main_side1;
    EditText et_main_side2;
    EditText et_main_side3;
    ConstraintLayout cont_main_squareRectangle;
    ConstraintLayout cont_main_circle;
    ConstraintLayout cont_main_triangle;
    Spinner sp_main_shapes;
    TextView tv_main_areaPerimeter;
    TextView tv_main_areaPerimeterCircle;
    TextView tv_main_areaPerimeterTriangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        et_main_length = findViewById(R.id.et_main_length);
        et_main_width = findViewById(R.id.et_main_width);
        et_main_radius = findViewById(R.id.et_main_radius);

        et_main_height = findViewById(R.id.et_main_height);
        et_main_base = findViewById(R.id.et_main_base);
        et_main_side1 = findViewById(R.id.et_main_side1);
        et_main_side2 = findViewById(R.id.et_main_side2);
        et_main_side3 = findViewById(R.id.et_main_side3);

        cont_main_squareRectangle = findViewById(R.id.cont_main_squareRectangle);
        cont_main_circle = findViewById(R.id.cont_main_circle);
        cont_main_triangle = findViewById(R.id.cont_main_triangle);
        sp_main_shapes = findViewById(R.id.sp_main_shapes);
        tv_main_areaPerimeter = findViewById(R.id.tv_main_areaPerimeter);
        tv_main_areaPerimeterCircle = findViewById(R.id.tv_main_areaPerimeterCircle);
        tv_main_areaPerimeterTriangle = findViewById(R.id.tv_main_areaPerimeterTriangle);

        String[] shapes = new String[]{"Square","Rectangle","Circle","Triangle"};

        spinnerAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,shapes);
        sp_main_shapes.setAdapter(spinnerAdapter);


        setupSpinnerChangeListener();
        textChangeListenerSquareRect();
        textChangeListenerCircle();
        textChangeListenerTriangle();
    }


    public void setupSpinnerChangeListener() {
        sp_main_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) { //square
                    cont_main_squareRectangle.setVisibility(View.VISIBLE);
                    hideConstraintView(cont_main_circle);
                    hideConstraintView(cont_main_triangle);
                }
                else if (position == 1) { //rectangle
                    cont_main_squareRectangle.setVisibility(View.VISIBLE);
                    hideConstraintView(cont_main_circle);
                    hideConstraintView(cont_main_triangle);
                }
                else if (position == 2) { //circle
                    hideConstraintView(cont_main_squareRectangle);
                    cont_main_circle.setVisibility(View.VISIBLE);
                    hideConstraintView(cont_main_triangle);
                }
                else if (position == 3) { //triangle
                    hideConstraintView(cont_main_squareRectangle);
                    hideConstraintView(cont_main_circle);
                    cont_main_triangle.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void hideConstraintView(ConstraintLayout cl) {
        cl.setVisibility(View.INVISIBLE);
    }

    public void textChangeListenerSquareRect() {
        et_main_width.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaAndPerimeter(et_main_length.getText().toString(),et_main_width.getText().toString());
            }
        });
        et_main_length.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaAndPerimeter(et_main_length.getText().toString(),et_main_width.getText().toString());
            }
        });
    }
    public void textChangeListenerCircle() {
        et_main_radius.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setRadius(et_main_radius.getText().toString());
            }
        });
    }
    public void textChangeListenerTriangle() {
        et_main_height.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaAndPerimeterTriangle(et_main_height.getText().toString(),et_main_base.getText().toString(),et_main_side1.getText().toString(),et_main_side2.getText().toString(),et_main_side3.getText().toString());
            }
        });
        et_main_side1.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaAndPerimeterTriangle(et_main_height.getText().toString(),et_main_base.getText().toString(),et_main_side1.getText().toString(),et_main_side2.getText().toString(),et_main_side3.getText().toString());
            }
        });
        et_main_side2.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaAndPerimeterTriangle(et_main_height.getText().toString(),et_main_base.getText().toString(),et_main_side1.getText().toString(),et_main_side2.getText().toString(),et_main_side3.getText().toString());
            }
        });
        et_main_side3.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setAreaAndPerimeterTriangle(et_main_height.getText().toString(),et_main_base.getText().toString(),et_main_side1.getText().toString(),et_main_side2.getText().toString(),et_main_side3.getText().toString());
            }
        });
    }

    public void setAreaAndPerimeter(String str_length, String str_width) {

        if (str_length.isEmpty() || str_width.isEmpty()) { return; }


        double length = Double.parseDouble(str_length);
        double width = Double.parseDouble(str_width);

        double area = length * width;
        double perimeter = 2*(length+width);

        String str_output = ("Area: "+area+"  Perimeter: "+perimeter);

        tv_main_areaPerimeter.setText(str_output);
    }

    public void setRadius(String str_radius) {

        if (str_radius.isEmpty()) { return; }
        double radius = Double.parseDouble(str_radius);
        double area = 3.14*Math.pow(radius,2);
        double circumference = radius*2*3.14;
        String str_output = ("Area: "+area+"  Circumference: "+circumference);
        tv_main_areaPerimeterCircle.setText(str_output);
    }


    public void setAreaAndPerimeterTriangle(String str_height,String str_base, String str_side1, String str_side2, String str_side3) {
        if (str_height.isEmpty() || str_base.isEmpty() || str_side1.isEmpty() || str_side2.isEmpty() || str_side3.isEmpty()) { return; }
        double height = Double.parseDouble(str_height);
        double base = Double.parseDouble(str_base);
        double side1 = Double.parseDouble(str_side1);
        double side2 = Double.parseDouble(str_side2);
        double side3 = Double.parseDouble(str_side3);

        double area = (height*base)/2;
        double perimeter = side1+side2+side3;
        String str_output = ("Area: "+area+"  Perimeter: "+perimeter);
        tv_main_areaPerimeterTriangle.setText(str_output);

    }
}