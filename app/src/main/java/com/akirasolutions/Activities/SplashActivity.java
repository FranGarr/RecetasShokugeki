package com.akirasolutions.Activities;
import android.app.Activity;


        import android.content.Context;
        import android.content.SharedPreferences;

        import android.os.Handler;

        import android.app.Activity;
        import android.content.Intent;
        import android.content.pm.ActivityInfo;
        import android.os.Bundle;


import com.akirasolutions.Config.ConfigScreen;
import com.akirasolutions.recetasshokugeki.R;

/**
 * Created by Ebuctop on 01/04/2018.
 */
public class SplashActivity extends Activity {


    // Establecemos la duracion del timer
    private static final int SPLASH_SCREEN_DELAY = 3000;
    Context context=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConfigScreen cfg = new ConfigScreen();
        cfg.setConfig(context, R.layout.splashinitial);

        SharedPreferences mode = getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE);
        final int modo = mode.getInt("mode", 0);
        String mac=mode.getString("VERSION","NULL");




        SharedPreferences.Editor editor = mode.edit();
        if(modo==0||modo==1) {
            editor.putInt("mode", 1);
            editor.commit();
            //salto a la configuración principal
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {


                    try {
                        Intent nextIntent = new Intent().setClass(SplashActivity.this, MainActivity.class);


                        startActivity(nextIntent);

                    } catch (Exception e) {
                    }

                    // finish();
                }
            }, SPLASH_SCREEN_DELAY);
        }else{

            editor.putInt("mode", 2);
            editor.commit();
            if(mac.equals("NULL")){//Salto al escaner de bluetooth
                try {
                    Intent nextIntent = new Intent().setClass(SplashActivity.this, MainActivity.class);
                    startActivity(nextIntent);

                } catch (Exception e) {
                }
            }else {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        try {//Salto a la pantalla principal
                            Intent nextIntent = new Intent().setClass(SplashActivity.this, MainActivity.class);
                            startActivity(nextIntent);

                        } catch (Exception e) {
                        }

                        // finish();
                    }
                }, SPLASH_SCREEN_DELAY);
            }

        }

    }



}
