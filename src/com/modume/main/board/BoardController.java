package com.modume.main.board;

import javax.servlet.http.HttpServletRequest;

import com.modume.main.ViewRef;
import com.modume.main.utils.Const;

public class BoardController {
	private BoardServices service;

	public BoardController() {
		super();
		service = new BoardServices();
	}

	public String main(HttpServletRequest request) {
		request.setAttribute(Const.TOPVIEW, "/menu/topMenu");
		request.setAttribute(Const.VIEW, "/board/board");
		request.setAttribute(Const.BOTTOMVIEW, "/menu/bottomMenu");
		request.setAttribute(Const.TITLE, "ModumE! - board");
		return ViewRef.TEMP_MAIN;
	}

	public String stream(HttpServletRequest request) {
		request.setAttribute(Const.TOPVIEW, "/menu/topMenu");
		request.setAttribute(Const.VIEW, "/board/stream");
		request.setAttribute(Const.BOTTOMVIEW, "/menu/bottomMenu");
		request.setAttribute(Const.TITLE, "ModumE! - stream");
		return ViewRef.TEMP_MAIN;
	}

	public String search(HttpServletRequest request) {
		request.setAttribute(Const.TOPVIEW, "/menu/topMenu");
		request.setAttribute(Const.VIEW, "/board/search");
		request.setAttribute(Const.BOTTOMVIEW, "/menu/bottomMenu");
		request.setAttribute(Const.TITLE, "ModumE! - search");
		return ViewRef.TEMP_MAIN;
	}

	public String my(HttpServletRequest request) {
		request.setAttribute(Const.TOPVIEW, "/menu/topMenu");
		request.setAttribute(Const.VIEW, "/user/my");
		request.setAttribute(Const.BOTTOMVIEW, "/menu/bottomMenu");
		request.setAttribute(Const.TITLE, "ModumE! - my");
		return ViewRef.TEMP_MAIN;
	}
}
