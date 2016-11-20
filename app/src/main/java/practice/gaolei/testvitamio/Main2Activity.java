package practice.gaolei.testvitamio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class Main2Activity extends AppCompatActivity {

    //http://baobab.cdn.wandoujia.com/14521610259381.mp4

    private VideoView videoView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //播放器
        videoView= (VideoView) findViewById(R.id.surface_view);
        //控制器
        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        String path="http://baobab.cdn.wandoujia.com/14521610259381.mp4";
        videoView.setVideoPath(path);
        videoView.requestFocus();
        videoView.start();

    }
    public void Click(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
