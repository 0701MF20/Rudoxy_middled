package com.example.rudoxy;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
//import org.w3c.dom.Text;
//import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView colorText=(TextView)findViewById(R.id.colorTextViewId);
        colorText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorIntent=new Intent(MainActivity.this,ColorActivity.class);
                startActivity(colorIntent);
            }
        });
        TextView phraseText=(TextView)findViewById(R.id.phraseTextViewId);
        phraseText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent PhraseIntent=new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(PhraseIntent);
                return true;
            }
        });
      /*  TextView Number2TextView=(TextView)findViewById(R.id.number2TextViewId);
        Number2TextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numberiintent=new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(numberiintent);
            }
        });*/
        TextView FamilyMembTextView=(TextView)findViewById(R.id.familyTextViewId);
        FamilyMembTextView.setOnClickListener(this);
        TextView num=(TextView)findViewById(R.id.numberTextViewId);
        num.setOnClickListener(new OnClickListener() {                 //ANAMOLOUS CLASS THAT'S MEANS WE ARE ACTUALLY CREATING A CLAS  FOR ONLY ONE TIME OF USE WHICH DOES NOT HAVE ANY NAME WE ARE ACTUALLY CREATING THE OBJECT FOR ONE TIME USE
            @Override
            public void onClick(View v) {
                Intent numberIntent=new Intent(MainActivity.this,NumberActivity.class);
                startActivity(numberIntent);
            }
        });
    }
    public void onClick(View view)
    {
        Intent familyIntent=new Intent(MainActivity.this,FamilymemberActivity.class);
        startActivity(familyIntent);
    }
   /* public void colormethod(View view)//intent code
    {
        Intent cintent=new Intent(this,ColorActivity.class);
        startActivity(cintent);

    }
    public void familymembermethod(View view)
    {
        Intent fintent=new Intent(this,FamilymemberActivity.class);
        startActivity(fintent);
    }
    public void numbermethod(View view)
    {
        Intent nintent=new Intent(this,NumberActivity.class);
        startActivity(nintent);
    }
    public void phrasesmethod(View view)
    {
        Intent pintent=new Intent(this,PhrasesActivity.class);
        startActivity(pintent);
    }*/
}
