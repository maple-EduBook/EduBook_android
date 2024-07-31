package com.github.maple_edubook.edubook_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PastStudyAdapter extends RecyclerView.Adapter<PastStudyAdapter.ViewHolder> {
    public ArrayList<Item> items = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title, date, subject;

        public ViewHolder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.title);
            date = view.findViewById(R.id.date);
            subject = view.findViewById(R.id.subject);
        }
        public void setItem(Item item){
            title.setText(item.title);
            subject.setText(item.subject);
            date.setText(item.date);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_paststudy, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Item item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Item item){
        items.add(item);
    }
    public static class Item{
        String title, date, subject;

        public Item(Item item){
            this(item.title, item.subject, item.date);
        }

        public Item(String title, String subject, String date){
            this.title = title;
            this.subject = subject;
            this.date = date;
        }
    }
}
