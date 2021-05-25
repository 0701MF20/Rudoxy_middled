package com.example.rudoxy;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ColorActivity extends AppCompatActivity
{
    private MediaPlayer mp1;
    public void ResourceRelease()
    {
        mp1.release();
        mp1=null;
    }
    @Override
    protected void onCreate(Bundle savedInstantState)
    {

        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_color);//
        //PREV 1 AND THEN PREV 2
        ArrayList<Word> ami=new ArrayList<Word>();
        ami.add(new Word("Red", "Weṭeṭṭi","Laal",R.drawable.color_red,R.raw.color_red));
        ami.add(new Word("Mustard yellow", "Chiwiiṭә","Peela",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        ami.add(new Word("Dusty yellow", "Topiisә","Peela",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        ami.add(new Word("Green", "Chokokki","Haraa",R.drawable.color_green,R.raw.color_green));
        ami.add(new Word("Brown", "Takaakki","Bhura(Brown)",R.drawable.color_brown,R.raw.color_brown));
        ami.add(new Word("Gray", "Topoppi","Bhura(Grey)",R.drawable.color_gray,R.raw.color_gray));
        ami.add(new Word("Black","Kululli","Kaala",R.drawable.color_black,R.raw.color_black));
        ami.add(new Word("White","Kelelli","Safed",R.drawable.color_white,R.raw.color_white));
        NumberAdapter n1=new NumberAdapter(this,ami,R.color.Color_color);
        ListView L1=(ListView)findViewById(R.id.colorId);
        L1.setAdapter(n1);
        L1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ResourceRelease();
                Word w1=ami.get(position);
                int Audio1=w1.getmResorceAudio();
                mp1=MediaPlayer.create(ColorActivity.this,Audio1);
             /*   if(mp1.isPlaying())
                {
                    mp1.pause();
                }
                else
                {
                    mp1.start();
                }
                */
                mp1.start();
                mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                 @Override
                 public void onCompletion(MediaPlayer mp) {
                     mp.release();
                     mp=null;
                 }
             });
            }
        });
    }
}
//CONTINUE PREV 1
/* String []colors=new String[10];
        colors[0]="Red";
        colors[1]="Mustard Yellow";
        colors[2]="Dusty Yellow";
        colors[3]="Green";
        colors[4]="Grey";
        colors[5]="Brown";
        colors[6]="Black";
        colors[7]="White";
        Log.v("ColorActivity","Word index: "+colors[0]);
        Log.v("ColorActivity","Word index: "+colors[1]);
        Log.v("ColorActivity","Word index: "+colors[2]);
        Log.v("ColorActivity","Word index: "+colors[3]);
        Log.v("ColorActivity","Word index: "+colors[4]);
        Log.v("ColorActivity","Word index: "+colors[5]);
        Log.v("ColorActivity","Word index: "+colors[6]);
        Log.v("ColorActivity","Word index: "+colors[7]);*/
//  System.out.println("Word : "+colors[0]);
       /* LinearLayout colorLayout=(LinearLayout)findViewById(R.id.colorLinearLayout);
        TextView t1=new TextView(this);
        t1.setText(colors.length);
        colorLayout.addView(t1);*/
//PREV2 JUST AFTER PREV 1
/*ArrayList<Word> ami=new ArrayList<Word>();
        ami.add(new Word("Red", "Weṭeṭṭi","Laal",R.drawable.color_red));
                ami.add(new Word("Mustard yellow", "Chiwiiṭә","Peela",R.drawable.color_mustard_yellow));
                ami.add(new Word("Dusty yellow", "Topiisә","Peela",R.drawable.color_dusty_yellow));
                ami.add(new Word("Green", "Chokokki","Haraa",R.drawable.color_green));
                ami.add(new Word("Brown", "Takaakki","Bhura(Brown)",R.drawable.color_brown));
                ami.add(new Word("Gray", "Topoppi","Bhura(Grey)",R.drawable.color_gray));
                ami.add(new Word("Black","Kululli","Kaala",R.drawable.color_black));
                ami.add(new Word("White","Kelelli","Safed",R.drawable.color_white));
                // NumberAdapter nc=new NumberAdapter(this,ami);
                NumberAdapter nc=new NumberAdapter(this,ami,R.color.Color_color);
                ListView lhg=(ListView)findViewById(R.id.colorId);
                lhg.setAdapter(nc);*/