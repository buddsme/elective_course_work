package com.artemdenysiuk.elective.logic.command;

import com.artemdenysiuk.elective.exception.DBException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    String execute(HttpServletRequest req, HttpServletResponse resp) throws DBException;
}
