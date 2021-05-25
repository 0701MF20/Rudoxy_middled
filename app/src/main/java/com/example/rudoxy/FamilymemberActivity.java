/*package com.example.rudoxy;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilymemberActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstantstate)
    {
        super.onCreate(savedInstantstate);
        setContentView(R.layout.activity_familymember);
        ArrayList<Word> fm=new ArrayList<Word>();
        fm.add(new Word("Father", "әpә","Pita",R.drawable.family_father));
        fm.add(new Word("Mother", "әṭa","Maa",R.drawable.family_mother));
        fm.add(new Word("Son", "angsi","Beta",R.drawable.family_son));
        fm.add(new Word("Daughter", "tune","Beti",R.drawable.family_daughter));
        fm.add(new Word("Older brother", "taachi","Bada bhai",R.drawable.family_older_sister));
        fm.add(new Word("Younger brother", "chalitti","Chota",R.drawable.family_younger_brother));
        fm.add(new Word("Older sister", "teṭe","Badi behen",R.drawable.family_older_sister));
        fm.add(new Word("Younger sister", "kolliti","Choti behen",R.drawable.family_younger_sister));
        fm.add(new Word("Grandmother ", "ama","Daadi",R.drawable.family_grandmother));
        fm.add(new Word("Grandfather", "paapa","Daada",R.drawable.family_grandfather));
       // NumberAdapter fma=new NumberAdapter(this,fm);
        NumberAdapter fma=new NumberAdapter(this,fm,R.color.family_color);
        ListView lth=(ListView)findViewById(R.id.familymemberId);
        lth.setAdapter(fma);
    }
}*/
package com.example.rudoxy;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilymemberActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstantstate)
    {
        super.onCreate(savedInstantstate);
        setContentView(R.layout.activity_familymember);
        ArrayList<Word> fm=new ArrayList<Word>();
        fm.add(new Word("Father", "әpә","Pita",R.drawable.family_father,R.raw.family_father));
        fm.add(new Word("Mother", "әṭa","Maa",R.drawable.family_mother,R.raw.family_mother));
        fm.add(new Word("Son", "angsi","Beta",R.drawable.family_son,R.raw.family_son));
        fm.add(new Word("Daughter", "tune","Beti",R.drawable.family_daughter,R.raw.family_daughter));
        fm.add(new Word("Older brother", "taachi","Bada bhai",R.drawable.family_older_sister,R.raw.family_older_brother));
        fm.add(new Word("Younger brother", "chalitti","Chota",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        fm.add(new Word("Older sister", "teṭe","Badi behen",R.drawable.family_older_sister,R.raw.family_older_sister));
        fm.add(new Word("Younger sister", "kolliti","Choti behen",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        fm.add(new Word("Grandmother ", "ama","Daadi",R.drawable.family_grandmother,R.raw.family_grandmother));
        fm.add(new Word("Grandfather", "paapa","Daada",R.drawable.family_grandfather,R.raw.family_grandfather));
        // NumberAdapter fma=new NumberAdapter(this,fm);
        NumberAdapter fma=new NumberAdapter(this,fm,R.color.family_color);
        ListView lth=(ListView)findViewById(R.id.familymemberId);
        lth.setAdapter(fma);
        lth.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word w3 = fm.get(position);
                int Audio = w3.getmResorceAudio();
                MediaPlayer mp3 = MediaPlayer.create(FamilymemberActivity.this, Audio);
                if (mp3.isPlaying()) {
                    mp3.pause();
                } else {
                    mp3.start();
                }
            }
        });
    }
}
