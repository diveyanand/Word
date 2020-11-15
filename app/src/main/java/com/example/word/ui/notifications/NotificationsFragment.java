package com.example.word.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.word.R;
import com.example.word.data.DataUtils;
import com.example.word.data.model.Challenge;
import com.example.word.handleInvitation.ReactionActivity;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        DataUtils.setCurrUser("ruisong1998");
        Challenge[] invitations = DataUtils.getPendingInvitation(DataUtils.getCurrUser());

        TextView description1 = (TextView) root.findViewById(R.id.notification_description1);
        TextView date1 = (TextView) root.findViewById(R.id.notification_date1);
        TextView challenger1 = (TextView) root.findViewById(R.id.notification_challenger1);
        TextView description2 = (TextView) root.findViewById(R.id.notification_description2);
        TextView date2 = (TextView) root.findViewById(R.id.notification_date2);
        TextView challenger2 = (TextView) root.findViewById(R.id.notification_challenger2);
        LinearLayout challenge1 = (LinearLayout) root.findViewById(R.id.notification_1);
        LinearLayout challenge2 = (LinearLayout) root.findViewById(R.id.notification_2);

        challenge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), ReactionActivity.class);
                intent.putExtra("ID", invitations[0].getId());
                startActivity(intent);
            }
        });

        description1.setText(invitations[0].getDescription());

        if (invitations[0].getStatus() == Challenge.SEND)
            challenger1.setText("@" + invitations[0].getChallenger() + "'s Challenged you:");
        else
            challenger1.setText("@" + invitations[0].getChallenged() + "'s Counter Challenge:");
        date1.setText(invitations[0].getEndDate());

        return root;
    }
}