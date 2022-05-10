package com.example.unlimitedApp.tools.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.utility.BaseActivity;

public class MainActivity extends BaseActivity {

    TextView workingsTV;
    TextView resultsTV;
    String workings="";
    String formula="";
    String tempFormula="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_calculator_activity_main);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            setSupportActionBar(myToolbar);
        }
        initTextViews();
    }

    private void initTextViews()
    {
        workingsTV =(TextView) findViewById(R.id.WorkingsTextView);
        resultsTV =(TextView) findViewById(R.id.resultTextView);
    }
    private void setWorkings(String givenValue){
        workings=workings +givenValue;
        workingsTV.setText(workings);
    }

    public void clearOnClick(View view)
    {
        workingsTV.setText("");
        workings="";
        resultsTV.setText("");
        leftBracket=true;
    }

    public void powerOfClick(View view)
    {
        setWorkings("^");
    }
    boolean leftBracket =true;
    public void breaktsOnClick(View view)
    {
        if (leftBracket){
            setWorkings("(");
            leftBracket=false;
        }
        else
        {
            setWorkings(")");
            leftBracket=true;
        }
    }

    public void divisionOnClick(View view)
    {
        setWorkings("/");
    }

    public void sevenOnClick(View view)
    {
        setWorkings("7");
    }

    public void eightOnClick(View view)
    {
        setWorkings("8");
    }

    public void nineOnClick(View view)
    {
        setWorkings("9");
    }

    public void timesOnClick(View view)
    {
        setWorkings("*");
    }

    public void fourOnClick(View view)
    {
        setWorkings("4");
    }

    public void fiveOnClick(View view)
    {
        setWorkings("5");
    }

    public void sixOnClick(View view)
    {
        setWorkings("6");
    }

    public void minusOnClick(View view)
    {
        setWorkings("-");
    }

    public void oneOnclick(View view)
    {
        setWorkings("1");
    }

    public void twoOnClick(View view)
    {
        setWorkings("2");
    }

    public void threeOnClick(View view)
    {
        setWorkings("3");
    }

    public void plusOnClick(View view)
    {
        setWorkings("+");
    }

    public void decimalOnClick(View view)
    {
        setWorkings(".");
    }

    public void zeroOnClick(View view)
    {
        setWorkings("0");
    }

    public void equalOnClick(View view)
    {
          //todo:need to coding from zero
//        Double result =null;
//        ScriptEngine engine =new ScriptEngineManager().getEngineByName("rhino");
//        checkForPowerOf();
//        try {
//            result =(double)engine.eval(formula);
//        }catch (ScriptException e){
//            Toast.makeText(this,"Invalid Input",Toast.LENGTH_SHORT).show();
//        }
//        if (result!=null)
//            resultsTV.setText(String.valueOf(result.doubleValue()));
    }

    private void checkForPowerOf()
    {
        ArrayList<Integer>indexOfPower =new ArrayList<>();
        for (int i=0;i<workings.length();i++)
        {
            if(workings.charAt(i)=='^')
                indexOfPower.add(i);
        }
        formula=workings;
        tempFormula=workings;
        for (Integer index :indexOfPower)
        {
            changeFormula(index);
        }
        formula =tempFormula;
    }

    private void changeFormula(Integer index)
    {
        String numberLeft="";
        String numberRight="";
        for (int i=index + 1; i<workings.length();i++){
            if (isNumeric(workings.charAt(i)))
                numberRight=numberRight+workings.charAt(i);
            else
                break;
        }
        for (int i=index - 1; i>=0;i--){
            if (isNumeric(workings.charAt(i)))
                numberLeft=numberLeft+workings.charAt(i);
            else
                break;
        }
        String original=numberLeft+'^'+numberRight;
        String changed="Math.pow("+numberLeft+","+numberRight+")";
        tempFormula=tempFormula.replace(original,changed);
    }
    private boolean isNumeric(char c)
    {
        return c <= '9' && c >= '0' || c == '.';
    }
}