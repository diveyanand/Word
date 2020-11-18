package com.example.word.ui.newchallenge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.word.R;

import java.util.List;

public class NewChallengeFragment extends Fragment {

    private NewChallengeViewModel newChallengeViewModel;

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
        return root;
    }
}