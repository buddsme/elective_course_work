package com.artemdenysiuk.elective.logic.command;

import com.artemdenysiuk.elective.exception.DBException;
import com.artemdenysiuk.elective.logic.CourseManager;
import com.artemdenysiuk.elective.model.Course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditCourseCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String idCourse = req.getParameter("idCourse");
        Long id = Long.parseLong(idCourse);

        Course course = CourseManager.findEditCourse(id);
        req.setAttribute("courseForEdit", course);
        return "approveEditCourse.jsp";
    }
}
