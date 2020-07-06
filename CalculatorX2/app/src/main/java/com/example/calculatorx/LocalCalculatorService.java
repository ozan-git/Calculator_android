package com.example.calculatorx;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class LocalCalculatorService extends Service {
    private final IBinder binder = new LocalBinder();

    private char currentOP;
    private double val2 = 0;
    private double val1 = 0;

    public class LocalBinder extends Binder {
        LocalCalculatorService getService() {
            // İstemcilerin genel yöntemleri çağırabilmeleri için bu
            //LocalService örneğini döndürürüz.
            return LocalCalculatorService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        val1 = 0;
        val2 = 0;
        currentOP = ' ';
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public double getVal1() {
        return val1;
    }

    public void setCurrentOP(char currentOP) {
        this.currentOP = currentOP;
    }

    public void setVal2(double val2) {
        this.val2 = val2;
    }

    public void setVal1(double val1) {
        this.val1 = val1;
    }

    /**
     * Clientler için method
     */
    public void equalsMethod() {

        if (currentOP == '+') {
            val1 = val1 + val2;
        } else if (currentOP == '-') {
            val1 = val1 - val2;
        } else if (currentOP == '×') {
            val1 = val1 * val2;
        } else if (currentOP == '÷') {
            val1 = val1 / val2;
        }
    }
}







