package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

public class MemberController {

	public void insertMember(Member m) {

		int result = new MemberDao().insertMember(m);

		if (result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원가입되었습니다.");
		} else {
			new MemberMenu().displayFail("회원가입에 실패했습니다.");
		}
	}

	public void selectList() {

		ArrayList<Member> list = new MemberDao().selectList();

		if (list.isEmpty()) {
			new MemberMenu().displayNoData("전체 회원에 대한 조회결과 없습니다.");
		} else {
			new MemberMenu().displayMemberList(list);
		}

	}

//	public void selectByUserId(String userId) {
//
//		Member m = new MemberDao().selectByUserId(userId);
//
//		if (m != null) { // 조회가되었을 경우
//			new MemberMenu().displayMember(m);
//		} else { // 조회가 안됐다
//			new MemberMenu().displayNoData("조회된 데이터가 없습니다.");
//		}
//	}
}
