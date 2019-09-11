package privateview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.*;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.bitmap.MainActivity;
import com.example.bitmap.R;

/**
 * Created by jiangxiaolin on 2019/8/21.
 */

public class myBTview extends View {

    private Paint mPaint;

    public myBTview(Context context) {
        super(context);
        init();
    }

    public myBTview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public myBTview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public myBTview(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()){
            case MotionEvent.ACTION_UP :
                 Log.v("TAG","ACTION_UP");
                 return true;
               case MotionEvent.ACTION_MOVE :
                   Log.v("TAG","ACTION_MOVE");
               break;
               case MotionEvent.ACTION_DOWN :
                   Log.v("TAG","ACTION_DOWN");
//                   Toast.makeText(myBTview, "提示的内容", Toast.LENGTH_SHORT).show();
               break;
            default :
        }

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawCircle(40, 40, 20, mPaint);
        Path path = new Path();
        path.quadTo(100,200,100,400);
        canvas.drawPath(path, mPaint);

//        canvas.drawLine(100,200,100,400,mPaint);
//        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.a), 0, 0, mPaint);

    }

    private void init(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);          //抗锯齿
        mPaint.setColor(getResources().getColor(R.color.colorAccent));//画笔颜色
        mPaint.setStyle(Paint.Style.FILL);  //画笔风格
        mPaint.setTextSize(36);             //绘制文字大小，单位px
        mPaint.setStrokeWidth(5);           //画笔粗细
    }


}
