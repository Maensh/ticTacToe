package com.example.android.xogame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0:Yellow, 1:Red, 2:Empty
    // test that
    // New edit

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    int activePlayer = 0;

    boolean gameActive = true;

    public void dropin(View view){
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 2 && gameActive) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1500);

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    // Someone has won

                    gameActive = false;

                    String winner = "";

                    if (activePlayer == 1) {

                        winner = "Yellow";
                    } else {
                        winner = "Red";
                    }
                    //Toast.makeText(this, winner + " has won", Toast.LENGTH_SHORT).show();

                    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                    winnerTextView.setText(winner+" has won");
                    playAgainButton.setVisibility(View.VISIBLE);
                    winnerTextView.setVisibility(View.VISIBLE);

                }
            }
        }

            //
            /*boolean isFull = true;
            android.support.v7.widget.GridLayout myGridLayout = (android.support.v7.widget.GridLayout) findViewById(R.id.grid_layout) ;
            for(int i=0; i<myGridLayout.getChildCount(); i++) {
                // do stuff with child view

                ImageView counter1 = (ImageView) myGridLayout.getChildAt(i);

                if (counter1.getTag().toString() != "2"){
                    isFull = false;
                }
            }
            //

            if (isFull){
                Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                android.support.v7.widget.GridLayout myGridLayout1 = (android.support.v7.widget.GridLayout) findViewById(R.id.grid_layout) ;

                playAgainButton.setVisibility(View.INVISIBLE);
                winnerTextView.setVisibility(View.INVISIBLE);

                for(int i=0; i<myGridLayout1.getChildCount(); i++) {
                    // do stuff with child view

                    ImageView counter2 = (ImageView) myGridLayout1.getChildAt(i);

                    counter2.setImageResource(0);

                }

                for (int i = 0; i<gameState.length; i++){
                    gameState[i]=2;
                }

                activePlayer = 0;

                gameActive = true;
            }*/
    }

    public void playAgain (View view){
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        android.support.v7.widget.GridLayout myGridLayout = (android.support.v7.widget.GridLayout) findViewById(R.id.grid_layout) ;

        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);

        for(int i=0; i<myGridLayout.getChildCount(); i++) {
            // do stuff with child view

            ImageView counter = (ImageView) myGridLayout.getChildAt(i);

            counter.setImageResource(0);

        }

        for (int i = 0; i<gameState.length; i++){
            gameState[i]=2;
        }

        activePlayer = 0;

        gameActive = true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
