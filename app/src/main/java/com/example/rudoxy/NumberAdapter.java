package com.example.rudoxy;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
public class NumberAdapter extends ArrayAdapter<Word>
{
     private int mColorResourceId;//COLOR
     public NumberAdapter(Context context,ArrayList<Word> inosWord,int ColorResourceId)
    {
        super(context,0,inosWord);
        mColorResourceId=ColorResourceId;
    }
 /*   public NumberAdapter(Context context, ArrayList<Word> inosWord)
    {
        super(context,0,inosWord);
    }*/
    @Override
    public View getView(int position,View convertView,ViewGroup parent)
    {
        View listItemViews=convertView;
        if(listItemViews==null)
        {
            listItemViews= LayoutInflater.from(getContext()).inflate(R.layout.number_item_layout_view,parent,false);
        }
        Word m1=(Word)getItem(position);
        TextView eng_word=(TextView)listItemViews.findViewById(R.id.engWordId);
        eng_word.setText(m1.getmEnglishWord());
        TextView miwok_word=(TextView)listItemViews.findViewById(R.id.miwokWordId);
        miwok_word.setText(m1.getmMiwokWord());
        TextView hin_word=(TextView)listItemViews.findViewById(R.id.hindiWordId);
        hin_word.setText(m1.getmHindiWord());
        ImageView iv2 = (ImageView) listItemViews.findViewById(R.id.imageIdView);
        if(m1.hasImage())
        {
            iv2.setImageResource(m1.getmResourceId());
            iv2.setVisibility(View.VISIBLE);
        }
        else
        {
           iv2.setVisibility(View.GONE);
           // iv2.setVisibility(View.INVISIBLE);
        }
        View textViewSubPart=listItemViews.findViewById(R.id.numberLayoutSubPartId);

        int color= ContextCompat.getColor(getContext(),mColorResourceId);
        textViewSubPart.setBackgroundColor(color);
        /*TextView num_word=(TextView)listItemViews.findViewById(R.id.nosWordId);
        num_word.setText(m1.getNosWord());*/
        return listItemViews;
    }
}

