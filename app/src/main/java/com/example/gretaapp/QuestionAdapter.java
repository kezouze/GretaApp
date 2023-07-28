package com.example.gretaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {
    private List<Question> questionList;

    public QuestionAdapter(List<Question> questionList) {this.questionList = questionList;}

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main2, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question question = questionList.get(position);
        holder.questionText.setText(question.getQuestionText());
        holder.option1.setText(question.getOption1());
        holder.option2.setText(question.getOption2());
        holder.option3.setText(question.getOption3());
        holder.option4.setText(question.getOption4());

        holder.option1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkOption(holder, 1, question);
            }
        });

        holder.option2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkOption(holder, 2, question);
            }
        });

        holder.option3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkOption(holder, 3, question);
            }
        });

        holder.option4.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkOption(holder, 4, question);
            }
        });
    }

    private void checkOption(QuestionViewHolder holder, int selectedOption, Question question) {
        if (selectedOption == question.getCorrectOption()) {
            MainActivity.score+= question.getScore();
            MainActivity.updateScoreTextView();
        }
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        TextView questionText;
        RadioButton option1, option2, option3, option4;
        RadioGroup optionsRadioGroup;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            questionText = itemView.findViewById(R.id.questionText);
            option1 = itemView.findViewById(R.id.option1);
            option2 = itemView.findViewById(R.id.option2);
            option3 = itemView.findViewById(R.id.option3);
            option4 = itemView.findViewById(R.id.option4);
            optionsRadioGroup = itemView.findViewById(R.id.optionsRadioGroup);
        }
    }
}

