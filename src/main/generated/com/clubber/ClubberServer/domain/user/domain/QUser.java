package com.clubber.ClubberServer.domain.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -629755384L;

    public static final QUser user = new QUser("user");

    public final com.clubber.ClubberServer.domain.common.QBaseEntity _super = new com.clubber.ClubberServer.domain.common.QBaseEntity(this);

    public final EnumPath<AccountState> accountState = createEnum("accountState", AccountState.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final ListPath<com.clubber.ClubberServer.domain.favorite.domain.Favorite, com.clubber.ClubberServer.domain.favorite.domain.QFavorite> favorites = this.<com.clubber.ClubberServer.domain.favorite.domain.Favorite, com.clubber.ClubberServer.domain.favorite.domain.QFavorite>createList("favorites", com.clubber.ClubberServer.domain.favorite.domain.Favorite.class, com.clubber.ClubberServer.domain.favorite.domain.QFavorite.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<AccountRole> role = createEnum("role", AccountRole.class);

    public final NumberPath<Long> snsId = createNumber("snsId", Long.class);

    public final EnumPath<SnsType> snsType = createEnum("snsType", SnsType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

