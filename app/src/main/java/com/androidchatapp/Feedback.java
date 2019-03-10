package com.androidchatapp;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    EditText etMessage;
    int My_PERMISSION_REQUEST_SEND_SMS=1;
    String SENT ="SENT_SMS";
    String DELIVERED="DELIVERED_SMS";
    PendingIntent sentPI,deliveredPI;
    BroadcastReceiver smsSentReciver,smsDeliverReciever;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_feedback );

        etMessage =(EditText)findViewById(R.id.etMessage);
        sentPI = PendingIntent.getBroadcast( this,0,new Intent( SENT ),0 );
        deliveredPI=PendingIntent.getBroadcast( this,0,new Intent( DELIVERED ),0 );

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        smsSentReciver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText( Feedback.this,"SMS sent",Toast.LENGTH_SHORT ).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        Toast.makeText( Feedback.this,"Generic Failure!",Toast.LENGTH_SHORT ).show();
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText( Feedback.this,"NO service!",Toast.LENGTH_SHORT ).show();
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText( Feedback.this,"Null PDU!",Toast.LENGTH_SHORT ).show();
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText( Feedback.this,"Radio off!",Toast.LENGTH_SHORT ).show();
                        break;
                }


            }
        };

        smsDeliverReciever =new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                switch (getResultCode()){

                    case Activity.RESULT_OK:
                        Toast.makeText( Feedback.this,"SMS Delivered",Toast.LENGTH_SHORT ).show();
                        break;
                    case Activity.RESULT_CANCELED:
                        Toast.makeText( Feedback.this,"SMS not Delivered",Toast.LENGTH_SHORT ).show();
                        break;

                }

            }
        };
        registerReceiver( smsSentReciver,new IntentFilter( SENT ) );
        registerReceiver( smsDeliverReciever,new IntentFilter( DELIVERED ) );
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver( smsDeliverReciever );
        unregisterReceiver( smsSentReciver );
    }

    public void btn_SendSMS_OnClick(View v){

        String message =etMessage.getText().toString();
        String telNr ="9532880230";
        if(ContextCompat.checkSelfPermission( this, Manifest.permission.SEND_SMS )!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions( this,new String[]{Manifest.permission.SEND_SMS},My_PERMISSION_REQUEST_SEND_SMS );
        }
        else {
            SmsManager sms =SmsManager.getDefault();
            sms.sendTextMessage( telNr,null,message,sentPI,deliveredPI );
        }
    }
}
