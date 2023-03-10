package com.artemdenysiuk.elective.logic.command;

import com.artemdenysiuk.elective.exception.DBException;
import com.artemdenysiuk.elective.logic.UserManager;
import com.artemdenysiuk.elective.model.ProfileCourse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CoursesForTeacherMenu implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String loginSession = (String) req.getSession().getAttribute("login");
        String emptyMess = "";

        List<ProfileCourse> profileCourses = UserManager.findCoursesForTeacher(loginSession);
            if (profileCourses!=null) {
            req.setAttribute("profileCourses", profileCourses);
            return "teacher.jsp";
        }else {
                emptyMess = "You haven't assigned courses";
                req.setAttribute("emptyMess", emptyMess);
                return "teacher.jsp";
            }
    }
}
