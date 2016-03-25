package com.comvaca.schooltoolbox.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.comvaca.schooltoolbox.R;
import com.comvaca.schooltoolbox.adpaters.TopicAdapter;
import com.comvaca.schooltoolbox.models.Topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainFragment extends BaseFragment {

    private GridView gridTopic;
    private ArrayList<Topic> topics;
    private TopicAdapter topicAdapter;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gridTopic = (GridView) view.findViewById(R.id.grid_topic);

        topics = new ArrayList<Topic>();
        topicAdapter = new TopicAdapter(getActivity(), topics);
        gridTopic.setAdapter(topicAdapter);

        showTopics();
    }

    private void showTopics() {
        int[] res = new int[] {R.drawable.ic_link};
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            topics.add(new Topic(res[random.nextInt(res.length)], "Topic " + i));
        }
        topicAdapter.notifyDataSetChanged();
    }
}