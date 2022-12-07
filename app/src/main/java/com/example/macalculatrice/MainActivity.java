package com.example.macalculatrice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner mySpinner;
    EditText ecran;
    final List<String> options = new ArrayList<>();
    double a, b, result;
    String Op = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySpinner = findViewById(R.id.mySpinner);
        ecran =  findViewById(R.id.ecran);
        options.add("Standard");
        options.add("Scientifique");
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, options ) ;
        mySpinner.setAdapter(adapter);
        mySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, options.get(i), Toast.LENGTH_SHORT).show();
        if(i == 0)
        {
            Button btnPercent = (Button) findViewById(R.id.btnPercent);
            Button btnRad = (Button) findViewById(R.id.btnRad);
            Button btnE = (Button) findViewById(R.id.btnE);
            Button btnRac = (Button) findViewById(R.id.btnRac);
            Button btnPower = (Button) findViewById(R.id.btnPower);
            Button btnLn = (Button) findViewById(R.id.btnLn);
            Button btnLog = (Button) findViewById(R.id.btnLog);
            Button btnFact = (Button) findViewById(R.id.btnFact);
            Button btnTan = (Button) findViewById(R.id.btnTan);
            Button btnSin = (Button) findViewById(R.id.btnSin);
            Button btnCos = (Button) findViewById(R.id.btnCos);

            btnPercent.setVisibility(View.GONE);
            btnRad.setVisibility(View.GONE);
            btnE.setVisibility(View.GONE);
            btnRac.setVisibility(View.GONE);
            btnPower.setVisibility(View.GONE);
            btnLn.setVisibility(View.GONE);
            btnLog.setVisibility(View.GONE);
            btnFact.setVisibility(View.GONE);
            btnTan.setVisibility(View.GONE);
            btnSin.setVisibility(View.GONE);
            btnCos.setVisibility(View.GONE);
        }
        if(i == 1)
        {
            Button btnPercent = (Button) findViewById(R.id.btnPercent);
            Button btnRad = (Button) findViewById(R.id.btnRad);
            Button btnE = (Button) findViewById(R.id.btnE);
            Button btnRac = (Button) findViewById(R.id.btnRac);
            Button btnPower = (Button) findViewById(R.id.btnPower);
            Button btnLn = (Button) findViewById(R.id.btnLn);
            Button btnLog = (Button) findViewById(R.id.btnLog);
            Button btnFact = (Button) findViewById(R.id.btnFact);
            Button btnTan = (Button) findViewById(R.id.btnTan);
            Button btnSin = (Button) findViewById(R.id.btnSin);
            Button btnCos = (Button) findViewById(R.id.btnCos);

            btnPercent.setVisibility(View.VISIBLE);
            btnRad.setVisibility(View.VISIBLE);
            btnE.setVisibility(View.VISIBLE);
            btnRac.setVisibility(View.VISIBLE);
            btnPower.setVisibility(View.VISIBLE);
            btnLn.setVisibility(View.VISIBLE);
            btnLog.setVisibility(View.VISIBLE);
            btnFact.setVisibility(View.VISIBLE);
            btnTan.setVisibility(View.VISIBLE);
            btnSin.setVisibility(View.VISIBLE);
            btnCos.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void chiffre(View view) {
        String chf = view.getTag().toString();
        String txtEcran = ecran.getText().toString();
        if(txtEcran.equals("NaN") || txtEcran.equals("0") || txtEcran.equals(".")  )
            txtEcran="";
        txtEcran += chf;
        ecran.setText(txtEcran);
    }

    public void operation(View view) {
        Button btn = (Button) view;
        String ecranTxt = ecran.getText().toString();
        try {
            a = Double.valueOf(ecranTxt);
        }
        catch (NumberFormatException e) {
            ecran.setText(e.getMessage());
        }
        ecran.setText("");
        Op = btn.getText().toString();
    }

    public void equal(View view) {
        String txtEcran = ecran.getText().toString();
        try {
            if(!txtEcran.isEmpty()) {
                b = Double.valueOf(txtEcran);
            }
            else {
                ecran.setText(" ");
            }

            Log.i("test", "OP = "+ Op);
            switch (Op)
            {
                case "+" :
                    result = a + b;
                    break;
                case "-" :
                    result = a - b;
                    break;
                case "÷" :
                    result = b==0? Double.NaN : a / b;
                    break;
                case "X" :
                    result =  a * b;
                    break;
                case "Xⁿ":
                    result = Math.pow(a, b);
                    break;
                case "log":
                    result = Math.log10(b);
                    break;
                case "ln":
                    result = Math.log(b);
                    break;

                case "√":
                    result = Math.sqrt(b);
                    break;
                case "!":
                    int i = (int)a  - 1;
                    while (i > 0)
                    {
                        a = a * i;
                        i--;
                    }
                    result = a ;
                    break;
                case "sin":
                    result = Math.sin(b);
                    break;
                case "cos":
                    result = Math.cos(b);
                    break;
                case "tan":
                    result = Math.tan(b);
                    break;
                case "%" :
                    result = a / 100;
                    break;
                case "Rad" :
                    result = Math.toRadians(b);
                    break;
                case "e" :
                    result = Math.exp(b);
                    break;
            }
            ecran.setText(Double.toString(result));
        }
        catch (NumberFormatException e) {
            ecran.setText(e.getMessage());
        }
    }

    public void delete(View view) {
        ecran.setText(ecran.getText().subSequence(0, ecran.getText().length() - 1));
    }

    public void point(View view) {
        String ecranTxt = ecran.getText().toString();
        if(ecranTxt.equals("NaN") || ecranTxt.equals(".")  || ecranTxt.contains(".") )
            ecranTxt="";
        ecranTxt += ".";
        ecran.setText(ecranTxt);
    }
    public void clear(View view) {
        ecran.setText("");
    }
}