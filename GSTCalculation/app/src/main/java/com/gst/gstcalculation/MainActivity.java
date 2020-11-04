package com.gst.gstcalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView etgstamount, ettotalamount;
    EditText etamount, etgstpercent;
    RadioButton cbincludegst, cbexcludegst;
    Button btnresult, btnreset;
//    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etamount = findViewById(R.id.et_amount);
        etgstpercent = findViewById(R.id.et_gst_percent);
        etgstamount = findViewById(R.id.et_gst_amount);
        ettotalamount = findViewById(R.id.et_total_amount);
        cbincludegst = findViewById(R.id.cb_include_gst);
        cbexcludegst = findViewById(R.id.cb_exclude_gst);
        btnresult = findViewById(R.id.btn_result);
        btnreset = findViewById(R.id.btn_reset);
//        radioGroup = findViewById(R.id.radio_group);
//        btnresultinclude = findViewById(R.id.btn_resultinclude);



        btnresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbincludegst.isChecked()){
                    float total= Float.parseFloat(etamount.getText().toString());
                    float gst_percent= Float.parseFloat(etgstpercent.getText().toString());
                    float gst_amount= ( total -( total * (100 / ( 100 + gst_percent))) );
                    etgstamount.setText("GST = " + gst_amount );

                    float total_amount= total - gst_amount;
                    ettotalamount.setText( "Total = " + total_amount);

                    InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);

                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);


                }  else if (cbexcludegst.isChecked()){
                    float total= Float.parseFloat(etamount.getText().toString());
                    float gst_percent= Float.parseFloat(etgstpercent.getText().toString());
                    float gst_amount= ( total * gst_percent / 100);
                    etgstamount.setText("GST = " + gst_amount);

                    float total_amount= total + gst_amount;
                    ettotalamount.setText( "Total = " + total_amount);

                    InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);

                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);



                } else {
                    float total= Float.parseFloat(etamount.getText().toString());
                    float gst_percent= Float.parseFloat(etgstpercent.getText().toString());
                    float gst_amount= ( gst_percent );
                    etgstamount.setText("Error");

                    float total_amount= total;
                    ettotalamount.setText( "Error");

                    InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);

                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);

                }
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etamount.setText("");
                etgstpercent.setText("");
                etgstamount.setText("");
                ettotalamount.setText("");
                etamount.requestFocus();

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(etamount, InputMethodManager.SHOW_IMPLICIT);

            }
        });

        etamount.addTextChangedListener(loginTextWatcher);
        etgstpercent.addTextChangedListener(loginTextWatcher);
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String gstamountInput = etamount.getText().toString().trim();
            String gstpercentInput = etgstpercent.getText().toString().trim();

            btnresult.setEnabled(!gstamountInput.isEmpty() && !gstpercentInput.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}