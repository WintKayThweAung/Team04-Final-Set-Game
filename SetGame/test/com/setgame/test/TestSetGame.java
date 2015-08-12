/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.setgame.test;

import com.setgame.model.Card;
import static com.setgame.test.Constants.*;
import org.junit.Test;

/**
 *
 * @author Nu Nu
 */
public class TestSetGame {
    
    @Test
    public void happyCase(){
        Card c1=new Card(SHAPE_OVAL, Shade_OUTLINED,COLOR_RED, NUMBER_ONE);
        Card c2=new Card(SHAPE_OVAL, Shade_OUTLINED,COLOR_GREEN , NUMBER_ONE);
        Card c3=new Card(SHAPE_OVAL, Shade_OUTLINED,COLOR_PURPLE , NUMBER_ONE);
    }
}
