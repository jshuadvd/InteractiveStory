package interactivestory.joshuadavid.com.interactivestory.model;

import interactivestory.joshuadavid.com.interactivestory.R;

/**
 * Created by joshuadavid on 4/22/15.
 */
public class Story {

    private Page[] mPages;

    public Story() {

        mPages = new Page[7];

        mPages[0] = new Page();
        mPages[0].setImageId(R.mipmap.page0);
        mPages[0].setText("test");
        mPages[0].getChoice1(new Choice());
        mPages[0].getChoice2(new Choice());






    }



}
