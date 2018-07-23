package com.example.android.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {
    private static final String DATETIME_SEPARATOR = "T";
    private static final String Title_SEPARATOR = "|";

    String CurrentDate;

    public NewsAdapter(Context context, ArrayList<News> New) {
        super(context, 0, New);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position < getCount()) {
            News currentNews = getItem(position);

            holder.SectionView.setText(currentNews.getmSection());


            if (currentNews.getmImageUrl() != "") {
                Picasso.get().load(currentNews.getmImageUrl()).into(holder.TopicImage);
            } else {
                holder.TopicImage.setImageResource(R.drawable.no_image);
            }

            String DateTime = currentNews.getmDateTime();
            if (DateTime.contains(DATETIME_SEPARATOR)) {
                String[] parts = DateTime.split(DATETIME_SEPARATOR);
                CurrentDate = parts[0];
            }
            holder.DateView.setText(CurrentDate);

            String contributor = currentNews.getmContributor();
            holder.ContributorView.setText(contributor);

            String Title = currentNews.getmTitle();
            if (Title.contains(currentNews.getmContributor())) {
                if (Title.contains(Title_SEPARATOR)) {
                    Title = Title.replace(Title_SEPARATOR, "");
                    Title = Title.replace(currentNews.getmContributor(), "");
                }
            }
            holder.TitleView.setText(Title);
        }
        return convertView;
    }

    public static class ViewHolder {
        private TextView SectionView;
        private TextView ContributorView;
        private TextView DateView;
        private ImageView TopicImage;
        private TextView TitleView;

        public ViewHolder(View itemView) {
            SectionView = itemView.findViewById(R.id.section);
            ContributorView = itemView.findViewById(R.id.contributor);
            DateView = itemView.findViewById(R.id.date);
            TopicImage = itemView.findViewById(R.id.topic_image);
            TitleView = itemView.findViewById(R.id.title);
        }
    }
}
