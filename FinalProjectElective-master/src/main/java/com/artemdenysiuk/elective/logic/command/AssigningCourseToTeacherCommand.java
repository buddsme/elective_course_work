package com.artemdenysiuk.elective.logic.command;

import com.artemdenysiuk.elective.exception.DBException;
import com.artemdenysiuk.elective.logic.CourseManager;
import com.artemdenysiuk.elective.model.Course;
import com.artemdenysiuk.elective.model.ProfileCourse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AssigningCourseToTeacherCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String teacherId = req.getParameter("idProfile");
        Long idTeach = Long.parseLong(teacherId);

        String courseId = req.getParameter("idCourse");
        Long idCour = Long.parseLong(courseId);

        ProfileCourse assigningTeacherCourse = CourseManager.assigningTeacherNewCourse(idTeach);
        List<Course> dropdownCourseList = CourseManager.findAllCoursesForAssigning();  //findAllCourses();

        req.setAttribute("assigningTeacherCourse", assigningTeacherCourse);
        req.setAttribute("dropdownCourseList", dropdownCourseList);
        return "assigningTeacherToCourse.jsp";
    }
}
