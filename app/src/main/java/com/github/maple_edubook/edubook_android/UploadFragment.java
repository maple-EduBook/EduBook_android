package com.github.maple_edubook.edubook_android;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class UploadFragment extends Fragment {
    Bitmap bitmap;
    Button camBtn;
    Button selectBtn;
    Button uploadBtn;
    ImageView imgView;
    ImageView icon;
    int SELECT_PICTURE = 200;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upload, container, false);

        camBtn = view.findViewById(R.id.camera_btn);
        selectBtn = view.findViewById(R.id.selectimg_btn);
        uploadBtn = view.findViewById(R.id.upload_btn);
        imgView = view.findViewById(R.id.imageView);
        icon = view.findViewById(R.id.img_icon);

        camBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                activityResultPicture.launch(intent);
                icon.setVisibility(View.INVISIBLE);
            }
        });
        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
                icon.setVisibility(View.INVISIBLE);
            }
        });
        // todo: uploadBtn을 눌렀을때 이미지 업로드
        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SubjectselcetActivity.class); //fragment라서 activity intent와는 다른 방식
                startActivity(intent);
            }
        });
        return view;
    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImageUri);
                        imgView.setImageURI(selectedImageUri);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private final ActivityResultLauncher<Intent> activityResultPicture = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Bundle extras = result.getData().getExtras();
                    bitmap = (Bitmap) extras.get("data");
                    imgView.setImageBitmap(bitmap);
                }
            }
        }
    );
}