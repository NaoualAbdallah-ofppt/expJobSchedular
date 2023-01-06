package com.example.expjobschedular;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
public class MyJobService extends JobService {
    MediaPlayer MP;
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
       Log.i("aa","Start job");
        Log.i("aa", "back");
        MP= MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        MP.setLooping(true);
        MP.start();
       // jobFinished(jobParameters,false);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.i("aa","Stop job");
        MP.stop();
        return false;
    }
}
