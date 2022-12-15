package com.artemdenysiuk.elective.logic.command;

import com.artemdenysiuk.elective.exception.DBException;
import com.artemdenysiuk.elective.logic.UserManager;
import com.artemdenysiuk.elective.model.GradeBook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TeacherMenuCourseDetails implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String idCourse = req.getParameter("idCourse");
        Long id = Long.parseLong(idCourse);
        List<GradeBook> gradeBookList = UserManager.findStudentsFromGradeBook(id);
        req.setAttribute("gradeBookList", gradeBookList);
        return "teacherMenuStudentsGrade.jsp";
    }
}
