package com.androidchatapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Bot extends AppCompatActivity {

    TextView  BotRply;
    Button send_qes_boT;

    EditText   botmsgContent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bot );

        BotRply=findViewById( R.id.Bot_text );

        send_qes_boT= findViewById( R.id.send_QES_BOT );

        botmsgContent=findViewById( R.id.messageArea );






        send_qes_boT.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String  msg = botmsgContent.getText().toString().trim();


                String[] splitStr =msg.split( "\\s+" );
                for(String i:msg.split("\\s",0)){

                    if(i.equals("hi")||i.equals("Hi")||i.equals("Hello")||i.equals("hello")){
                           String s="Hi, I am Niruj, How are you";
                        BotRply.setText(s);
                    }
                    if(i.equals("नमस्कार")){
                        String s="नमस्कार, मैं निरुज, आप कैसे हैं";
                        BotRply.setText(s);
                    }
                    ProgressDialog pd=new ProgressDialog(Bot.this);
                    pd.setMessage("Bot is typing");
                    pd.show();
                    if(i.equals("Sick")||i.equals("sick")){
                        String s1="Here are some no. of Doctors\n Dr.Sabyasachi Gupta (Contact No.- 9303135795)\n  Dr.Upendra Jain (Conatct No.-7552680345)";                                                     BotRply.setText(s1);
                    }
                    if(i.equals("बीमार")){
                        String s2= "यहां डॉक्टर्स के कुछ फोन नंबर हैं \n डॉ सब्यसाची गुप्ता (संपर्क नंबर- 9303135795) \n डॉ उपेंद्र जैन (संपर्क नंबर -7552680345) ";
                        BotRply.setText(s2);
                    }
                    
                    pd.dismiss();



                }



            }
        } );




    }



}
