package dam.pmdm.spyrothedragon.ui.Utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;

public class Animations {

    public Animations() {
    }

    public static void animaFondo(View view) {


        ObjectAnimator animarFondoX = ObjectAnimator.ofFloat(view, "ScaleX", 1.03f);
        ObjectAnimator animarFondoY = ObjectAnimator.ofFloat(view, "ScaleY", 1.03f);
        ObjectAnimator animarFondoRotation = ObjectAnimator.ofFloat(view, "rotation", 1.05f);


        animarFondoX.setDuration(1500);
        animarFondoY.setDuration(1500);
        animarFondoX.setRepeatCount(9);
        animarFondoY.setRepeatCount(9);
        animarFondoRotation.setDuration(1500);
        animarFondoRotation.setRepeatCount(9);
        animarFondoX.setRepeatMode(ObjectAnimator.REVERSE);
        animarFondoY.setRepeatMode(ObjectAnimator.REVERSE);
        animarFondoRotation.setRepeatMode(ObjectAnimator.REVERSE);

        animarFondoX.start();
        animarFondoY.start();

        animarFondoRotation.start();
    }

    public static void animaImage(View view) {

        AnimatorSet animatorSet = new AnimatorSet();
        float rdn = (float) (Math.random() * 45);
        ObjectAnimator animarScalaX = ObjectAnimator.ofFloat(view, "scaleY", 1f,1.5f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotationX", rdn);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 0f,1.0f);

        animarScalaX.setRepeatCount(16);
        animarScalaX.setRepeatMode(ValueAnimator.RESTART);
        rotate.setRepeatCount(16);
        alpha.setRepeatCount(16);
        rotate.setRepeatMode(ValueAnimator.RESTART);
        alpha.setRepeatMode(ValueAnimator.RESTART);

        animatorSet.playTogether(animarScalaX, rotate, alpha);
        animatorSet.setDuration(700);
        animatorSet.start();


    }

    public static void animaIcono(View view) {

        ObjectAnimator animarFondoX = ObjectAnimator.ofFloat(view, "ScaleX", 1.5f);
        ObjectAnimator animarFondoY = ObjectAnimator.ofFloat(view, "ScaleY", 1.5f);


        animarFondoX.setDuration(1000);
        animarFondoY.setDuration(1000);
        animarFondoX.setRepeatCount(13);
        animarFondoY.setRepeatCount(13);
        animarFondoX.setRepeatMode(ObjectAnimator.REVERSE);
        animarFondoY.setRepeatMode(ObjectAnimator.REVERSE);


        animarFondoX.start();
        animarFondoY.start();


    }
}

