package com.example.novelreview.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReviewedKey implements Serializable {
    @Column(name = "novel_id")
    private Integer novelId;

    @Column(name = "reviewer_id")
    private Integer reviewerId;

    public Integer getNovelId() {
        return novelId;
    }

    public void setNovelId(Integer novelId) {
        this.novelId = novelId;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewedKey)) return false;
        ReviewedKey that = (ReviewedKey) o;
        return novelId.equals(that.novelId) &&
                reviewerId.equals(that.reviewerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(novelId, reviewerId);
    }
}
