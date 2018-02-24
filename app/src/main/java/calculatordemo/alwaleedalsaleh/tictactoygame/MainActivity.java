package calculatordemo.alwaleedalsaleh.tictactoygame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buclick(View view) {
        Button buSelected = (Button) view;
        int CellID = 0;
        switch ((buSelected.getId())) {
            case R.id.bu1:
                CellID = 1;
                break;

            case R.id.bu2:
                CellID = 2;
                break;

            case R.id.bu3:
                CellID = 3;
                break;

            case R.id.bu4:
                CellID = 4;
                break;

            case R.id.bu5:
                CellID = 5;
                break;

            case R.id.bu6:
                CellID = 6;
                break;

            case R.id.bu7:
                CellID = 7;
                break;

            case R.id.bu8:
                CellID = 8;
                break;

            case R.id.bu9:
                CellID = 9;
                break;
        }
        PlayGame(CellID, buSelected);
    }

    int activePplayer = 1;//1- for first ,2for secound
    ArrayList<Integer> player1 = new ArrayList<Integer>();//hold player 1 data
    ArrayList<Integer> player2 = new ArrayList<Integer>();//hold player 2 data

    void PlayGame(int CellId, Button buSelected) {

        Log.d("Player", String.valueOf(CellId));
        if (activePplayer == 1) {
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.BLACK);
            player1.add(CellId);
            activePplayer = 2;
             AutoPlay();

        } else if (activePplayer == 2) {
            buSelected.setText("0");
            buSelected.setBackgroundColor(Color.BLUE);
            player1.add(CellId);
            activePplayer = 1;
        }
        buSelected.setEnabled(false);
        CheckWiner();
    }



        void AutoPlay () {
            ArrayList<Integer> EmptyCells = new ArrayList<Integer>();//all un selected cells
            //find empty cells
            for (int cellid = 1; cellid < 10; cellid++) {
                if (!(player1.contains(cellid) || player2.contains(cellid))) {
                    EmptyCells.add(cellid);
                }

            }
            Random r = new Random();
            int RandIndex = r.nextInt(EmptyCells.size() - 0) + 0;//if size =3 ,select(0,1,2)
            int CellID = EmptyCells.get(RandIndex);
            Button buSelected;
            switch (CellID) {
                case 1:
                    buSelected = (Button) findViewById(R.id.bu1);
                    break;

                case 2:
                    buSelected = (Button) findViewById(R.id.bu2);
                    break;

                case 3:
                    buSelected = (Button) findViewById(R.id.bu3);
                    break;

                case 4:
                    buSelected = (Button) findViewById(R.id.bu4);
                    break;

                case 5:
                    buSelected = (Button) findViewById(R.id.bu5);
                    break;

                case 6:
                    buSelected = (Button) findViewById(R.id.bu6);
                    break;

                case 7:
                    buSelected = (Button) findViewById(R.id.bu7);
                    break;

                case 8:
                    buSelected = (Button) findViewById(R.id.bu8);
                    break;

                case 9:
                    buSelected = (Button) findViewById(R.id.bu9);
                default:
                    buSelected = (Button) findViewById(R.id.bu1);
                    break;
            }
            PlayGame(CellID, buSelected);
        }



    void CheckWiner() {
        int winer=-1;
        //row1
            if(player1.contains(1)&& player1.contains(2) && player1.contains(3)){
            winer=1;
            }

            if(player2.contains(1)&& player2.contains(2) && player2.contains(3)){
                winer=2;

            }//row2
            if(player1.contains(4)&& player1.contains(5)&& player1.contains(6)){
                winer=1;
            }

            if(player2.contains(4)&& player2.contains(5) && player2.contains(6)){
                winer=2;

            }//row3

            if(player1.contains(7)&& player1.contains(8) && player1.contains(9)){
                winer=1;
            }

            if(player2.contains(7)&& player2.contains(8) && player2.contains(9)){
                winer=2;

            }//col1
            if(player1.contains(1)&& player1.contains(4) && player1.contains(5)){
                winer=1;
            }

            if(player2.contains(1)&& player2.contains(4) && player2.contains(5)){
                winer=2;
                //col2
            }if(player1.contains(2)&& player1.contains(5) && player1.contains(8)){
                winer=1;
            }

            if(player2.contains(2)&& player2.contains(5) && player2.contains(8)){
                winer=2;

            }//col3
            if(player1.contains(3)&& player1.contains(6) && player1.contains(9)){
                winer=1;
            }

            if(player2.contains(3)&& player2.contains(6) && player2.contains(9)){
                winer=2;

            }

            if(winer!=1){
                //we have winner
                if(winer==1){
                    Toast.makeText(this,"Player1",Toast.LENGTH_LONG).show();
                }
                if(winer==2){
                    Toast.makeText(this,"Player1",Toast.LENGTH_LONG).show();
                }
            }

        }

    }



