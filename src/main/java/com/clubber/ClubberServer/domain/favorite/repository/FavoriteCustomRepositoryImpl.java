package com.clubber.ClubberServer.domain.favorite.repository;

import static com.clubber.ClubberServer.domain.club.domain.QClub.club;
import static com.clubber.ClubberServer.domain.favorite.domain.QFavorite.favorite;
import static com.clubber.ClubberServer.domain.user.domain.QUser.user;

import com.clubber.ClubberServer.domain.club.domain.QClub;
import com.clubber.ClubberServer.domain.favorite.domain.Favorite;
import com.clubber.ClubberServer.domain.user.domain.QUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FavoriteCustomRepositoryImpl implements FavoriteCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Favorite> queryFavoritesByUserId(Long userId) {

        return queryFactory.selectFrom(favorite)
                .leftJoin(favorite.club, club).fetchJoin()
                .leftJoin(favorite.user, user).fetchJoin()
                .where(favorite.user.id.eq(userId))
                .fetch();
    }
}