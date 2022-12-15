package com.artemdenysiuk.elective.logic.command;

import com.artemdenysiuk.elective.exception.DBException;
import com.artemdenysiuk.elective.logic.UserManager;
import com.artemdenysiuk.elective.model.Profile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AllStudentsCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        List<Profile> studentsList = UserManager.selectAllStudents();
        int result = 0;

        for (int i = 1; i < studentsList.size(); i++) {
            result = studentsList.get(i).getBlockStatus();
            if (result == 0) {
                studentsList.get(i).setBlockStringStatus("Un Block");
            } else if (result == 1) {
                studentsList.get(i).setBlockStringStatus("Block");
            }
        }

        req.setAttribute("studentsList", studentsList);
        return "allStudents.jsp";
    }
}
