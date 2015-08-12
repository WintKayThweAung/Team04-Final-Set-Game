/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.setgame.servlet;

import com.setgame.business.CardBean;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wint
 */
@WebServlet("/allgames")
public class AllGameServlet extends HttpServlet{
    
    @Inject private CardBean cardbean;
   
   @Override
   protected void doGet(HttpServletRequest req,HttpServletResponse resp){
       cardbean.getall();
   }
}

