/*
* Created by: Nicolas Hagen
*
* This app is a simple rock, paper, scissors game for an android phone running the newest
* android version: Android 11
* As per license agreements, I am not forced to credit the creator of the images used in this
* game. However, to give credit where I feel it is due I will
* The license can be found at https://creativecommons.org/publicdomain/zero/1.0/.
* The attribution link, as found, is publicdomainq.net
*/

package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Variables for oobjects on screen
    Button rockChoice, paperChoice, scissorChoice;
    TextView tv_humanChoice, tv_computerChoice, tv_score;
    ImageView iv_computerChoice, iv_humanChoice;

    //Create score variables
    int playerScore, computerScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning the buttons to variables
        rockChoice = findViewById(R.id.rockChoice);
        paperChoice = findViewById(R.id.paperChoice);
        scissorChoice = findViewById(R.id.scissorChoice);

        //Assigning the text views to variables
        tv_humanChoice = findViewById(R.id.tv_HumanChoice);
        tv_computerChoice = findViewById(R.id.tv_ComputerChoice);
        tv_score = findViewById(R.id.scoreBoard);


        //Assigning images to variables
        iv_computerChoice = findViewById(R.id.iv_ComputerChoice);
        iv_humanChoice = findViewById(R.id.iv_HumanChoice);


        //Create the on click listeners
        rockChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set image to rock when clicked
                iv_humanChoice.setImageResource(R.drawable.rock);
                String message = playTurn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                tv_score.setText("Score: Human " + Integer.toString(playerScore) + " Computer " + Integer.toString(computerScore));            }
        });

        paperChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_humanChoice.setImageResource(R.drawable.paper);
                String message = playTurn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                tv_score.setText("Score: Human " + Integer.toString(playerScore) + " Computer " + Integer.toString(computerScore));
            }
        });

        scissorChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_humanChoice.setImageResource(R.drawable.scissors);
                String message = playTurn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                tv_score.setText("Score: Human " + Integer.toString(playerScore) + " Computer " + Integer.toString(computerScore));            }
        });

        tv_humanChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tv_computerChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tv_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        iv_computerChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        iv_humanChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public String playTurn(String playerChoice){

        String computerChoice = "";
        Random rand = new Random();

        //Computer choice, random generated number. 1, 2, or 3
        int computerChoiceNumber = rand.nextInt(3) + 1;

        //Set computer choice to either rock, paper, or scissors
        if (computerChoiceNumber == 1) {
            computerChoice = "rock";
            iv_computerChoice.setImageResource(R.drawable.rock);
        }
        else if (computerChoiceNumber == 2) {
            computerChoice = "paper";
            iv_computerChoice.setImageResource(R.drawable.paper);
        }
        else if (computerChoiceNumber == 3) {
            computerChoice = "scissors";
            iv_computerChoice.setImageResource(R.drawable.scissors);
        }

        if (computerChoice == playerChoice) {
            return "Draw";
        }
        else if (playerChoice == "rock" && computerChoice == "scissors") {
            playerScore++;
            return "You Won!";
        }
        else if (playerChoice == "paper" && computerChoice == "rock") {
            playerScore++;
            return "You Won!";
        }
        else if (playerChoice == "scissors" && computerChoice == "paper") {
            playerScore++;
            return "You Won!";
        }
        else if (playerChoice == "rock" && computerChoice == "paper") {
            computerScore++;
            return "You Lost!";
        }
        else if (playerChoice == "scissors" && computerChoice == "rock") {
            computerScore++;
            return "You Lost!";
        }
        else if (playerChoice == "paper" && computerChoice == "scissors") {
            computerScore++;
            return "You Lost!";
        }
        return "";
    }
}