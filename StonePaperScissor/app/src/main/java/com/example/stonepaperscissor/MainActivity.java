package com.example.stonepaperscissor;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.material.slider.RangeSlider;

public class MainActivity extends AppCompatActivity {
    TextView you,computer,turn,result;
    Button stone,paper,scissor;
    ImageView usr_img,cmp_img;
    int usr_sc=0,cmp_sc=0;
    protected MediaPlayer mp;
    protected void usr(int n){
        result=findViewById(R.id.result);
        cmp_img=findViewById(R.id.cmp_img);
        result.setVisibility(View.INVISIBLE);
        int[] buttons={R.drawable.stone,R.drawable.paper,R.drawable.scissor};
        int usr_choice=n;
        Random randomno = new Random();
        int cmp_choice = randomno.nextInt(3);
        turn.setText("Computer Turn");
        YoYo.with(Techniques.Shake).playOn(cmp_img);
        cmp_img.setImageResource(buttons[cmp_choice]);
        if(usr_choice==cmp_choice){
            usr_sc+=0;
        }
        else if((usr_choice==0 && cmp_choice==2 ) || (usr_choice==1 && cmp_choice==0) ||(usr_choice==2 && cmp_choice==1)){
            usr_sc++;
        }
        else{
            cmp_sc++;
        }
        you.setText(usr_sc+"");
        computer.setText(cmp_sc+"");
        turn.setText("Your Turn");
        if(usr_sc==5){
            turn.setText("Game Over");
            result.setText("YOU WIN THE GAME");
            result.setVisibility(View.VISIBLE);
            usr_sc=0;
            cmp_sc=0;
            you.setText("0");
            computer.setText("0");
        }
        else if(cmp_sc==5){
            turn.setText("Game Over");
            result.setText("YOU LOSS THE GAME");
            result.setVisibility(View.VISIBLE);
            usr_sc=0;
            cmp_sc=0;
            you.setText("0");
            computer.setText("0");
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp=MediaPlayer.create(this,R.raw.soundeffect);
        you=findViewById(R.id.you);
        computer=findViewById(R.id.computer);
        usr_img=findViewById(R.id.usr_img);
        cmp_img=findViewById(R.id.cmp_img);
        result=findViewById(R.id.result);
        you.setText("0");
        computer.setText("0");
        int[] buttons={R.drawable.stone,R.drawable.paper,R.drawable.scissor};
        stone=findViewById(R.id.stone);
        paper=findViewById(R.id.paperc);
        scissor=findViewById(R.id.scissor);
        turn=findViewById(R.id.turn);
            stone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mp.start();
                    YoYo.with(Techniques.Shake).playOn(usr_img);
                    usr_img.setImageResource(buttons[0]);
                    usr(0);
                }
            });
            paper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mp.start();
                    YoYo.with(Techniques.Shake).playOn(usr_img);
                    usr_img.setImageResource(buttons[1]);
                    usr(1);
                }
            });
            scissor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mp.start();
                    YoYo.with(Techniques.Shake).playOn(usr_img);
                    usr_img.setImageResource(buttons[2]);
                    usr(2);
                }
            });
    }
}