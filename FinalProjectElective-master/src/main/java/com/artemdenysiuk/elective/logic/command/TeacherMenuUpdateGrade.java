package com.artemdenysiuk.elective.logic.command;

import com.artemdenysiuk.elective.exception.DBException;
import com.artemdenysiuk.elective.logic.UserManager;
import com.artemdenysiuk.elective.model.GradeBook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TeacherMenuUpdateGrade implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String idStudent = req.getParameter("idStudent");
        Long studentId = Long.parseLong(idStudent);

        String idCourse = req.getParameter("idCourse");
        Long courseId = Long.parseLong(idCourse);

        GradeBook gradeBook = UserManager.findStudentGradebookByIdCourseIdStudent(studentId, courseId);
        req.setAttribute("gradeBook", gradeBook);
        return "teacherMenuEditGrade.jsp";

    }

}
