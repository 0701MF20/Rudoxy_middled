package com.example.rudoxy;

public class Word
{
    private static final int NO_IMAGE_FOUND=-1;
    private int mResourceId=NO_IMAGE_FOUND;
    private final int NO_AUDIO_FOUND=-1;
    private int mResourceAudio=NO_AUDIO_FOUND;
    private final String mEnglishWord;
    private final String mMiwokWord;
    private final String mHindiWord;
    //for
    public Word(String EnglishWord,String MiwokWord,String HindiWord,int ResourceId,int ResourceAudioId)
    {
        mResourceId=ResourceId;
        mEnglishWord = EnglishWord;
        mMiwokWord=MiwokWord;
        mHindiWord=HindiWord;
        mResourceAudio=ResourceAudioId;
    }
    public Word(String EnglishWord,String MiwokWord,String HindiWord,int ResourceAudioId)
    {
        mResourceAudio=ResourceAudioId;
        mEnglishWord = EnglishWord;
        mMiwokWord=MiwokWord;
        mHindiWord=HindiWord;
    }

    public Word(String EnglishWord,String MiwokWord,String HindiWord)
    {
        mEnglishWord = EnglishWord;
        mMiwokWord=MiwokWord;
        mHindiWord=HindiWord;
    }
    /* public int getNosWord()
     {
         return mNosWord;
     }
         <TextView
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         android:paddingStart="16dp"
         android:id="@+id/nosWordId"
         android:paddingBottom="16dp"
         tools:ignore="RtlSymmetry" />
         */
    public int getmResourceId()
    {
        return mResourceId;
    }
    public String getmEnglishWord()
    {
        return mEnglishWord;
    }
    public String getmMiwokWord()
    {
        return mMiwokWord;
    }
    public  String getmHindiWord()
    {
        return  mHindiWord;
    }
    public boolean hasImage()
    {
        return mResourceId!=NO_IMAGE_FOUND;
    }
    public int getmResorceAudio()
    {
        return mResourceAudio;
    }
    public boolean hasAudio()
    {
        return mResourceAudio!=NO_AUDIO_FOUND;
    }

}
