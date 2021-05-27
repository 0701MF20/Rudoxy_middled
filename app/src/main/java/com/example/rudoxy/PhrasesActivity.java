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
public class PhrasesActivity extends AppCompatActivity {
   private MediaPlayer mp5;
   private AudioManager am2l;
   private AudioManager.OnAudioFocusChangeListener audiofocuslistener2l=new AudioManager.OnAudioFocusChangeListener() {
       @Override
       public void onAudioFocusChange(int focusChange) {
           if(focusChange==AudioManager.AUDIOFOCUS_LOSS)
           {
              ReleaseResources();
           }
           else if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK||focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT)
           {
             mp5.pause();
             mp5.seekTo(0);
           }
           else if(focusChange==AudioManager.AUDIOFOCUS_GAIN)
           {
               mp5.start();
           }
       }
   };
   public void ReleaseResources()
   {
       if(mp5!=null)
       {
           mp5.release();
           mp5=null;
           am2l.abandonAudioFocus(audiofocuslistener2l);
       }
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        am2l=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
        final ArrayList<Word> phrase=new ArrayList<Word>();
        phrase.add(new Word("Where are you going?", "minto wuksus","Tum kha jaa rhe ho",R.raw.phrase_where_are_you_going));
        phrase.add(new Word("What is your name?", "tinnә oyaase'nә","Tumhaara naam kya hai",R.raw.phrase_where_are_you_going));
        phrase.add(new Word("My name is...", "oyaaset...","Mera naam hai ...",R.raw.phrase_my_name_is));
        phrase.add(new Word("How are you feeling?", "michәksәs?","Kesa mehsoos kar rhe ho tum",R.raw.phrase_how_are_you_feeling));
        phrase.add(new Word("I’m feeling good.", "kuchi achit","Main acha mehsoos kar rha hu",R.raw.phrase_im_feeling_good));
        phrase.add(new Word("Are you coming?", "әәnәs'aa?","Kya tum aa rhe ho",R.raw.phrase_are_you_coming));
        phrase.add(new Word("Yes, I’m coming.", "hәә’ әәnәm","ha, main aa rha hoon",R.raw.phrase_yes_im_coming));
        phrase.add(new Word("I’m coming.", "әәnәm","Main aa rha hoon",R.raw.phrase_im_coming));
        phrase.add(new Word("Let’s go.", "yoowutis","Chalo chaalte hain",R.raw.phrase_lets_go));
        phrase.add(new Word("Come here.", "әnni'nem","Idhar aao",R.raw.phrase_come_here));
        NumberAdapter na=new NumberAdapter(this,phrase,R.color.phrases_color);
        ListView LN=(ListView)findViewById(R.id.phraseId);
        LN.setAdapter(na);
        LN.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ReleaseResources();
                Word w5 = phrase.get(position);
                int result2 = am2l.requestAudioFocus(audiofocuslistener2l, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                int Audio4=w5.getmResorceAudio();
                if (result2 == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mp5=MediaPlayer.create(PhrasesActivity.this, Audio4);
                    mp5.start();
                    mp5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            ReleaseResources();
                        }
                    });
                /* if(mp5.isPlaying())
                {
                    mp5.pause();
                }
                else
                {
                    mp5.start();
                }*/
                }
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        mp5.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mp5.start();
    }

   /* @Override
    protected void onDestroy() {
        super.onDestroy();
        mp5.pause();
        ReleaseResources();
    }*/
}















//previous code----------------***********************--------------------------------------------------------------------

/*



package com.example.rudoxy;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        ArrayList<Word> phrase=new ArrayList<Word>();
        phrase.add(new Word("Where are you going?", "minto wuksus","Tum kha jaa rhe ho"));
        phrase.add(new Word("What is your name?", "tinnә oyaase'nә","Tumhaara naam kya hai"));
        phrase.add(new Word("My name is...", "oyaaset...","Mera naam hai ..."));
        phrase.add(new Word("How are you feeling?", "michәksәs?","Kesa mehsoos kar rhe ho tum"));
        phrase.add(new Word("I’m feeling good.", "kuchi achit","Main acha mehsoos kar rha hu"));
        phrase.add(new Word("Are you coming?", "әәnәs'aa?","Kya tum aa rhe ho"));
        phrase.add(new Word("Yes, I’m coming.", "hәә’ әәnәm","ha, main aa rha hoon"));
        phrase.add(new Word("I’m coming.", "әәnәm","Main aa rha hoon"));
        phrase.add(new Word("Let’s go.", "yoowutis","Chalo chaalte hain"));
        phrase.add(new Word("Come here.", "әnni'nem","Idhar aao"));
   //    NumberAdapter na=new NumberAdapter(this,phrase);
        NumberAdapter na=new NumberAdapter(this,phrase,R.color.phrases_color);
        ListView LN=(ListView)findViewById(R.id.phraseId);
        LN.setAdapter(na);
    }
}

*/