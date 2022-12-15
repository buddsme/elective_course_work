package com.artemdenysiuk.elective.logic.command;

import com.artemdenysiuk.elective.exception.DBException;
import com.artemdenysiuk.elective.logic.CourseManager;
import com.artemdenysiuk.elective.model.Course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AllCoursesCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        List<Course> courseList = CourseManager.findAllCourses();
        req.setAttribute("listCourses", courseList);
        return "allCourses.jsp";
    }
}
