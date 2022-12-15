package com.artemdenysiuk.elective.logic.command;

import com.artemdenysiuk.elective.exception.DBException;
import com.artemdenysiuk.elective.logic.CourseManager;

import com.artemdenysiuk.elective.model.ProfileCourse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AllTeachersForAdminMenuCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        List<ProfileCourse> courses = CourseManager.selectListTeachersAssignedCourse();
        req.setAttribute("coursesList", courses);
        return "allTeachers.jsp";
    }
}
