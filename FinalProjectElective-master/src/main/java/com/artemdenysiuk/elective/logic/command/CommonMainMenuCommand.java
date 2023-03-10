package com.artemdenysiuk.elective.logic.command;

import com.artemdenysiuk.elective.exception.DBException;
import com.artemdenysiuk.elective.logic.CourseManager;
import com.artemdenysiuk.elective.model.ProfileCourse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CommonMainMenuCommand implements Command {

    private static final int shift = 0;

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        String commandParam = req.getParameter("command");
        String paramPage = req.getParameter("page");
        String paramPageSize = req.getParameter("pageSize");

        int page = Integer.parseInt(paramPage);
        int pageSize = Integer.parseInt(paramPageSize);

            List<ProfileCourse> courseList = CourseManager.findAllCoursesForMainMenu(pageSize*(page-1), pageSize);
            int size = CourseManager.getCoursesSize();

        int minPossible = Math.max(page - shift, 1);

        int pageCount = (int)Math.ceil(size*1.0/pageSize);
        int maxPagePossible = Math.min(page + shift, pageCount);


        req.setAttribute("commandParam", commandParam);
        req.setAttribute("courseList", courseList);
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("page", page);
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("minPossible", minPossible);
        req.setAttribute("maxPagePossible", maxPagePossible);


//        req.getSession().setAttribute("currentPage", "mainMenu.jsp");


        return "mainMenu.jsp";
    }
}
