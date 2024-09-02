package com.clubber.ClubberServer.domain.review.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewKeyword is a Querydsl query type for ReviewKeyword
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewKeyword extends EntityPathBase<ReviewKeyword> {

    private static final long serialVersionUID = 1863550439L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewKeyword reviewKeyword = new QReviewKeyword("reviewKeyword");

    public final com.clubber.ClubberServer.domain.common.QBaseEntity _super = new com.clubber.ClubberServer.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<Keyword> keyword = createEnum("keyword", Keyword.class);

    public final QReview review;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReviewKeyword(String variable) {
        this(ReviewKeyword.class, forVariable(variable), INITS);
    }

    public QReviewKeyword(Path<? extends ReviewKeyword> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewKeyword(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewKeyword(PathMetadata metadata, PathInits inits) {
        this(ReviewKeyword.class, metadata, inits);
    }

    public QReviewKeyword(Class<? extends ReviewKeyword> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
    }

}

