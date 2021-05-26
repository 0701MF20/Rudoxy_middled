package com.example.rudoxy;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import static com.example.rudoxy.R.*;
public class NumberActivity extends AppCompatActivity
{
    private MediaPlayer mp4;
    private AudioManager am4;
    private AudioManager.OnAudioFocusChangeListener audioFocusListener4=new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT||focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                mp4.pause();
            }
            else if(focusChange==AudioManager.AUDIOFOCUS_GAIN||focusChange==AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)
            {
                mp4.start();
            }
            else if(focusChange==AudioManager.AUDIOFOCUS_LOSS)
            {
               ResourceRelease();
            }
        }
    };
    public void ResourceRelease()
    {
        if(mp4!=null)
        {
            mp4.release();
            mp4=null;
           am4.abandonAudioFocus(audioFocusListener4);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstantState)
    {
        super.onCreate(savedInstantState);
        setContentView(layout.activity_number);
        am4=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> numberi= new ArrayList<>();
        Word W1=new Word("One","Lutti","Ek", drawable.number_one, raw.number_one);
        numberi.add(W1);
        numberi.add(new Word("Two","Otiiko","Do", drawable.number_two, raw.number_two));
        numberi.add(new Word("Three","Tolockosu","Teen", drawable.number_three, raw.number_three));
        numberi.add(new Word("Four","oyyiss","Chaar", drawable.number_four, raw.number_four));
        numberi.add(new Word("Five","Massoka","Paanch", drawable.number_five, raw.number_five));
        numberi.add(new Word("Six","Temmokka","Cheeh", drawable.number_six, raw.number_six));
        numberi.add(new Word("Seven","Kenakaku","Saat", drawable.number_seven, raw.number_seven));
        numberi.add(new Word("Eight","Kawinta","Aath", drawable.number_eight, raw.number_eight));
        numberi.add(new Word("Nine","SomethingPart1","Nau", drawable.number_nine, raw.number_nine));
        numberi.add(new Word("Ten","SomethingPart2","Dus", drawable.number_ten, raw.number_ten));
       NumberAdapter nic=new NumberAdapter(this,numberi, color.number_color);
        ListView L2=(ListView)findViewById(id.numberActivityId);
        L2.setAdapter(nic);
        L2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Word w4=numberi.get(position);
               int Audio4=w4.getmResorceAudio();
               int result4=am4.requestAudioFocus(audioFocusListener4,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
               if(result4==AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
               {
                   ResourceRelease();
                   mp4=MediaPlayer.create(NumberActivity.this, Audio4);
                   mp4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                       @Override
                       public void onCompletion(MediaPlayer mp) {
                           ResourceRelease();
                       }
                   });
                   /*if(mp4.isPlaying())
               {
                   mp4.pause();
               }
               else
               {
                   mp4.start();
               }*/
               }
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mp4.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mp4.pause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp4.stop();
        ResourceRelease();
    }

}








///previous code-------------------*********************_----------------------------------------------------------

/*
package com.example.rudoxy;
        import androidx.appcompat.app.AppCompatActivity;

        import android.media.MediaPlayer;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import java.util.ArrayList;

        import static com.example.rudoxy.R.*;

public class NumberActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstantState)
    {
        super.onCreate(savedInstantState);
        setContentView(layout.activity_number);
        ArrayList<Word> numberi= new ArrayList<>();
        Word W1=new Word("One","Lutti","Ek", drawable.number_one);
        numberi.add(W1);
        numberi.add(new Word("Two","Otiiko","Do", drawable.number_two));
        numberi.add(new Word("Three","Tolockosu","Teen", drawable.number_three));
        numberi.add(new Word("Four","oyyiss","Chaar", drawable.number_four));
        numberi.add(new Word("Five","Massoka","Paanch", drawable.number_five));
        numberi.add(new Word("Six","Temmokka","Cheeh", drawable.number_six));
        numberi.add(new Word("Seven","Kenakaku","Saat", drawable.number_seven));
        numberi.add(new Word("Eight","Kawinta","Aath", drawable.number_eight));
        numberi.add(new Word("Nine","SomethingPart1","Nau", drawable.number_nine));
        numberi.add(new Word("Ten","SomethingPart2","Dus", drawable.number_ten));
        MediaPlayer mp=MediaPlayer.create(this, raw.number_one);


        //prev1-----

        NumberAdapter nic=new NumberAdapter(this,numberi, color.number_color);
        ListView L2=(ListView)findViewById(id.numberActivityId);
        L2.setAdapter(nic);
        L2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mp!=null)
                {
                    if(mp.isPlaying())
                    {
                        mp.pause();
                    }
                    else
                    {
                        mp.start();
                    }
                }

            }
        });
    }
}*/
//////contiue prev 1
 /*Word W1=new Word("One","Lutti","Ek",);
        numberi.add(W1);
        numberi.add(new Word("Two","Otiiko","Do"));
        numberi.add(new Word("Three","Tolockosu","Teen"));
        numberi.add(new Word("Four","oyyiss","Chaar"));
        numberi.add(new Word("Five","Massoka","Paanch"));
        numberi.add(new Word("Six","Temmokka","Cheeh"));
        numberi.add(new Word("Seven","Kenakaku","Saat"));
        numberi.add(new Word("Eight","Kawinta","Aath"));
        numberi.add(new Word("Nine","SomethingPart1","Nau"));
        numberi.add(new Word("Ten","SomethingPart2","Dus"));*/
//NumberAdapter nic=new NumberAdapter(this,numberi);