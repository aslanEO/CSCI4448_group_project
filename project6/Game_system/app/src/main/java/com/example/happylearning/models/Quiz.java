package com.example.happylearning.models;

public class Quiz {

    /*
     * Description:
     * Used to save quiz questions information.
     * The options and answer were save in the Firebase.
     */

    public String option1, option2, answer;

    public Quiz(String option1, String option2, String answer) {
        this.option1 = option1;
        this.option2 = option2;
        this.answer = answer;
    }

    public Quiz() {}
    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
