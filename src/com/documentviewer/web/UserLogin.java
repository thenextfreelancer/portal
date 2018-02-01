package com.documentviewer.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

//import org.apache.commons.codec.binary.Base64;

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 3140984858917397618L;
	public static final String INVALID_USER_PORPASSWORD = "Invalid user name or password.";

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String result;
		// String dbUserPassword = "";
		String loginUsername = request.getParameter("loginUsername");
		String loginPassword = request.getParameter("loginPassword");
		// HttpSession session = request.getSession();
		if (null != loginUsername && loginUsername.length() > 0 && null != loginPassword
				&& loginPassword.length() > 0) {
			// String authorizationHeaderForCurrentUser = new String(
			// Base64.encodeBase64((loginUsername + ":" +
			// dbUserPassword).getBytes()));

		}
		response.setContentType(MediaType.APPLICATION_JSON);
	}

	protected void processSignOutRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result;
		HttpSession session = request.getSession();
		try {
			session.removeAttribute("userJson");
			session.invalidate();
			result = "{success:true,loguotMessage:'User is logged out successfully.'}";
		} catch (Exception e) {
			result = "{success:false,errors:{reason:'Problem in logging out user.'}}";
		}
		response.setContentType(MediaType.APPLICATION_JSON);
		response.getWriter().write(result);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String signOutUser = request.getParameter("signOutUser");
		if (signOutUser == null) {
			processRequest(request, response);
		} else {
			processSignOutRequest(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
