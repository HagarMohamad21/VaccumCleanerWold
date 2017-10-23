package commonsware.com.vaccumcleanerwold;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.CountDownTimer;
import java.util.Random;
import java.util.Timer;
import android.os.CountDownTimer;
import java.util.concurrent.Delayed;

public class MainActivity extends AppCompatActivity {
ImageView vaccum1;
ImageView vaccum2;
ImageView dirt1;
ImageView dirt2;
Random r ;
int num;
int num2;
int dirtpos=0;
int agentPos;
Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vaccum1= (ImageView) findViewById(R.id.vaccum1);
        vaccum2= (ImageView) findViewById(R.id.vaccum2);
        dirt1= (ImageView) findViewById(R.id.dirt1);
        dirt2= (ImageView) findViewById(R.id.dirt2);
      bt= (Button) findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intializer();
                agentAction(dirtpos,agentPos);
                Delay();

                }



        });



        }




    public void Intializer() {
        r=new Random();
        num=r.nextInt(20);

        System.out.println(num);

        //case 1 both A,B are dirty
        if(num<=5){
            dirtpos= 1;
          agentPosition();
            dirt2.setImageDrawable(null);
            dirt1.setImageDrawable(null);}
        //case 2 A is dirty B i clean
       else if(num>5&&num<=10){
            dirtpos=2;
          agentPosition();
            dirt2.setImageDrawable(null);
            dirt1.setImageDrawable(null);
            dirt1.setImageResource(R.drawable.dirt2);
            dirt2.setImageResource(R.drawable.dirt2);

        }
        //case 3 both A,B are clean
           else if (num>10&&num<=15){
            dirtpos=3;
           agentPosition();
            dirt2.setImageDrawable(null);
            dirt1.setImageDrawable(null);
            dirt1.setImageResource(R.drawable.dirt2);
            dirt2.setImageDrawable(null);
        }
        //case 4 B is dirty A i clean
        else if(num>15&&num<=20){
            dirtpos=4;
           agentPosition();
            dirt2.setImageDrawable(null);
            dirt1.setImageDrawable(null);
            dirt2.setImageResource(R.drawable.dirt2);
            dirt1.setImageDrawable(null);
        }

  }
    public void agentPosition(){
        num2=r.nextInt(20);
        if(num2<=10){
            agentPos=0;
            vaccum1.setImageDrawable(null);
            vaccum2.setImageDrawable(null);
            vaccum1.setImageResource(R.drawable.oie_transparent);}
        else{
            agentPos=1;
            vaccum1.setImageDrawable(null);
            vaccum2.setImageDrawable(null);
            vaccum2.setImageResource(R.drawable.oie_transparent);}
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void agentAction (int dirtpos,int agentPos){
        System.out.println("dirt case is"+dirtpos);
        System.out.println("Agent Position is"+agentPos);
        if(agentPos==0){
            if(dirtpos==1){
                Toast.makeText(MainActivity.this, "Both Rooms are Clean", Toast.LENGTH_LONG).show();
            }
            else if(dirtpos==2){
                Toast.makeText(MainActivity.this, "Suck", Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "Down", Toast.LENGTH_LONG).show();

                Toast.makeText(MainActivity.this, "Suck", Toast.LENGTH_LONG).show();

                Toast.makeText(MainActivity.this, "Both Rooms are Clean", Toast.LENGTH_LONG).show();


            }
            else if(dirtpos==3){
                Toast.makeText(MainActivity.this, "Suck", Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "Down", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Both Rooms are Clean", Toast.LENGTH_SHORT).show();
                }
            else if(dirtpos==4){
                Toast.makeText(MainActivity.this, "Down", Toast.LENGTH_SHORT).show();


                Toast.makeText(MainActivity.this, "Suck", Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "Both Rooms are Clean", Toast.LENGTH_SHORT).show();


            }}
        else if (agentPos==1){
            if(dirtpos==1){Toast.makeText(MainActivity.this, "Both Rooms are Clean", Toast.LENGTH_SHORT).show();
            }
            else if(dirtpos==2){
                Toast.makeText(MainActivity.this, "Suck", Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "UP", Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "Suck", Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "Both Rooms are Clean", Toast.LENGTH_SHORT).show();

            }
            else if(dirtpos==3){

                Toast.makeText(MainActivity.this, "UP", Toast.LENGTH_SHORT).show();


                Toast.makeText(MainActivity.this, "Suck", Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "Both Rooms are Clean", Toast.LENGTH_SHORT).show();}
            else if(dirtpos==4){
                Toast.makeText(MainActivity.this, "Suck", Toast.LENGTH_SHORT).show();


                Toast.makeText(MainActivity.this, "UP", Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "Both Rooms are Clean", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void Delay(){
        new CountDownTimer(Toast.LENGTH_SHORT+7000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                clean();
            }
        }.start();

    }


    public void clean(){
        dirt1.setImageDrawable(null); dirt2.setImageDrawable(null);
        if(agentPos==0)
        { vaccum1.setImageDrawable(null);
            vaccum2.setImageResource(R.drawable.oie_transparent);
        }
        else {
            vaccum2.setImageDrawable(null);
            vaccum1.setImageResource(R.drawable.oie_transparent);
        }
    }
}