package com.example.expjobschedular;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnStart, btnStop;
    JobScheduler JS;
public static  final  int JOB_ID=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    btnStart=findViewById(R.id.btnStart);
        btnStop=findViewById(R.id.btnStop);
        JS = (JobScheduler)getSystemService (JOB_SCHEDULER_SERVICE);
        btnStart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //ne travaillez pas avec le contexte activity =this
            ComponentName CN = new ComponentName(getApplicationContext(), MyJobService.class);
            JobInfo JI = new JobInfo.Builder(JOB_ID,CN)
                    .setRequiresCharging(true)
                    //.setPersisted(true)
                    //permission obligatoire dans ce cas
                    .build();

           int result=JS.schedule(JI);
            if (result==JobScheduler.RESULT_SUCCESS)
            {
                Log.i("aa","ok");
            }
            else
                Log.i("aa","non ok");


        }


    });
    btnStop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i("aa","cancel avant");
            JS.cancelAll();
              Log.i("aa","cancel après");

        }
    });
    }
}