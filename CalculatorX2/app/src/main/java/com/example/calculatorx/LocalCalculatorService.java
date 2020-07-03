package com.example.calculatorx;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class LocalCalculatorService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

    }
    MainActivity main;
    // Clientlere verilen Binder(bağlayıcı)
    private final IBinder binder = new LocalBinder();

    /**
     * İstemci Binderi için kullanılan sınıf.Bu servisin
     * istemcileriyle her zaman aynı süreçte çalıştığını bildiğimiz
     * için IPC ile uğraşmak zorunda değiliz.
     */
    public class LocalBinder extends Binder {
        LocalCalculatorService getService() {
            // İstemcilerin genel yöntemleri çağırabilmeleri için bu
            //LocalService örneğini döndürürüz.
            return LocalCalculatorService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    /**
     * Clientler için method
     */
    public double equalsMethod() {

            main.isOpPressed = false;
            main.dotUsed = false;

            double result = 0;
            String screenContent = main.TextViewInputNumbers.getText().toString();
            double val2 = Double.parseDouble(screenContent.substring(main.val2Index));
            if (main.currentOP == '+') {
                result = main.val1 + val2;
            } else if (main.currentOP == '-') {
                result = main.val1 - val2;
            } else if (main.currentOP == '×') {
                result = main.val1 * val2;
            } else if (main.currentOP == '÷') {
                result = main.val1 / val2;
            }
            return result;
        }
    }







