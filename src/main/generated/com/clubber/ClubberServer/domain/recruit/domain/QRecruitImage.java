package com.clubber.ClubberServer.domain.recruit.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecruitImage is a Querydsl query type for RecruitImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecruitImage extends EntityPathBase<RecruitImage> {

    private static final long serialVersionUID = -981170047L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecruitImage recruitImage = new QRecruitImage("recruitImage");

    public final com.clubber.ClubberServer.domain.common.QBaseEntity _super = new com.clubber.ClubberServer.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final QRecruit recruit;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QRecruitImage(String variable) {
        this(RecruitImage.class, forVariable(variable), INITS);
    }

    public QRecruitImage(Path<? extends RecruitImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecruitImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecruitImage(PathMetadata metadata, PathInits inits) {
        this(RecruitImage.class, metadata, inits);
    }

    public QRecruitImage(Class<? extends RecruitImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.recruit = inits.isInitialized("recruit") ? new QRecruit(forProperty("recruit"), inits.get("recruit")) : null;
    }

}

