package com.codecool.web.servlet;

import com.codecool.web.model.Subscription;
import com.codecool.web.service.SubscriptionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/subscriptionServlet")
public class SubscriptionServlet extends HttpServlet {

    private final SubscriptionService service = new SubscriptionService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Subscription subs = new Subscription(req.getParameter("name"),req.getParameter("email"));

//        String name = req.getParameter("name");
//        String email = req.getParameter("email");
//
//        req.setAttribute("name",name);
//        req.setAttribute("email",email);
//        req.getRequestDispatcher("/subscription.jsp").forward(req, resp);

        if (subs.getName().equals("") || subs.getEmail().equals("")) {
            req.setAttribute("subscription",service.subscribeFailed());
            req.getRequestDispatcher("/subscription.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("subscription",service.subscribeSuccess());
            req.getRequestDispatcher("/subscription.jsp").forward(req, resp);
        }
    }
}
