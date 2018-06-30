package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mTopButton;
    Button mBottomButton;
    TextView mStoryTextView;

    int mStoryIndex = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);

        // Begin the tale
        mStoryTextView.setText(R.string.T1_Story);
        mTopButton.setText(R.string.T1_Ans1);
        mBottomButton.setText(R.string.T1_Ans2);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Destini", "Top Button Pressed");

                // define the next state based on user decision
                //
                switch (mStoryIndex){
                    case 1:
                        mStoryTextView.setText(R.string.T3_Story);
                        mTopButton.setText(R.string.T3_Ans1);
                        mBottomButton.setText(R.string.T3_Ans2);
                        mStoryIndex = 2;
                        break;

                    case 2:
                        // user chooses T3_Ans1, story ends
                        //
                        Log.d("Destini", "Game Over - T6_End");
                        mStoryTextView.setText(R.string.T6_End);
                        mTopButton.setVisibility(View.GONE);
                        mBottomButton.setVisibility(View.GONE);
                        break;

                    case 3:
                        // the story continues
                        mStoryTextView.setText(R.string.T3_Story);
                        mTopButton.setText(R.string.T3_Ans1);
                        mBottomButton.setText(R.string.T3_Ans2);
                        mStoryIndex = 4;
                        break;

                    case 4: // game over T6_End
                        mStoryTextView.setText(R.string.T6_End);
                        mBottomButton.setVisibility(View.GONE);
                        mTopButton.setVisibility(View.GONE);
                        break;

                };
            }
        });




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Destini", "Bottom Button Pressed");

                // user action determines the next story state
                //
                switch (mStoryIndex) {
                    case 1:
                        mStoryTextView.setText(R.string.T2_Story);
                        mTopButton.setText(R.string.T2_Ans1);
                        mBottomButton.setText(R.string.T2_Ans2);
                        mStoryIndex = 3;
                        break;
                    case 2:
                        // story ends T5_End
                        mStoryTextView.setText(R.string.T5_End);
                        mBottomButton.setVisibility(View.GONE);
                        mTopButton.setVisibility(View.GONE);
                        break;

                    case 3:
                        // game over T4_End
                        Log.d("Destini", "Game Over - T5_End");
                        mStoryTextView.setText(R.string.T4_End);
                        mBottomButton.setVisibility(View.GONE);
                        mTopButton.setVisibility(View.GONE);
                        break;
                    case 4:
                        // game over T5_End
                        mStoryTextView.setText(R.string.T5_End);
                        mBottomButton.setVisibility(View.GONE);
                        mTopButton.setVisibility(View.GONE);
                        break;

                    default:
                        Log.d("Destini", "Unknown Story State");
                        mBottomButton.setVisibility(View.GONE);
                        mTopButton.setVisibility(View.GONE);
                        break;

                };
            }
        });

    }
}
