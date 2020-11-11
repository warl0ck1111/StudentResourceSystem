package com.warl0ck.studentresource.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.warl0ck.studentresource.model.Question;

import java.util.List;

public class QuestionRecyclerViewAdapter extends RecyclerView.Adapter<MyVH>{

    private String TAG = "QuestionRecyclerViewAdapter";

    List<Question> Questions ;

    public List<Question> getQuestions() {
        return Questions;
    }

    public void setQuestions(List<Question> questions) {
        Questions = questions;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_row,viewGroup ,false);
        MyVH recyclerViewHolder = new MyVH(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {


        holder.update(position, Questions.get(position));


    }



    @Override
    public int getItemCount() {
        if (Questions == null){
            return 0;
        }
        else
            return Questions.size();
    }

}

class MyVH extends RecyclerView.ViewHolder {

    TextView ActualQuestion, answerPreview, tvTimeStamp, displayName;
    ImageView profilePic;
    ImageButton ViewBtn;
    int position;


    public MyVH(@NonNull View view) {

        super(view);
//        answerPreview = view.findViewById(R.id.answerPreview);
//        ActualQuestion = view.findViewById(R.id.ActualQuestion);
//        tvTimeStamp = view.findViewById(R.id.tvTimeStamp);
//        ViewBtn = view.findViewById(R.id.viewBtn);
//        profilePic = view.findViewById(R.id.profilePic);

    }

    void update(int position, Question question) {

        this.position = position;

        answerPreview.setText(question.getApprovedAnswer().getDescription());
        ActualQuestion.setText(question.getQuestionTitle());
        tvTimeStamp.setText(question.getTimestamp().toString());
        ViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //todo: intent for viewing the question and list of answers as well
            }
        });

        //userImage.setImageResource(question.getUserImageResId());



//
//        Log.d(TAG, "onResponse: ID" + question.getId());
//        Log.d(TAG, "onResponse: title" + question.getQuestionTitle());
//        Log.d(TAG, "onResponse: Description" + question.getDescription());
//        Log.d(TAG, "onResponse: Passwprd" + question.getUser());
//        Log.d(TAG, "onResponse: Email" + user.getEmail());

    }
}



