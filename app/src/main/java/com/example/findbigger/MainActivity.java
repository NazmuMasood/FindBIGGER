package com.example.findbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int count; private int n1,n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateNewRandom();
    }

    private void generateNewRandom(){
        if (count==5){
            count = 0;
            Toast.makeText(this,"You won!",Toast.LENGTH_SHORT).show();
        }
        else {
            Random random = new Random();
            n1 = random.nextInt(20);
            while (true) {
                n2 = random.nextInt(20);
                if (n1 != n2) {
                    break;
                }
            }
            Button leftButton = findViewById(R.id.left_button);
            leftButton.setText(Integer.toString(n1));
            Button rightButton = findViewById(R.id.right_button);
            rightButton.setText(Integer.toString(n2));
        }
    }

    public void leftClick(View v){
        if (n1>n2){
            count++;
        }
        if (n1<n2){
            count--;
        }
        TextView result = findViewById(R.id.textViewResult);
        result.setText("Points: "+count);
        generateNewRandom();
    }

    public void rightClick(View v){
        if (n1<n2){
            count++;
        }
        if (n1>n2){
            count--;
        }
        TextView result = findViewById(R.id.textViewResult);
        result.setText("Points: "+count);
        generateNewRandom();
    }
}
