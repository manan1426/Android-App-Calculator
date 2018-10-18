package com.example.hp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView display=null;
    TextView smallDisplay=null;
    int digit;
    long number,lastNum,result=0;
    String lastop="=";
    Boolean justNumPressed=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=(TextView)findViewById(R.id.largeDisplay);
        smallDisplay=(TextView)findViewById(R.id.smallDisplay);
        }
    public void numberPressed(View v){

        Button b=(Button) v;
        digit=Integer.parseInt(b.getText().toString());
        number=Long.parseLong(display.getText().toString());
        number=number*10 +digit;
        justNumPressed=true;
        display.setText(String.valueOf(number));
    }
    public void operation(View v){
        Button b=(Button) v;
        String op=b.getText().toString();
        lastNum = Long.parseLong(display.getText().toString());
        clear(null);
        result=calculate(result,lastNum,lastop);
        smallDisplay.setText(String.valueOf(result)+op);
        if(op.equals("=")){
            display.setText(String.valueOf(result));
            lastNum=0;
            result=0;
        }
        lastop=op;
        justNumPressed=false;
    }
    public long calculate(long result,long lastNum,String op){
        if(op.equals("+")){
            return result+lastNum;
        }else if(op.equals("-")){
            return  result-lastNum;
        }else if(op.equals("x")){
            if(justNumPressed) {
                return result * lastNum;
            }return result;
        }else if(op.equals("/")){
            if (justNumPressed) {
                return result / lastNum;
            }return result;
        }else if(op.equals("^2")){
            if(justNumPressed) {
                return lastNum * lastNum;
            }return result;
        }
        return lastNum;
    }
    public void clear(View v){
        display.setText("0");
    }
}
