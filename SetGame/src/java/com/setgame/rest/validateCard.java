/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.setgame.rest;

import com.setgame.business.CardBean;
import com.setgame.model.Card;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.sse.OutboundEvent;

/**
 *
 * @author Nu Nu
 */
@WebServlet("/validateCard")
public class validateCard extends HttpServlet{

    
    @Inject CardBean cardBean;
    @Inject private CardResult cardresult;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer Card1=Integer.parseInt(req.getParameter("card1"));
        Integer Card2=Integer.parseInt(req.getParameter("card2"));
        Integer Card3=Integer.parseInt(req.getParameter("card3"));
        Integer gameid=Integer.parseInt(req.getParameter("gameid"));
        
        System.out.println("Card1 >>>"+Card1);  
        System.out.println("Card2 >>>"+Card2); 
        System.out.println("Card3 >>>"+Card3); 
        
        
       List<Card> threecard = new ArrayList<Card>();
       
       HttpSession session = req.getSession();
       session.setAttribute("cardno1session", Card1);
       session.setAttribute("cardno2session", Card2);
       session.setAttribute("cardno3session", Card3);
       
       threecard=cardBean.Rules(gameid, Card1, Card2, Card3);
        
        System.out.println("CardBean three cards length new card and correct card also >>>>"+threecard.size());    
        for (Card threecard1 : threecard) {
            System.out.println("CardBean three cards value" + threecard1.getCardId() +" " + threecard1.getColour() +" " + threecard1.getNumber() +" " + threecard1.getShade() +" " + threecard1.getShape());
        }
      
        JsonArrayBuilder builder=Json.createArrayBuilder();        
        if(threecard!=null)
        {
            for(Card c1:threecard)
            {
                builder.add(c1.toJson());                  
            }           
   
        JsonObject jo = Json.createObjectBuilder().add("Cards",builder.build()).build();
        
            OutboundEvent data;
            data = new OutboundEvent.Builder()
                    .data(JsonObject.class,jo)
                    .mediaType(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        cardresult.send(data);
        
        //This is for gameid plus.
        //cardresult.send(gameid,data);
        }      
    
    }
}
