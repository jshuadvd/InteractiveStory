package interactivestory.joshuadavid.com.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import interactivestory.joshuadavid.com.interactivestory.R;
import interactivestory.joshuadavid.com.interactivestory.model.Page;
import interactivestory.joshuadavid.com.interactivestory.model.Story;


public class StoryActivity extends ActionBarActivity {

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;
    private Page mCurrentPage;

    public static final String TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        mName = intent.getStringExtra("name");

        if (mName == null) {

            mName = "Friend";
        }
        Log.d(TAG, mName);

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);

        loadPage(0);
    }

    private void loadPage(int choice) {
        mCurrentPage = mStory.getPage(choice);

        // Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId(), null);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), mCurrentPage.getImageId(), null);
        // Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);


        String pageText = mCurrentPage.getText();
        // Add the name, if placeholder included. Won't add if no placeholder.
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);

        if (mCurrentPage.isFinal()) {

        mChoice1.setVisibility(View.INVISIBLE);
        mChoice2.setText("PLAY AGAIN");
        mChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        }
        else {
            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());

            // New OnClick listeners for accessing the target of the choice that was clicked and using that target to reload the mCurrentPage
            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Index of new mCurrentPage I want to load
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Index of new mCurrentPage I want to load
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });

        }
    }




}
