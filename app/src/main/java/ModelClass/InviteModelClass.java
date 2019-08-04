package ModelClass;

/**
 * Created by wolfsoft5 on 5/7/18.
 */

public class InviteModelClass {


    Integer image;
    String title;

    public InviteModelClass(Integer image, String title) {
        this.image = image;
        this.title = title;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
