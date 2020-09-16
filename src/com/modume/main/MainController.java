package com.modume.main;

import javax.servlet.http.HttpServletRequest;

import com.modume.main.utils.Const;

public class MainController {

	public String defaultView(HttpServletRequest request) {
		request.setAttribute(Const.VIEW, "/modume/main");
		request.setAttribute(Const.TITLE, "ModumE!");		
		return ViewRef.TEMP_MAIN;
	}

}
