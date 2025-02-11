package dam.pmdm.spyrothedragon.ui.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dam.pmdm.spyrothedragon.R;

public class EasterEggAnim extends View {
    private Canvas canvas;
    private Paint paint;
    private Bitmap bitmap;
    private Bitmap bitmap2;

    public EasterEggAnim(Context context) {
        super(context);
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fire);


    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bitmap, 120, 150, paint);


    }

    public EasterEggAnim(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EasterEggAnim(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public EasterEggAnim(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
