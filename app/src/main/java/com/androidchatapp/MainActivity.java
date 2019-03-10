package com.androidchatapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Toolbar mToolbar;
    ListView mListView;


    String[] User = {"PATIENT", "DOCTOR", "PHARMACIST","HEALTH CARE CENTER", "ADMIN","NEAR HOSPITAL","VIDEOS"," NEAR BY HEALTH CARE CENTERS","TALK WITH BOT"};
    int[] User_icon = {R.drawable.patient,
            R.drawable.images,
            R.drawable.chemist,
            R.drawable.healthcenter,
            R.drawable.admin,
            R.drawable.hospital,
            R.drawable.videos,
            R.drawable.heathcare,
            R.drawable.bot
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting Custom ArrayAdapter adapter with list view//

        mListView = (ListView) findViewById(R.id.listview);

        MyAdapter myAdapter = new MyAdapter(MainActivity.this, User, User_icon);
        mListView.setAdapter(myAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //for patient//
                if(i==0) {
                    startActivity( new Intent( MainActivity.this,Patient_login.class ) );
                }

                //for doctor//
                if(i==1) {
                    startActivity( new Intent( MainActivity.this,Doctor_login.class ));
                }

                //for pharmacist//
                if(i==2) {
                    startActivity(new Intent( MainActivity.this,Pharmacist_login.class ));
                }
                //Health Care Centers
                if(i==3){
                    startActivity(new Intent( MainActivity.this,Health_Login.class ));

                }

                //for Admin//
                if(i==4) {
                    startActivity( new Intent( MainActivity.this,admin_login.class ) );

                }
                if(i==5) {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("https://www.google.com/maps/search/hospital+near+sagar+institute+of+technology/@26.9225272,81.1892248,14z/data=!3m1!4b1"));
                    startActivity(intent);



                }

                if(i==6) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=health+treatment+in+hindi")));

                }


                if(i==7) {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("https://www.google.com/maps/search/near+health+care+center/@23.2759203,77.4629838,13.58z"));
                    startActivity(intent);



                }

                //for Admin//
                if(i==8) {
                    startActivity( new Intent( MainActivity.this,Bot.class ) );

                }


            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.example_menu,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ((item.getItemId())){
              case R.id.abouUs_id:
                startActivity( new Intent( MainActivity.this,About_us.class ) );
              return  true;

            case R.id.feedback_id:
                startActivity( new Intent( MainActivity.this,Feedback.class ) );
                return  true;
        }
        return super.onOptionsItemSelected( item );
    }






}
