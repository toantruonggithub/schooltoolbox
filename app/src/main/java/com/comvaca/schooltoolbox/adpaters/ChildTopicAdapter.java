package com.comvaca.schooltoolbox.adpaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.comvaca.schooltoolbox.R;
import com.comvaca.schooltoolbox.models.Topic;

import java.util.List;

public class ChildTopicAdapter extends BaseAdapter {

  private List<Topic> topics;
  private Context context;
  private LayoutInflater inflater;

  public ChildTopicAdapter(Context context, List<Topic> topics) {
    this.topics = topics;
    this.context = context;
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    return topics.size();
  }

  @Override
  public Object getItem(int position) {
    return topics.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    TopicHolder holder;
    if (convertView == null) {
      convertView = inflater.inflate(R.layout.item_topic_child, parent, false);
      holder = new TopicHolder(convertView);
      convertView.setTag(holder);
    } else {
      holder = (TopicHolder) convertView.getTag();
    }
    Topic topic = (Topic) getItem(position);
    holder.ivThumb.setImageResource(topic.getIconRes());
    holder.tvName.setText(topic.getName());
    return convertView;
  }

  public static class TopicHolder {
    private ImageView ivThumb;
    private TextView tvName;

    public TopicHolder(View view) {
      ivThumb = (ImageView) view.findViewById(R.id.topic_thumb);
      tvName = (TextView) view.findViewById(R.id.topic_name);
    }
  }
}
