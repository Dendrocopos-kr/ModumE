package com.modume.main.board;

import javax.servlet.http.HttpServletRequest;

import com.modume.main.Const;
import com.modume.main.ViewRef;

public class BoardController {
	private BoardServices service;

	public BoardController() {
		super();
		service = new BoardServices();
	}

	public String mainView(HttpServletRequest request) {
		request.setAttribute(Const.VIEW, "/modume/main");
		request.setAttribute(Const.TITLE, "ModumE!");		
		return ViewRef.TEMP_TYPE_1;
	}

}
