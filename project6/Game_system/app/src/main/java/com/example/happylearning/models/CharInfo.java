package com.example.happylearning.models;

public class CharInfo {

    /*
     * Description:
     * Used to save Character's information.
     * The data includes character's image view and audio.
     */

    private int imageId;
    private int AudioId;

    public CharInfo(){}

    public CharInfo (int imageId,int AudioId){
        this.imageId = imageId;
        this.AudioId = AudioId;
    }

    public int getImageId() {
        return imageId;
    }
    public int getAudioId() {
        return AudioId;
    }
}
