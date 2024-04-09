package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ProcessingThread extends Thread{
    private boolean isRunning = true;
    private Context context;
    private String input1;
    private String input2;

    public ProcessingThread(Context context, String input1) {
        this.context = context;
        this.input1 = input1;
    }

    public void stopThread() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                sendMessage();
                Log.d("ProcessingThread", "Thread is running");
                Thread.sleep(5000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction("ro.pub.cs.systems.eim.practicaltest01var04.intent.action.SEND_BROADCAST");
        intent.putExtra("message", input1);
        context.sendBroadcast(intent);
    }
}
