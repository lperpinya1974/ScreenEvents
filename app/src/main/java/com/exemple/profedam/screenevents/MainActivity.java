package com.exemple.profedam.screenevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    TextView accions, direccio;
    float iniciX, iniciY, finalX, finalY;
    int numAccio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
        linear.setOnTouchListener(this);

        accions = (TextView) findViewById(R.id.accions);
        direccio = (TextView) findViewById(R.id.direccio);
        iniciX = iniciY = 0;
        finalX = finalY = 0;
        numAccio = 0;


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
     public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Netegem el TextView i posem el comptador a 0
         if (id == R.id.action_clear) {
            accions.setText("");
            numAccio = 0;
             return true;
             }

         return super.onOptionsItemSelected(item);
         }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            // Registrem l’event al TextView
            accions.setText(String.valueOf(numAccio) + " − " + "ACTION_DOWN\n"
                    + accions.getText());
            iniciX = event.getX();
            iniciY = event.getY();
        }

        else    if (event.getAction() == MotionEvent.ACTION_UP) {

                 // Registrem l’event al TextView
                 accions.setText(String.valueOf(numAccio) + " − " + "ACTION_UP\n"
                        + accions.getText());
                 finalX = event.getX();
                 finalY = event.getY();

            //Comprovem quin dels dos moviments ha estat major. Si és l’ horitzontal

             if (Math.abs(finalX - iniciX) > Math.abs(finalY - iniciY)) {

                //Si la X final és major que la inicial ha fet "drag" cap a la dreta
                 if (finalX > iniciX) {
                    direccio.setText("dreta");
                     // Si no, cap a l’esquerra
                     } else {
                     direccio.setText("esquerra");
                     }
                 // Si és el vertical
                 } else {
                 // Si la Y final és major que la inicial ha fet "drag" cap avall

                 if (finalY > iniciY) {
                     direccio.setText("baix");
                     // Si no, cap a dalt
                     } else {
                    direccio.setText("dalt");
                     }
                 }

             } else if (event.getAction() == MotionEvent.ACTION_MOVE) {

             // Registrem l’event al TextView
             accions.setText(String.valueOf(numAccio) + " − " + "ACTION_MOVE\n"
                    + accions.getText());

             }
        // Incrementem el comptador d’acció
         numAccio += 1;
         return true;



    }
}