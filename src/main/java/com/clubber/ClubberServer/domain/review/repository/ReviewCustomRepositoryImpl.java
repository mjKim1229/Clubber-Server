package com.clubber.ClubberServer.domain.review.repository;

import static com.clubber.ClubberServer.domain.club.domain.QClub.club;
import static com.clubber.ClubberServer.domain.review.domain.QReview.review;
import static com.clubber.ClubberServer.domain.review.domain.QReviewKeyword.reviewKeyword;

import com.clubber.ClubberServer.domain.club.domain.Club;
import com.clubber.ClubberServer.domain.club.domain.QClub;
import com.clubber.ClubberServer.domain.review.domain.QReview;
import com.clubber.ClubberServer.domain.review.domain.QReviewKeyword;
import com.clubber.ClubberServer.domain.review.domain.Review;
import com.clubber.ClubberServer.domain.user.domain.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReviewCustomRepositoryImpl implements ReviewCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Review> queryReviewByUserOrderByIdDesc(User user) {
        return queryFactory.selectFrom(review)
                .join(review.reviewKeywords, reviewKeyword).fetchJoin()
                .join(review.club, club).fetchJoin()
                .where(review.user.eq(user))
                .orderBy(review.id.desc())
                .fetch();
    }

    @Override
    public List<Review> queryReviewByClub(Club club) {
        return queryFactory
                .selectFrom(review)
                .join(review.reviewKeywords, reviewKeyword).fetchJoin()
                .where(review.club.eq(club))
                .orderBy(review.id.desc())
                .fetch();
    }
}