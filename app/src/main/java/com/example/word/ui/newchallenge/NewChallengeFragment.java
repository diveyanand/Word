package com.example.word.ui.newchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.word.MainActivity;
import com.example.word.R;
import com.example.word.data.DataUtils;

import java.util.List;

public class NewChallengeFragment extends Fragment implements View.OnClickListener {

    private NewChallengeViewModel newChallengeViewModel;

    private String username;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newChallengeViewModel =
                new ViewModelProvider(this).get(NewChallengeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_new_challenge, container, false);
//        final TextView textView = root.findViewById(R.id.text_new_challenge);
//        ListView listView = root.findViewById(R.id.new_challenge_friend_list);
        newChallengeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

//        username = getActivity().getIntent().getExtras().getString("username");
        username = DataUtils.getCurrUser();
        CardView friend0 = (CardView) root.findViewById(R.id.new_challenge_friend0);
        CardView friend1 = (CardView) root.findViewById(R.id.new_challenge_friend1);
        CardView friend2 = (CardView) root.findViewById(R.id.new_challenge_friend2);
        CardView friend3 = (CardView) root.findViewById(R.id.new_challenge_friend3);
        CardView friend4 = (CardView) root.findViewById(R.id.new_challenge_friend4);
        CardView friend5 = (CardView) root.findViewById(R.id.new_challenge_friend5);

        friend0.setOnClickListener(this);
        friend1.setOnClickListener(this);
        friend2.setOnClickListener(this);
        friend3.setOnClickListener(this);
        friend4.setOnClickListener(this);
        friend5.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
//        Button button = (Button) view;
        CardView cardView = (CardView) view;
        LinearLayout ll1 = (LinearLayout) cardView.getChildAt(0);
        LinearLayout ll2 = (LinearLayout) ll1.getChildAt(1);
        TextView tv1 = (TextView) ll2.getChildAt(0);
        String friendName = tv1.getText().toString();

        Intent intent = new Intent(getContext(), NewChallengeActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("friendName", friendName);
        getContext().startActivity(intent);

    }
}