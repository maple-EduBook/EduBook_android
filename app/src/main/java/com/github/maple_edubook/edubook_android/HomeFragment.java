package com.github.maple_edubook.edubook_android;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    PastStudyAdapter adapter = new PastStudyAdapter();
    String title, subject, date;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //todo: 데이터 베이스 설정 음음
        title = "AAA에 관한 정리";
        subject = "역사";
        date = "2024.08.01";
        adapter.addItem(new PastStudyAdapter.Item(title,"과목 : " + subject,date));
        adapter.addItem(new PastStudyAdapter.Item(title,"과목 : " + subject,date));
        adapter.addItem(new PastStudyAdapter.Item(title,"과목 : " + subject,date));
        adapter.addItem(new PastStudyAdapter.Item(title,"과목 : " + subject,date));
        adapter.notifyDataSetChanged();

        return view;
    }
}

