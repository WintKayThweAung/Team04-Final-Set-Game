/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.setgame.test;

import com.setgame.business.CardBean;
import com.setgame.model.Card;
import static org.junit.Assert.*;
import org.junit.Test;
//import assignment.SetGame;
/**
 *
 * @author wint
 */
public class TestGame {
    //private Object SetGame;
   
    
    @Test
    public void checkCorrect(){
        Card c = new Card("squiggle","solid","red","one");
        Card c1= new Card("squiggle","solid","red","two");
        Card c2 = new Card("squiggle","solid","red","three");
        assertTrue("We have a set.",CardBean.isSet(c,c1,c2));
    }
    
    @Test
    public void checkAllDifferent(){
        Card c = new Card("squiggle","solid","red","one");
        Card c1= new Card("diamond","outlined","green","two");
        Card c2 = new Card("oval","striped","purple","three");
        assertTrue("We have a set.",CardBean.isSet(c,c1,c2));
    }
     @Test
    public void checkDifferentShape(){
        Card c = new Card("squiggle","solid","red","one");
        Card c1= new Card("diamond","solid","red","one");
        Card c2 = new Card("oval","solid","red","one");
        assertTrue("We have a set.",CardBean.isSet(c,c1,c2));
    }
    @Test
    public void checkSameNo(){
        Card c = new Card("squiggle","solid","purple","three");
        Card c1= new Card("diamond","outlined","green","three");
        Card c2 = new Card("oval","striped","red","three");
        assertTrue("We have a set.",CardBean.isSet(c,c1,c2));
    }
    @Test
    public void checkDifferentColour(){
        Card c = new Card("squiggle","solid","purple","one");
        Card c1= new Card("squiggle","solid","red","two");
        Card c2 = new Card("squiggle","solid","green","three");
        assertTrue("We have a set.",CardBean.isSet(c,c1,c2));
    }
    @Test
    public void checkAllDifferentexceptShape(){
        Card c = new Card("squiggle","solid","purple","one");
        Card c1= new Card("squiggle","outlined","red","two");
        Card c2 = new Card("squiggle","striped","green","three");
        assertTrue("We have a set.",CardBean.isSet(c,c1,c2));
    }
    //Uncorrect Case
    @Test
    public void checkUnCorrect(){
        Card c = new Card("squiggle","solid","red","one");
        Card c1= new Card("squiggle","solid","red","two");
        Card c2 = new Card("squiggle","solid","blue","three");
        assertFalse("We don't have a set.",CardBean.isSet(c,c1,c2));
    }
    @Test
    public void checkTwoCardSame(){
        Card c = new Card("squiggle","striped","green","two");
        Card c1= new Card("diamond","striped","green","two");
        Card c2 = new Card("oval","striped","blue","two");
        assertFalse("We don't have a set.",CardBean.isSet(c,c1,c2));
    }
}
