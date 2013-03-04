package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This class represent the main activity of a tip calculator application 
 * @author Chaim
 *
 */
public class TipCalculatorActivity extends Activity {
	public static final double TIP_PERCENT = 0.12;
	boolean _round=false;
	double _bill=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        
        // round? check box
        final CheckBox cb = (CheckBox)findViewById(R.id.chkRound);
        cb.setOnCheckedChangeListener(
          new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				_round=!_round;
			}
          });
        
        // result text
        final TextView tv= (TextView)findViewById(R.id.txtTipResult);
        
        // input text
        final EditText et = (EditText)findViewById(R.id.edtBillAmount);
        
        // make the calculation! button
        final Button b = (Button)findViewById(R.id.btnCalculate);
        b.setOnClickListener(
          new OnClickListener() {
            public void onClick(View v) {
            	String temp=et.getText().toString();
            	if (!temp.equals("")){
            		_bill=Double.parseDouble(temp);
            	}
            	if (_round){
            	   tv.setText("$"+(int)Math.round(TIP_PERCENT*_bill));
               }
               else {
            	   tv.setText("$"+String.format("%.2f", TIP_PERCENT*_bill));
               }
            }
          });

    }
    
}
