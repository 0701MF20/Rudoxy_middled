package com.example.rudoxy;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
//import java.util.List;
//commit 2
public class ColorActivity extends AppCompatActivity
{
    private MediaPlayer mp1;
    private AudioManager am1;
    private AudioManager.OnAudioFocusChangeListener audiofocuslisteners=new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mp1.pause();
                mp1.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mp1.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                ResourceRelease();
            }
        }
    };
    public void ResourceRelease()
    {
        if(mp1!=null) {
            mp1.release();
            mp1 = null;
            am1.abandonAudioFocus(audiofocuslisteners);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstantState)
    {

        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_color);//
        //PREV 1 AND THEN PREV 2
        am1=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> ami=new ArrayList<Word>();
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
                Word w1 = ami.get(position);
                int Audio1 = w1.getmResorceAudio();
                int result = am1.requestAudioFocus(audiofocuslisteners, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {
                    mp1=MediaPlayer.create(ColorActivity.this, Audio1);
                mp1.start();
                mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        ResourceRelease();
                    }
                });
            }
            }
        });

        //Audio manager instance------**********************--------------------------
    }
    @Override
    protected void onPause() {
        super.onPause();
        mp1.pause();
    }
   @Override
    protected void onStop() {
        super.onStop();
        mp1.stop();
        mp1.seekTo(0);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mp1.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp1.pause();
        ResourceRelease();
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