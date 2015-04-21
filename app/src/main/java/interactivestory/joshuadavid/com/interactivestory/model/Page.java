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

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public Choice getmChoice1() {
        return mChoice1;
    }

    public void setmChoice1(Choice mChoice1) {
        this.mChoice1 = mChoice1;
    }

    public Choice getmChoice2() {
        return mChoice2;
    }

    public void setmChoice2(Choice mChoice2) {
        this.mChoice2 = mChoice2;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setImageId(int id) {
        mImageId = id;
    }
}
