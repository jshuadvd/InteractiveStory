package interactivestory.joshuadavid.com.interactivestory.model;

/**
 * Created by joshuadavid on 4/21/15.
 */
public class Page {

    private int mImageId;
    private String mText;

    private Choice mChoice1;
    private Choice mChoice2;



    // Getters & Setters
    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int id) {
        mImageId = id;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }
}
