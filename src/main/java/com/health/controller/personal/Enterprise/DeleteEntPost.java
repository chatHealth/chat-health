package com.health.controller.personal.Enterprise;

import com.health.dao.PostDao;
import com.health.util.ScriptWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteEntPost", value = "/post/delete-ent")
public class DeleteEntPost extends HttpServlet {
    PostDao postDao = PostDao.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        int result;
        result = postDao.deletePost(no);
        if (result > 0) {
            ScriptWriter.alertAndGo(response, "삭제 완료", "../personal/enterprise-post");
        } else {
            ScriptWriter.alertAndBack(response,"오류. 잠시 후 다시 시도해주세요");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
