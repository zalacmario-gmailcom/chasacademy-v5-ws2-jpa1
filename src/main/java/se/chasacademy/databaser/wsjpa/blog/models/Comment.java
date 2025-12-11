package se.chasacademy.databaser.wsjpa.blog.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "title")
    private String title;

    @Column(name = "comment_date")
    private LocalDateTime commentDate;

    @Column(name = "comment")
    private String comment_text;

    @Column(name = "inappropriate")
    private boolean isinappropriate;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment_text;
    }

    public void setComment(String comment_text) {
        this.comment_text = comment_text;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }

    public boolean getisinappropriate() {
        return isinappropriate;
    }

    public void setinappropriate(boolean inapporopriate) {
        isinappropriate = inapporopriate;
    }
}
