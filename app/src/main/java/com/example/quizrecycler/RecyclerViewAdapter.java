package com.example.quizrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    Context context;
    private List<QuestionDataModel> questionsList;

    public QuestionAdapter(Context context, List<QuestionDataModel> questionList) {
        this.context = context;
        this.questionsList = questionList;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        // Get the Views from inside the 'item_design' file using the 'position' variable
        String ques = questionsList.get(position).getQuestion();
        ArrayList<String> options = questionsList.get(position).getOptions();

        holder.setData(ques, options);
    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder{

        private TextView questionTV, opsOneTV, opsTwoTV, opsThreeTV, opsFourTV;
        private CheckBox opsOneCB, opsTwoCB, opsThreeCB, opsFourCB;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);

            questionTV = itemView.findViewById(R.id.question);

            opsOneTV = itemView.findViewById(R.id.optionOne);
            opsTwoTV = itemView.findViewById(R.id.optionTwo);
            opsThreeTV = itemView.findViewById(R.id.optionThree);
            opsFourTV = itemView.findViewById(R.id.optionFour);

            opsOneCB = itemView.findViewById(R.id.optionOneCB);
            opsTwoCB = itemView.findViewById(R.id.optionTwoCB);
            opsThreeCB = itemView.findViewById(R.id.optionThreeCB);
            opsFourCB = itemView.findViewById(R.id.optionFourCB);

        }

        public void setData(String ques, ArrayList<String> options){
            questionTV.setText(ques);
            opsOneTV.setText(options.get(0));
            opsTwoTV.setText(options.get(1));
            opsThreeTV.setText(options.get(2));
            opsFourTV.setText(options.get(3));
        }
    }
}
