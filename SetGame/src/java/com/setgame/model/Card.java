/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.setgame.model;

import java.io.Serializable;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nu Nu
 */
@Entity
@Table(name = "card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Card.findAll", query = "SELECT c FROM Card c"),
    @NamedQuery(name = "Card.findByCardId", query = "SELECT c FROM Card c WHERE c.cardId = :cardId"),
    @NamedQuery(name = "Card.findByImageUrl", query = "SELECT c FROM Card c WHERE c.imageUrl = :imageUrl"),
    @NamedQuery(name = "Card.findByShape", query = "SELECT c FROM Card c WHERE c.shape = :shape"),
    @NamedQuery(name = "Card.findByShade", query = "SELECT c FROM Card c WHERE c.shade = :shade"),
    @NamedQuery(name = "Card.findByColour", query = "SELECT c FROM Card c WHERE c.colour = :colour"),
    @NamedQuery(name = "Card.findByNumber", query = "SELECT c FROM Card c WHERE c.number = :number")})
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CardId")
    private Integer cardId;
    @Size(max = 45)
    @Column(name = "ImageUrl")
    private String imageUrl;
    @Size(max = 45)
    @Column(name = "Shape")
    private String shape;
    @Size(max = 45)
    @Column(name = "Shade")
    private String shade;
    @Size(max = 45)
    @Column(name = "Colour")
    private String colour;
    @Size(max = 45)
    @Column(name = "Number")
    private String number;

    public Card() {
    }

    public Card(String shape,String shade,String colour,String number) {
        this.shape=shape;
        this.shade=shade;
        this.colour=colour;
        this.number=number;                
    }
    public Card(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getShade() {
        return shade;
    }

    public void setShade(String shade) {
        this.shade = shade;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardId != null ? cardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Card)) {
            return false;
        }
        Card other = (Card) object;
        if ((this.cardId == null && other.cardId != null) || (this.cardId != null && !this.cardId.equals(other.cardId))) {
            return false;
        }
        return true;
    }
    
    
    public JsonObject toJson(){
        return (Json.createObjectBuilder()     
                .add("CardId",cardId)
                .add("CardUrl",imageUrl) 
                .add("CardShape",shape)
                .add("CardShade",shade)
                .add("CardColor",colour)
                .add("CardNumber",number)
                .build());
    }

    @Override
    public String toString() {
        return "com.setgame.model.Card[ cardId=" + cardId + " ]";
    }
    
}
