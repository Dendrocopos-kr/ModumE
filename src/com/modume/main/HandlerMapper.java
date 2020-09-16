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

	public String nav(HttpServletRequest request) {

		System.out.println(request.getRequestURI());
		String[] uriArr = request.getRequestURI().split("/");
		
		if (uriArr == null || uriArr.length < 3) {
			return errorController.error(request, "400 요청 오류", "페이지를 찾을 수 없습니다.", "경로를 다시 확인해 주십시오.");
		}
		switch (uriArr[1]) {
		case ViewRef.URI_USER:
			switch (uriArr[2]) {
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
			switch (uriArr[2]) {
			case "main":
				return boardController.main(request);
			case "stream":
				return boardController.stream(request);
			case "search":
				return boardController.search(request);
			case "my":
				return boardController.my(request);
			}
			break;
		}

		return errorController.error(request, "404 요청 오류", "페이지를 찾을 수 없습니다.", "경로를 다시 확인해 주십시오.");
	}
}
