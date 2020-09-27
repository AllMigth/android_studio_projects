package com.example.cf_videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView)findViewById(R.id.videoView);
        //http://demonuts.com/Demonuts/smallvideo.mp4
        //ya que tenemos el archivo en el recurso tenemos que llamarlo
        /*
        INICIAR UN VIDEO DE FORMA LOCAL
        String path="android.resource://"+getPackageName()+"/"+R.raw.smallvideo;
        //la direccion en tipo uri y la cargamos en video para que se pueda visualizar
        videoView.setVideoURI(Uri.parse(path));
        //AHORA INICIAMOS EL VIDEO  */
        //AHORA VAMOS A REPRODUCIR UN VIDEO DE MANERA REMOTA

        //agregando los controles para el video
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        String path="android.resource://"+getPackageName()+"/"+R.raw.smallvideo;
        videoView.setVideoURI(Uri.parse(path));
        //videoView.setVideoPath("http://demonuts.com/Demonuts/smallvideo.mp4");
        videoView.pause();
        //videoView.start();
        //especificar el tiempo en el que va a iniiciar nuestro video
        videoView.seekTo(0010);
        //para pausar/reproducir el video al tocarlo
        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //recibimos view y motion event que es cuando hacemos click
                if (videoView.isPlaying()){
                    videoView.pause();

                }else{
                    videoView.start();
                    //podemos obtener el tiempo de la reproduccion del video
                    //Toast.makeText(getApplicationContext(),"Tiempo actual "+videoView.getCurrentPosition(),Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                //este metodo recibe media player y podremos manipular videoview
                Toast.makeText(getApplicationContext(),"Duracion "+mediaPlayer.getDuration(),Toast.LENGTH_SHORT).show();
            }
        });
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                //manipulamos el videoview al finalizar ek video
                mediaPlayer.start();
            }
        });
    }

    public void stop(View view) {
        videoView.stopPlayback();
    }
}
