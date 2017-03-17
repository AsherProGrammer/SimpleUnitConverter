package com.example.asher.simpleunitconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.asher.simpleunitconverter.R.string.git;

public class MainActivity extends AppCompatActivity {
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init spinner for types
        Spinner spinner_type = (Spinner) findViewById(R.id.spinner_type);
        final Spinner spinner_1 = (Spinner) findViewById(R.id.spinner_1);
        final Spinner spinner_2 = (Spinner) findViewById(R.id.spinner_2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.types, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_1 = ArrayAdapter.createFromResource(this, R.array.Area, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_2 = ArrayAdapter.createFromResource(this, R.array.Area, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_type.setAdapter(adapter);
        spinner_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        type,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
       //init two spinners, call helper
        type = (String) spinner_type.getSelectedItem();
        switch(type) {
            case "Area":
                adapter_1 = ArrayAdapter.createFromResource(this, R.array.Area, android.R.layout.simple_spinner_item);
                adapter_2 = ArrayAdapter.createFromResource(this, R.array.Area, android.R.layout.simple_spinner_item);
                break;
            case "Length":
                adapter_1 = ArrayAdapter.createFromResource(this, R.array.Length, android.R.layout.simple_spinner_item);;
                adapter_2 = ArrayAdapter.createFromResource(this, R.array.Length, android.R.layout.simple_spinner_item);;
                break;
            case "Mass":
                adapter_1 = ArrayAdapter.createFromResource(this, R.array.Mass, android.R.layout.simple_spinner_item);;
                adapter_2 = ArrayAdapter.createFromResource(this, R.array.Mass, android.R.layout.simple_spinner_item);;
                break;
            case "Speed":
                adapter_1 = ArrayAdapter.createFromResource(this, R.array.Speed, android.R.layout.simple_spinner_item);;
                adapter_2 = ArrayAdapter.createFromResource(this, R.array.Speed, android.R.layout.simple_spinner_item);;
                break;
            case "Temperature":
                adapter_1 = ArrayAdapter.createFromResource(this, R.array.Temperature, android.R.layout.simple_spinner_item);;
                adapter_2 = ArrayAdapter.createFromResource(this, R.array.Temperature, android.R.layout.simple_spinner_item);;
                break;
            case "Volume":
                adapter_1 = ArrayAdapter.createFromResource(this, R.array.Volume, android.R.layout.simple_spinner_item);;
                adapter_2 = ArrayAdapter.createFromResource(this, R.array.Volume, android.R.layout.simple_spinner_item);;
                break;
            default:
                break;
        }
        adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_1.setAdapter(adapter_1);
        spinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_2.setAdapter(adapter_1);
        spinner_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //process edittext

        Button convertion = (Button) findViewById(R.id.button_convert);
        convertion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_1 = (EditText) findViewById(R.id.editText_1);
                TextView tv_2 = (TextView) findViewById(R.id.textView_2);
                double v1 = Double.valueOf(et_1.getText().toString());
                double v2 =0;
                switch(type) {
                    case "Area":
                       switch ((String) spinner_1.getSelectedItem()){
                           case "Square mile":
                               v2 = ((String) spinner_2.getSelectedItem()).equals("Square mile") ? v1 : v1*2.58999;
                               break;
                           case "Square kilometer":
                               v2 = ((String) spinner_2.getSelectedItem()).equals("Square kilometer") ? v1 : v1*0.386102;
                               break;
                       }
                       break;
                    case "Length":
                        switch ((String) spinner_1.getSelectedItem()) {
                            case "Mile":
                                v2 = ((String) spinner_2.getSelectedItem()).equals("Mile") ? v1 : v1 * 1.60934;
                                break;
                            case "Kilometer":
                                v2 = ((String) spinner_2.getSelectedItem()).equals("Kilometer") ? v1 : v1 * 0.621371;
                                break;
                        }
                        break;
                    case "Mass":
                        switch ((String) spinner_1.getSelectedItem()) {
                            case "Pound":
                                v2 = ((String) spinner_2.getSelectedItem()).equals("Pound") ? v1 : v1 * 0.453592;
                                break;
                            case "Kilogram":
                                v2 = ((String) spinner_2.getSelectedItem()).equals("Kilogram") ? v1 : v1 * 2.20462;
                                break;
                        }
                        break;
                    case "Speed":
                        switch ((String) spinner_1.getSelectedItem()) {
                            case "MPH":
                                v2 = ((String) spinner_2.getSelectedItem()).equals("MPH") ? v1 : v1 * 1.60934;
                                break;
                            case "KPH":
                                v2 = ((String) spinner_2.getSelectedItem()).equals("KPH") ? v1 : v1 * 0.621371;
                                break;
                        }
                        break;
                    case "Temperature":
                        switch ((String) spinner_1.getSelectedItem()) {
                            case "Fahrenheit":
                                v2 = ((String) spinner_2.getSelectedItem()).equals("Fahrenheit") ? v1 : (v1-32)/1.8;
                                break;
                            case "Celsius":
                                v2 = ((String) spinner_2.getSelectedItem()).equals("Celsius") ? v1 : v1*1.8+32;
                                break;
                        }
                        break;
                    case "Volume":
                        switch ((String) spinner_1.getSelectedItem()) {
                            case "Gallon":
                                v2 = ((String) spinner_2.getSelectedItem()).equals("Gallon") ? v1 : v1 * 3.78541;
                                break;
                            case "Liter":
                                v2 = ((String) spinner_2.getSelectedItem()).equals("Liter") ? v1 : v1 * 0.2641721;
                                break;
                        }
                        break;
                    default:
                        break;
                }
                java.text.DecimalFormat df = new java.text.DecimalFormat("##.##");
                tv_2.setText(df.format(v2));
            }
        });
        //init textview for hyperlink
        TextView git = (TextView) findViewById(R.id.textView);
        git.setMovementMethod(LinkMovementMethod.getInstance());
    }

        //init button for feedback
        public void rateApp(View v){
            Intent goToRate = new Intent();
            goToRate.setClass(this,rate.class);
            startActivity(goToRate);
            finish();
        }

}
