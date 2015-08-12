/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.setgame.servlet;

import com.setgame.business.CardBean;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nu Nu
 */
@WebServlet("/newgame")
public class GameServlet extends HttpServlet{
    @EJB private CardBean cardbean;
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp){
        System.out.println("This is a new game >>>>>>>>");
        String description=req.getParameter("description");
        System.out.println("Description"+req.getParameter("description"));
        //cardbean.get();
        cardbean.create(description);
    }
}
