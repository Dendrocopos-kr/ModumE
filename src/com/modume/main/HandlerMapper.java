package com.modume.main;

import javax.servlet.http.HttpServletRequest;

import com.modume.main.board.BoardController;
import com.modume.main.error.ErrorController;
import com.modume.main.user.UserController;

public class HandlerMapper {
	private UserController userController;
	private ErrorController errorController;
	private BoardController boardController;
	private MainController mainController;

	public HandlerMapper() {
		super();
		userController = new UserController();
		errorController = new ErrorController();
		boardController = new BoardController();
	}

	public String nav(HttpServletRequest request, String[] uriArr) {
		if (uriArr == null) {
			return errorController.error(request, "400 요청 오류", "페이지를 찾을 수 없습니다.", "경로를 다시 확인해 주십시오.");
		}
		switch (uriArr[2]) {
		case ViewRef.URI_USER:
			switch (uriArr[3]) {
			case "login":
				return userController.login(request);
			case "loginProc":
				return userController.loginProc(request);
			case "logout":
				return userController.logout(request);
			case "join":
				return userController.join(request);
			case "joinProc":
				return userController.joinProc(request);
			case "chkIdProc":
				return userController.ajaxIdChk(request);
			}
			break;
		case ViewRef.URI_BOARD:
			switch (uriArr[3]) {
			case "all":
				return boardController.mainView(request);
			}
			break;
		default:
			return mainController.defaultView(request);
		}

		return errorController.error(request, "404 요청 오류", "페이지를 찾을 수 없습니다.", "경로를 다시 확인해 주십시오.");
	}
}
