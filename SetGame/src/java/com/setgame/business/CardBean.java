/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.setgame.business;

import com.setgame.model.Card;
import com.setgame.model.Game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Nu Nu
 */

@Stateless
public class CardBean {
    @PersistenceContext private EntityManager em;
    
     List<Card> cardList;
     //ArrayList<Card> twelveCards;
     Card[] twelveCards;
      Card[] twelveCards1;
     ArrayList<Card> threecard;
     List<Game> gameList=new LinkedList<>();
     Map<Integer,Card[]> displaycard=new HashMap();
     Card[] result1=new Card[12];
     Map<Integer,Card[]> gamemap=new HashMap<>();
     Integer size;
     
    public Card get(Integer cid){        
        return (em.find(Card.class, cid));       
        
    }
    public List<Card> get(){
        TypedQuery<Card> query=em.createNamedQuery("Card.findAll", Card.class);
        List<Card> cardList= query.getResultList();
       
        //return query.getResultList();
        /*Random random1 = new Random();
    
        for (int i = cardList.size() - 1; i >= 0; i--) 
        {
        int j = random1.nextInt(i + 1);

        // swap cards i,j 
        Card card = cardList.get(i);
        cardList.set(i, cardList.get(j));
        cardList.set(j, card);
        }*/
       
        Collections.shuffle(cardList);
        return cardList;
    }
    
    public Card[] getTwelveCards(){
        
        TypedQuery<Card> query=em.createNamedQuery("Card.findAll", Card.class);
        cardList= query.getResultList();
        //twelveCards=new ArrayList<Card>(){};
        twelveCards=new Card[12];
        Random random1 = new Random();
    
        for (int i = cardList.size() - 1; i >= 0; i--) 
        {
        int j = random1.nextInt(i + 1);

        // swap cards i,j 
        Card card = cardList.get(i);
        cardList.set(i, cardList.get(j));
        cardList.set(j, card);
        }     
       // Collections.shuffle(cardList);
        
        System.out.println("Looping in cardList");
        for(int a = 0; a < cardList.size(); a++){
         
            System.out.println("Card " + a + " " + cardList.get(a).getCardId());
        }
        System.out.println("Adding to twelve cards");
        
       
        for(int i=0;i<12;i++)
        {   
           Card c = cardList.get(0);
           System.out.println("Card Added " + c.getCardId());
           Card c1 = new Card();
           c1.setCardId(c.getCardId());
           c1.setColour(c.getColour());
           c1.setImageUrl(c.getImageUrl());
           c1.setNumber(c.getNumber());
           c1.setShade(c.getShade());
           c1.setShape(c.getShape());
           //twelveCards.add(i, c1);
           twelveCards[i]=c1;
            //twelveCards.add(cardList.get(i));   
           cardList.remove(c);
            //System.out.println(twelveCards.get(i)); 
            
        } 
        System.out.println("Looping in twelve cards");
        for(int i=0;i<12;i++)
        { 
            //System.out.println("Card " + i + " " + twelveCards.get(i));
            System.out.println("Card " + i + " " + twelveCards[i]);
        }
        
        System.out.println("After removing...");
        for(int i=0; i<cardList.size();i++)
        {
            System.out.println(cardList.get(i));
        }
        return twelveCards;
    }  
    
    public ArrayList<Card> Rules(int gameid,int no1,int no2,int no3){
        List<Card> deck=new ArrayList<Card>();
       boolean flag=false;
       boolean b=true;
       twelveCards1 =gamemap.get(gameid);
       if(b==true)
       {
           deck=get();
           for(int i=0;i<twelveCards1.length;i++)
           {
               deck.remove(twelveCards1[i]);
           }
           b=false;
       }
         Card card1=(Card)twelveCards1[no1];
         Card card2=(Card)twelveCards1[no2];
         Card card3=(Card)twelveCards1[no3];  
         
         System.out.println("3 Card from card bean");
         System.out.println("card1>>"+card1.getShape()+" "+card1.getColour()+" "+card1.getNumber()+" "+card1.getShade());
         System.out.println("card2>>"+card2.getShape()+" "+card2.getColour()+" "+card2.getNumber()+" "+card2.getShade());
         System.out.println("card3>>"+card3.getShape()+" "+card3.getColour()+" "+card3.getNumber()+" "+card3.getShade());
         
         threecard = new ArrayList<Card>();     
         
         System.out.println("Rules");        
        
         
        //differ color - differ shape - same no  - differ shading or same shading
        if(((!card1.getColour().equals(card2.getColour())) && (!card2.getColour().equals(card3.getColour())) && (!card1.getColour().equals(card3.getColour()))) 
            &&((!card1.getShape().equals(card2.getShape())) && (!card2.getShape().equals(card3.getShape())) &&  (!card1.getShape().equals(card3.getShape()))) 
            &&((card1.getNumber().equals(card2.getNumber())) && (card2.getNumber().equals(card3.getNumber()))&& (card1.getNumber().equals(card3.getNumber()))))
         
                {
                    System.out.println("Flag");
                    flag=true;                    
                    //System.out.println("Congratulations! You have got one set");
                    //show(no1,no2,no3);
                }
         
         //differ color - same shape   - differ no - same shading or differ shading
        else if(((!card1.getColour().equals(card2.getColour())) && (!card2.getColour().equals(card3.getColour())) && (!card1.getColour().equals(card3.getColour()))) 
                    &&((card1.getShape().equals(card2.getShape())) && (card2.getShape().equals(card3.getShape())) && (card1.getShape().equals(card3.getShape()))) 
                    &&((!card1.getNumber().equals(card2.getNumber())) &&  (!card2.getNumber().equals(card3.getNumber())) && (!card1.getNumber().equals(card3.getNumber()))))
                    
                {
                    System.out.println("Flag");
                    flag=true;
                    //System.out.println("Congratulations! You have got one set");
                    //show(no1,no2,no3);
                }
         
         //differ color  - differ shape   - differ no - differ shading or same shading
        else if(((!card1.getColour().equals(card2.getColour(
        ))) && (!card2.getColour().equals(card3.getColour())) && (!card1.getColour().equals(card3.getColour())))
                    &&((!card1.getShape().equals(card2.getShape())) && (!card2.getShape().equals(card3.getShape())) && (!card1.getShape().equals(card3.getShape())))
                    &&((!card1.getNumber().equals(card2.getNumber())) && (!card2.getNumber().equals(card3.getNumber())) && (!card1.getNumber().equals(card3.getNumber()))))
                    
                        {
                            System.out.println("Flag");
                            flag=true;
                            //System.out.println("Congratulations! You have got one set");
                            //show(no1,no2,no3);
                        }
         //differ color  - same shape   - same no - same shading or differ shading
        else if(((!card1.getColour().equals(card2.getColour())) && (!card2.getColour().equals(card3.getColour())) && (!card1.getColour().equals(card3.getColour()))) 
                    &&((card1.getShape().equals(card2.getShape())) && (card2.getShape().equals(card3.getShape())) && (card1.getShape().equals(card3.getShape())))
                    &&((card1.getNumber().equals(card2.getNumber())) && (card2.getNumber().equals(card3.getNumber())) && (card1.getNumber().equals(card3.getNumber()))))
                                
                        {
                            System.out.println("Flag");
                            flag=true;
                            //System.out.println("Congratulations! You have got one set");
                            //show(no1,no2,no3);
                        }
                    
         //differ color - same shape  - differ no  -differ shading
         else if(((!card1.getColour().equals(card2.getColour())) && (!card2.getColour().equals(card3.getColour())) && (!card1.getColour().equals(card3.getColour()))) 
                    &&((card1.getShape().equals(card2.getShape())) && (card2.getShape().equals(card3.getShape())) && (card1.getShape().equals(card3.getShape())))
                    &&((!card1.getNumber().equals(card2.getNumber())) && (!card2.getNumber().equals(card3.getNumber())) && (!card1.getNumber().equals(card3.getNumber())))
                    &&((!card1.getShade().equals(card2.getShade()))&& (!card2.getShade().equals(card3.getShade())) && (!card1.getShade().equals(card3.getShade()))))
                        {
                            System.out.println("Flag");
                            flag=true;
                            //System.out.println("Congratulations! You have got one set");
                            //show(no1,no2,no3);
                        }
         
         //differ color - differ shape  - differ no  -same shading
         //else if(((!card1.getColor().equals(card2.getColor())) && (!card2.getColor().equals(card3.getColor())) && (!card1.getColor().equals(card3.getColor()))) 
                   // &&((!card1.getShape().equals(card2.getShape())) && (!card2.getShape().equals(card3.getShape()) && (!card1.getShape().equals(card3.getShape())))) 
                   // &&((!card1.getNumber().equals(card2.getNumber())) && (!card2.getNumber().equals(card3.getNumber())&& (!card1.getNumber().equals(card3.getNumber()))))
                   // &&((card1.getShading().equals(card2.getShading()))&& (card2.getShading().equals(card3.getShading()))&&(card1.getShading().equals(card3.getShading()))))
                        //{
                            //System.out.println("Congratulations! You have got one set");
                            //show(no1,no2,no3);
                        //}
             
         //same color - same shape - differ no - differ shading or same shading
         else if(((card1.getColour().equals(card2.getColour())) && (card2.getColour().equals(card3.getColour())) && (card1.getColour().equals(card3.getColour()))) 
                    &&((card1.getShape().equals(card2.getShape())) && (card2.getShape().equals(card3.getShape())) && (card1.getShape().equals(card3.getShape()))) 
                    &&((!card1.getNumber().equals(card2.getNumber())) && (!card2.getNumber().equals(card3.getNumber())) && (!card1.getNumber().equals(card3.getNumber())))) 
         
                        {
                            System.out.println("Flag");
                            flag=true;
                            //System.out.println("Congratulations! You have got one set");
                            //show(no1,no2,no3);
                        }
         
         //same color   - differ shape - same no   - same shading or differ shading
         else if(((card1.getColour().equals(card2.getColour())) && (card2.getColour().equals(card3.getColour())) && (card1.getColour().equals(card3.getColour()))) 
                    &&((!card1.getShape().equals(card2.getShape())) && (!card2.getShape().equals(card3.getShape())) && (!card1.getShape().equals(card3.getShape())))
                    &&((card1.getNumber().equals(card2.getNumber())) && (card2.getNumber().equals(card3.getNumber())) && (card1.getNumber().equals(card3.getNumber()))))
                        {
                            System.out.println("Flag");
                            flag=true;
                            //System.out.println("Congratulations! You have got one set");
                            //show(no1,no2,no3);
                        }
         
         //same color  - differ shape   - differ no - same shading or differ shading
         else if(((card1.getColour().equals(card2.getColour())) && (card2.getColour().equals(card3.getColour())) && (card1.getColour().equals(card3.getColour()))) 
                    &&((!card1.getShape().equals(card2.getShape())) && (!card2.getShape().equals(card3.getShape())) && (!card1.getShape().equals(card3.getShape()))) 
                    &&((!card1.getNumber().equals(card2.getNumber())) && (!card2.getNumber().equals(card3.getNumber())) && (!card1.getNumber().equals(card3.getNumber()))))
         
                        {
                            System.out.println("Flag");
                            flag=true;
                            //System.out.println("Congratulations! You have got one set");
                            //show(no1,no2,no3);
                        }
         
         //same color  - same shape   - same no - differ shading
         else if(((card1.getColour().equals(card2.getColour())) && (card2.getColour().equals(card3.getColour())) && (card1.getColour().equals(card3.getColour()))) 
                    &&((card1.getShape().equals(card2.getShape())) && (card2.getShape().equals(card3.getShape())) && (card1.getShape().equals(card3.getShape()))) 
                    &&((card1.getNumber().equals(card2.getNumber())) && (card2.getNumber().equals(card3.getNumber())) && (card1.getNumber().equals(card3.getNumber())))
                    &&((!card1.getShade().equals(card2.getShade())) && (!card2.getShade().equals(card3.getShade())) && (!card1.getShade().equals(card3.getShade()))))
                        { 
                            System.out.println("Flag");
                            flag=true;
                            //System.out.println("Congratulations! You have got one set");
                            //show(no1,no2,no3);
                        }
         //else
         //{
             //System.out.println("Your choice is wrong.Try Again.");
         //}
        
        /* if(flag==true){
            
            //Card[] newcards=show(no1, no2, no3);
            System.out.println("Flag is true");
            
             JsonArrayBuilder builder=Json.createArrayBuilder();
             
              for(Card c:cards)
                {
                    builder.add(c.toJson());    
                    System.out.println("c");
                }                  
               
        JsonObject json = Json.createObjectBuilder().add("cards",builder).build();
        //return (Response.ok(json).build());     
        
        }*/
        
        if(flag==true){
           
            //if(!cardList.isEmpty())
            if(!deck.isEmpty())
            {
               for(int i=0;i<3;i++)
                {
                   System.out.println("three card insert");
                   //Card tmpCard = cardList.get(0);
                   Card tmpCard = deck.get(0);
                    Card c1 = new Card();
                    c1.setCardId(tmpCard.getCardId());
                    c1.setColour(tmpCard.getColour());
                    c1.setImageUrl(tmpCard.getImageUrl());
                    c1.setNumber(tmpCard.getNumber());
                    c1.setShade(tmpCard.getShade());
                    c1.setShape(tmpCard.getShape());
                    System.out.println("Card here " + c1.getCardId());
                    
                    //cardList.remove(0);
                    deck.remove(0);
                    threecard.add(c1);   
                    System.out.println("Success " + i);   
                }
                System.out.println("After removing 3cards...");
                for(int i=0; i<cardList.size();i++)
                {
                    System.out.println("After removing 3cards..."+cardList.get(i));
                }               
            }
            else{
                System.out.println("No Card Left!");               
            }
            
         threecard.add(card1);
         threecard.add(card2);
         threecard.add(card3);
         
         System.out.println("New Cards...");
         
         System.out.println("-> "+threecard.get(0).getNumber()+" "+threecard.get(0).getColour()+" "+threecard.get(0).getShape()+" "+threecard.get(0).getShade());
         System.out.println("-> "+threecard.get(1).getNumber()+" "+threecard.get(1).getColour()+" "+threecard.get(1).getShape()+" "+threecard.get(1).getShade());
         System.out.println("-> "+threecard.get(2).getNumber()+" "+threecard.get(2).getColour()+" "+threecard.get(2).getShape()+" "+threecard.get(2).getShade());
         
         System.out.println();
         
          for(int j=0;j<12;j++)
          {
            if(j==no1)
            {
                 twelveCards1[j]=threecard.get(0);
            }
            
            if(j==no2)
            {
                twelveCards1[j]=threecard.get(1);
            }
            
            if(j==no3)
            {
                twelveCards1[j]=threecard.get(2);
            }
          }
          
          for(int k=0; k<12; k++)
          {
              System.out.println("->>"+k+" "+twelveCards1[k].getNumber()+" "+twelveCards1[k].getColour()+" "+twelveCards1[k].getShape()+" "+twelveCards1[k].getShade());
          }
          
        }
        gamemap.put(gameid,twelveCards1);
        return threecard;
    }
    //Create New Game
     public void create(String description){
         System.out.println("Cardbean.This is a new game.");
         Game g=new Game();
         g.setDescription(description);
         System.out.println("how about --------------------");
                 
         em.persist(g);
        // em.persist(g);
         //em.close();
         System.out.println("This is the end of cardbean.");
         
     }
     //Retrieve all games
     public List<Game> getall(){
         TypedQuery<Game> query=em.createNamedQuery("Game.findAll",Game.class);
          List<Game> gameList= query.getResultList();
          for(int i=0;i<gameList.size();i++)
          {
          System.out.println(gameList.get(i));
          }
         return gameList;
     }

     public void checkCard(Integer gameid)
     {
         gameList=getall();
         for(Game g:gameList)
         {
            gamemap.put(g.getGameId(),getTwelveCards());
         }
         
          for(int j=0;j<gamemap.size();j++)
          {
             Set<Integer> i=gamemap.keySet();
            
             for(int z:i)
             {
                 if(gameid==0)
                 {
                     System.out.println("This is gamemap size."+gamemap.size());
                     size=gamemap.size();
                     result1 =gamemap.get(size);
                 }
                 else if(gameid==z)
                 {
                     size=gameid;
                     result1 =gamemap.get(gameid);
                 } 
             }
         }
       }
     public Integer getCard()
     { 
      System.out.println("SIZE");
      return size;
     }
     
     public Card[] getCardList()
     {
      System.out.println("CARD LIST.");
      return result1;
     }
     
     
     public static boolean isSet(Card card1,Card card2,Card card3){
         //differ color - differ shape - same no  - differ shading or same shading
        if(((!card1.getColour().equals(card2.getColour())) && (!card2.getColour().equals(card3.getColour())) && (!card1.getColour().equals(card3.getColour()))) 
            &&((!card1.getShape().equals(card2.getShape())) && (!card2.getShape().equals(card3.getShape())) &&  (!card1.getShape().equals(card3.getShape()))) 
            &&((card1.getNumber().equals(card2.getNumber())) && (card2.getNumber().equals(card3.getNumber()))&& (card1.getNumber().equals(card3.getNumber()))))
         
                {
                   return(true);
                }
         
         //differ color - same shape   - differ no - same shading or differ shading
        else if(((!card1.getColour().equals(card2.getColour())) && (!card2.getColour().equals(card3.getColour())) && (!card1.getColour().equals(card3.getColour()))) 
                    &&((card1.getShape().equals(card2.getShape())) && (card2.getShape().equals(card3.getShape())) && (card1.getShape().equals(card3.getShape()))) 
                    &&((!card1.getNumber().equals(card2.getNumber())) &&  (!card2.getNumber().equals(card3.getNumber())) && (!card1.getNumber().equals(card3.getNumber()))))
                    
                {
                   return(true);
                }
         
         //differ color  - differ shape   - differ no - differ shading or same shading
        else if(((!card1.getColour().equals(card2.getColour(
        ))) && (!card2.getColour().equals(card3.getColour())) && (!card1.getColour().equals(card3.getColour())))
                    &&((!card1.getShape().equals(card2.getShape())) && (!card2.getShape().equals(card3.getShape())) && (!card1.getShape().equals(card3.getShape())))
                    &&((!card1.getNumber().equals(card2.getNumber())) && (!card2.getNumber().equals(card3.getNumber())) && (!card1.getNumber().equals(card3.getNumber()))))
                    
                        {
                           return(true);
                        }
         //differ color  - same shape   - same no - same shading or differ shading
        else if(((!card1.getColour().equals(card2.getColour())) && (!card2.getColour().equals(card3.getColour())) && (!card1.getColour().equals(card3.getColour()))) 
                    &&((card1.getShape().equals(card2.getShape())) && (card2.getShape().equals(card3.getShape())) && (card1.getShape().equals(card3.getShape())))
                    &&((card1.getNumber().equals(card2.getNumber())) && (card2.getNumber().equals(card3.getNumber())) && (card1.getNumber().equals(card3.getNumber()))))
                                
                        {
                            return(true);
                        }
                    
         //differ color - same shape  - differ no  -differ shading
         else if(((!card1.getColour().equals(card2.getColour())) && (!card2.getColour().equals(card3.getColour())) && (!card1.getColour().equals(card3.getColour()))) 
                    &&((card1.getShape().equals(card2.getShape())) && (card2.getShape().equals(card3.getShape())) && (card1.getShape().equals(card3.getShape())))
                    &&((!card1.getNumber().equals(card2.getNumber())) && (!card2.getNumber().equals(card3.getNumber())) && (!card1.getNumber().equals(card3.getNumber())))
                    &&((!card1.getShade().equals(card2.getShade()))&& (!card2.getShade().equals(card3.getShade())) && (!card1.getShade().equals(card3.getShade()))))
                        {
                            return(true);
                        }
         
         //differ color - differ shape  - differ no  -same shading
         //else if(((!card1.getColor().equals(card2.getColor())) && (!card2.getColor().equals(card3.getColor())) && (!card1.getColor().equals(card3.getColor()))) 
                   // &&((!card1.getShape().equals(card2.getShape())) && (!card2.getShape().equals(card3.getShape()) && (!card1.getShape().equals(card3.getShape())))) 
                   // &&((!card1.getNumber().equals(card2.getNumber())) && (!card2.getNumber().equals(card3.getNumber())&& (!card1.getNumber().equals(card3.getNumber()))))
                   // &&((card1.getShading().equals(card2.getShading()))&& (card2.getShading().equals(card3.getShading()))&&(card1.getShading().equals(card3.getShading()))))
                        //{
                            //System.out.println("Congratulations! You have got one set");
                            //show(no1,no2,no3);
                        //}
             
         //same color - same shape - differ no - differ shading or same shading
         else if(((card1.getColour().equals(card2.getColour())) && (card2.getColour().equals(card3.getColour())) && (card1.getColour().equals(card3.getColour()))) 
                    &&((card1.getShape().equals(card2.getShape())) && (card2.getShape().equals(card3.getShape())) && (card1.getShape().equals(card3.getShape()))) 
                    &&((!card1.getNumber().equals(card2.getNumber())) && (!card2.getNumber().equals(card3.getNumber())) && (!card1.getNumber().equals(card3.getNumber())))) 
         
                        {
                           return(true);
                        }
         
         //same color   - differ shape - same no   - same shading or differ shading
         else if(((card1.getColour().equals(card2.getColour())) && (card2.getColour().equals(card3.getColour())) && (card1.getColour().equals(card3.getColour()))) 
                    &&((!card1.getShape().equals(card2.getShape())) && (!card2.getShape().equals(card3.getShape())) && (!card1.getShape().equals(card3.getShape())))
                    &&((card1.getNumber().equals(card2.getNumber())) && (card2.getNumber().equals(card3.getNumber())) && (card1.getNumber().equals(card3.getNumber()))))
                        {
                            return(true);
                        }
         
         //same color  - differ shape   - differ no - same shading or differ shading
         else if(((card1.getColour().equals(card2.getColour())) && (card2.getColour().equals(card3.getColour())) && (card1.getColour().equals(card3.getColour()))) 
                    &&((!card1.getShape().equals(card2.getShape())) && (!card2.getShape().equals(card3.getShape())) && (!card1.getShape().equals(card3.getShape()))) 
                    &&((!card1.getNumber().equals(card2.getNumber())) && (!card2.getNumber().equals(card3.getNumber())) && (!card1.getNumber().equals(card3.getNumber()))))
         
                        {
                            
                            return(true);
                        }
         
         //same color  - same shape   - same no - differ shading
         else if(((card1.getColour().equals(card2.getColour())) && (card2.getColour().equals(card3.getColour())) && (card1.getColour().equals(card3.getColour()))) 
                    &&((card1.getShape().equals(card2.getShape())) && (card2.getShape().equals(card3.getShape())) && (card1.getShape().equals(card3.getShape()))) 
                    &&((card1.getNumber().equals(card2.getNumber())) && (card2.getNumber().equals(card3.getNumber())) && (card1.getNumber().equals(card3.getNumber())))
                    &&((!card1.getShade().equals(card2.getShade())) && (!card2.getShade().equals(card3.getShade())) && (!card1.getShade().equals(card3.getShade()))))
                        { 
                            return(true);
                        }
        else
             return (false);
     }
}
        
       
    
