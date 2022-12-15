package com.artemdenysiuk.elective.logic.command;

import com.artemdenysiuk.elective.exception.DBException;
import com.artemdenysiuk.elective.logic.UserManager;
import com.artemdenysiuk.elective.model.Profile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInfoMenuCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String loginSession = (String) req.getSession().getAttribute("login");

        Profile student = UserManager.findStudentByLogin(loginSession);
        req.setAttribute("student", student);
        return "adminInfoMenu.jsp";
    }

}
