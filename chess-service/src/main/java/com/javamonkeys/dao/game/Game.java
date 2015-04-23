package com.javamonkeys.dao.game;

import com.javamonkeys.dao.user.User;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import jdk.internal.org.objectweb.asm.commons.TryCatchBlockSorter;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import java.io.IOException;


@Entity
@Table(name = "Games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "matchDate")
    private Date matchDate;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "white_id")
    private User white;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "black_id")
    private User black;

    @Column(name = "result")
    private String result;

    @Column(name = "moveText")
    private String moveText;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private GameStatus status;

    public Game(){}

    public Game(User author) {
        setMatchDate(new Date());
        setAuthor(author);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public User getWhite() {
        return white;
    }

    public void setWhite(User white) {
        this.white = white;
    }

    public User getBlack() {
        return black;
    }

    public void setBlack(User black) {
        this.black = black;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMoveText() {
        return moveText;
    }

    public void setMoveText(String moveText) {
        this.moveText = moveText;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Enumerated(EnumType.STRING)
    public GameStatus getStatus() {
        return status;
    }

    @Enumerated(EnumType.STRING)
    public void setStatus(GameStatus status) {
        this.status = status;
    }
}
