package com.github.maple_edubook.edubook_android;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MypageFragment extends Fragment {

    private ExpandableListView expandableListView;
    private ExpandablaListAdpater expandableListAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mypage, container, false);

        expandableListView = view.findViewById(R.id.ListView);

        // 데이터 준비
        prepareListData();

        // 어댑터 설정
        expandableListAdapter = new ExpandablaListAdpater(getActivity(), listDataHeader, listDataChild);
        expandableListView.setAdapter(expandableListAdapter);

        // 그룹 클릭 리스너
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // 회전 애니메이션 적용
                ImageView groupIndicator = v.findViewById(R.id.openMenu);
                if (expandableListView.isGroupExpanded(groupPosition)) {
                    ObjectAnimator.ofFloat(groupIndicator, "rotation", 90f, 0f).setDuration(300).start();
                } else {
                    ObjectAnimator.ofFloat(groupIndicator, "rotation", 0f, 90f).setDuration(300).start();
                }
                return false;
            }
        });

        return view;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // 메인 메뉴 추가
        listDataHeader.add("국어");
        listDataHeader.add("영어");
        listDataHeader.add("역사");

        // 서브 메뉴 추가
        List<String> LangMenu = new ArrayList<>();
        LangMenu.add("• 서브메뉴1");
        LangMenu.add("• 서브메뉴2");
        LangMenu.add("• 서브메뉴3");

        List<String> EngMenu = new ArrayList<>();
        EngMenu.add("• 서브메뉴1");
        EngMenu.add("• 서브메뉴2");
        EngMenu.add("• 서브메뉴3");

        List<String> HisMenu = new ArrayList<>();
        HisMenu.add("• 서브메뉴1");
        HisMenu.add("• 서브메뉴2");
        HisMenu.add("• 서브메뉴3");

        listDataChild.put(listDataHeader.get(0), LangMenu); // 메인메뉴1의 서브메뉴
        listDataChild.put(listDataHeader.get(1), EngMenu); // 메인메뉴2의 서브메뉴
        listDataChild.put(listDataHeader.get(2), HisMenu); // 메인메뉴3의 서브메뉴
    }
}
