package dam.pmdm.spyrothedragon.ui.Utils;

import static android.content.Context.MODE_PRIVATE;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.SoundPool;
import android.util.Log;

import dam.pmdm.spyrothedragon.MainActivity;

public class Utils {

    public static void iniciarSonido(Context context, int sonido) {

        SoundPool soundPool = new SoundPool.Builder().setMaxStreams(1).build();
        int soundId = soundPool.load(context, sonido, 1);


        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                if (status == 0) {
                    soundPool.play(soundId, 1, 1, 0, 0, 1);
                }
            }
        });


    }

    public static void salirGuia(Context context) {
        guardarGuia(context, true);
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(context, intent, null);

    }

    public static boolean obtenerGuia(Context context) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Guia", MODE_PRIVATE);
        Log.d("SHAREDPREFERENCE", "guia estado:" + sharedPreferences.getBoolean("guiaCompletada", false));
        return sharedPreferences.getBoolean("guiaCompletada", false);
    }

    public static void guardarGuia(Context context, boolean estado) {
        Log.d("SHAREDPREFERENCE", "guia completada");
        SharedPreferences sharedPreferences = context.getSharedPreferences("Guia", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("guiaCompletada", estado);
        editor.apply();
    }


}
