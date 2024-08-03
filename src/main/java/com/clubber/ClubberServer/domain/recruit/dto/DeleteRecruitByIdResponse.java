package com.clubber.ClubberServer.domain.recruit.dto;

import com.clubber.ClubberServer.domain.recruit.domain.Recruit;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteRecruitByIdResponse {
    private String message;
    private Long clubId;
    private Long recruitId;
    private String title;
    private String content;
    private String imageUrl;
    private Long totalView;
    private LocalDateTime createdAt;
    private boolean deleted;


    public static DeleteRecruitByIdResponse from(Recruit recruit){
        return DeleteRecruitByIdResponse.builder()
                .message("해당 모집글이 삭제되었습니다.")
                .clubId(recruit.getClub().getId())
                .recruitId(recruit.getId())
                .title(recruit.getTitle())
                .content(recruit.getContent())
                .imageUrl(recruit.getImageUrl())
                .totalView(recruit.getTotalView())
                .createdAt(recruit.getCreatedAt())
                .deleted(recruit.isDeleted())
                .build();
    }

}