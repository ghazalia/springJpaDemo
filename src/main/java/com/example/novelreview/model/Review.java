package com.example.novelreview.model;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "review")
public class Review {

    @EmbeddedId
    ReviewedKey id;

    @ManyToOne
    @MapsId("reviewerId")
    @JoinColumn(name = "reviewer_id")
    private Reviewer reviewer;

    @ManyToOne
    @MapsId("novelId")
    @JoinColumn(name = "novel_id")
    private Novel novel;

    @Column(name = "description")
    private String description;

    public ReviewedKey getId() {
        return id;
    }

    public void setId(ReviewedKey id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public Novel getNovel() {
        return novel;
    }

    public void setNovel(Novel novel) {
        this.novel = novel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return id.equals(review.id) &&
                reviewer.equals(review.reviewer) &&
                novel.equals(review.novel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reviewer, novel);
    }
}
