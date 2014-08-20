package com.example.njupt.zhb.imageprocesssystem;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
public class DisplayView extends View {    
	public Bitmap bitmap1=null;
	public Bitmap bitmap2=null;
	public int TopInterval=10;
	public Rect BMPRect1,BMPRect2;
	public DisplayView(Context context){
		super(context);
	}
	/*һ��Ҫ��д������췽��*/
    public DisplayView(Context context,AttributeSet attrs) {
    	super(context,attrs);
    }
    /*��дonDraw()*/   
    @Override   
    protected void onDraw(Canvas canvas)    
    {       
         super.onDraw(canvas);
         Paint paint=new Paint();    
         /*ȥ���*/   
         paint.setAntiAlias(true);    
         /*����paint����ɫ*/   
         paint.setColor(Color.RED);    
         /*����paint�� style ΪSTROKE������*/   
         paint.setStyle(Paint.Style.STROKE);    
         /*����paint�������*/   
         paint.setStrokeWidth(1); 
         ////////////////////////////////////////////////
         int width=getWidth();
         int height=getHeight()-TopInterval;
         int myInterval=(int)(width-height*2)/3;
         int x1=myInterval,y1=TopInterval,x2=myInterval+height,y2=height;
         int x3=myInterval*2+height,y3=TopInterval,x4=(myInterval+height)*2,y4=y2;
         BMPRect1=new Rect(x1,y1,x2,y2);
         BMPRect2=new Rect(x3,y3,x4,y4);
         ///////////////////////////////////////////////
         /*��λͼ1*/
         if (bitmap1!=null) {
        	 canvas.drawBitmap(bitmap1, null, BMPRect1, null);
		}else{
			paint.setTextSize(18);    
            canvas.drawText("Դͼ������", x1, height/2, paint);  
		}
         /*��λͼ2*/
         if(bitmap2!=null){
             canvas.drawBitmap(bitmap2, null, BMPRect2, null);
         }else{
 			 paint.setTextSize(18);    
             canvas.drawText("������ͼ������",x3, height/2, paint);
         }
    }  
    
} 