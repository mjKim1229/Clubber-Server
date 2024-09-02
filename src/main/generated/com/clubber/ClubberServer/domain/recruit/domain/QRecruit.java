package com.clubber.ClubberServer.domain.recruit.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecruit is a Querydsl query type for Recruit
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecruit extends EntityPathBase<Recruit> {

    private static final long serialVersionUID = -2003550982L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecruit recruit = new QRecruit("recruit");

    public final com.clubber.ClubberServer.domain.common.QBaseEntity _super = new com.clubber.ClubberServer.domain.common.QBaseEntity(this);

    public final com.clubber.ClubberServer.domain.club.domain.QClub club;

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final ListPath<RecruitImage, QRecruitImage> recruitImages = this.<RecruitImage, QRecruitImage>createList("recruitImages", RecruitImage.class, QRecruitImage.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final NumberPath<Long> totalView = createNumber("totalView", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QRecruit(String variable) {
        this(Recruit.class, forVariable(variable), INITS);
    }

    public QRecruit(Path<? extends Recruit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecruit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecruit(PathMetadata metadata, PathInits inits) {
        this(Recruit.class, metadata, inits);
    }

    public QRecruit(Class<? extends Recruit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.club = inits.isInitialized("club") ? new com.clubber.ClubberServer.domain.club.domain.QClub(forProperty("club"), inits.get("club")) : null;
    }

}

