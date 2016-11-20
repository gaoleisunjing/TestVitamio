package practice.gaolei.testvitamio;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载so类库(通常使用c、c++编写类库)
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        setContentView(R.layout.activity_main);
        initMediaPlayer();
        button = (Button)findViewById(R.id.button4);

    }

    private void initMediaPlayer() {
        mediaPlayer = new MediaPlayer(this);

    }

    public void play(View view) {

        mediaPlayer.reset();
        //播放音乐
        Log.d("gl", "====" + Environment.getExternalStorageDirectory());
        Log.d("gl", "====" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
        String path = Environment.getExternalStorageDirectory() + File.separator + "Music" + File.separator + "gl.MP3";
        try {
            mediaPlayer.setDataSource(path);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pause(View view) {
        mediaPlayer.pause();

    }

    public void stop(View view) {
        mediaPlayer.stop();

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //   mediaPlayer.release();
        mediaPlayer = null;
    }

    public void Click(View view){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
