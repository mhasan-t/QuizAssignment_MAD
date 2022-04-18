package com.example.quizrecycler;

import java.io.Serializable;
import java.util.ArrayList;

public class QuestionDataModel implements Serializable {
    String question;
    ArrayList<String> options;
    String correctOption;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public QuestionDataModel(String question, ArrayList<String> options, String correctOption) {

        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void addOption(String newOption){
        options.add(newOption);
    }
}
