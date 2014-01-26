/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ehrickwilliam.model;

import java.util.Calendar;

/**
 *
 * @author Erick
 */
public class Comment_sample {

    private int id;
    private Calendar data;
    private String email;
    private String issue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Comment_sample() {
    }

    public Comment_sample(int id, Calendar data, String email, String issue) {
        this.id = id;
        this.data = data;
        this.email = email;
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "Comment_sample{" + "id=" + id + ", data=" + data + ", email=" + email + ", issue=" + issue + '}';
    }


}
