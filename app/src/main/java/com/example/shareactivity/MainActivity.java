package com.example.shareactivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String myColor=null;
    int myInt=0;

    Button btn;
    CheckBox chk1, chk2, chk3;
    EditText txt;
    TextView textView;
    View l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        chk1 = findViewById(R.id.checkBox1);
        chk2 = findViewById(R.id.checkBox2);
        chk3 = findViewById(R.id.checkBox3);
        txt = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView);
        l = findViewById(R.id.lay);
        CheckPreferences();

        if(myColor=="blue") {
            View view = this.getWindow().getDecorView();
            view.setBackgroundColor(Color.BLUE);
//            getWindow().getDecorView().setBackgroundColor(Color.BLUE);
//            l.setBackgroundColor(Color.BLUE);
        }
        else if(myColor=="red") {
            getWindow().getDecorView().setBackgroundColor(Color.RED);
        }
        else if(myColor=="green") {
            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        }

        if (myInt!=0){
            textView.setText(myInt+"");
        }
    }

    private void CheckPreferences() {

        SharedPreferences spref = getSharedPreferences("MY_COOL_APP", MODE_PRIVATE);
        myColor= spref.getString("forColor",null);
        myInt = spref.getInt("forNum",0);

        Log.e("dfds", myInt +"|"+myColor);
    }

    public void saveStuff(View v){
        int x = Integer.valueOf(txt.getText().toString());
        Log.e("0000", x +"|");
        String s=null;
        if(chk1.isChecked()){s="blue";}
        else if(chk2.isChecked()){s="red";}
        else if(chk3.isChecked()){s="green";}


        SharedPreferences spref = getSharedPreferences("MY_COOL_APP", MODE_PRIVATE);
        SharedPreferences.Editor editor = spref.edit();
        editor.putInt("forNum",x);
        editor.putString("forColor", s);
        editor.apply();
    }

  /* //removing value
       editor.remove("KeyValue ToBe Deleted");
       editor.apply();
   //Delete all saved Values
       editor.clear();
       editor.apply();*/

}