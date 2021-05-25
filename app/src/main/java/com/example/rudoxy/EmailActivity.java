package com.example.rudoxy;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EmailActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstantState)
    {
        super.onCreate(savedInstantState);
        setContentView(R.layout.activity_email);
    }
    public void update(View view)
    {
        EditText namesd=(EditText)findViewById(R.id.name_id);
        String namel=namesd.getText().toString();
        EditText messaged=(EditText)findViewById(R.id.message_id);
        String messagel=messaged.getText().toString();
        Intent emailii=new Intent(Intent.ACTION_SENDTO);
        emailii.setData(Uri.parse("mailto:"));
        emailii.putExtra(Intent.EXTRA_EMAIL,new String[]{"farazjanuary@gmail.com"});
        emailii.putExtra(Intent.EXTRA_SUBJECT,"Java");
        emailii.putExtra(Intent.EXTRA_TEXT,messagel);
    }
}
