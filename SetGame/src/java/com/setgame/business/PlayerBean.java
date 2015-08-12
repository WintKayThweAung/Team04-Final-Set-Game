package com.setgame.business;

import com.setgame.model.Login;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class PlayerBean {
    
    @PersistenceContext private EntityManager em;  
    
    public boolean authenticate(String playerName, String password)
    {
        TypedQuery<Login> query;
        query = em.createNamedQuery("Login.findAll",Login.class);
        List<Login> result = query.getResultList();
        
        for(Login l : result)
        {
            if(l.getPlayerName().equals(playerName) && l.getPassword().equals(password))
            {
                return true;
            }
        }
            return false;
        
    }
    
    
    public void createacc(String playerName, String password){
        Login login = new Login();
        login.setPlayerName(playerName);
        login.setPassword(password);
        
        em.persist(login);
        
    }
            
}
