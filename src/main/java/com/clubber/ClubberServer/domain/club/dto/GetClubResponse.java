package com.clubber.ClubberServer.domain.club.dto;

import com.clubber.ClubberServer.domain.club.domain.*;
import lombok.*;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetClubResponse {
    private Long clubId;
    private String clubName;
    private String clubType;
    private String introduction;
    private String hashTag;
    private String division;
    private String college;
    private String department;
    private String imageUrl;
    private GetClubInfoResponse clubInfo;


    public static GetClubResponse of(Club club,GetClubInfoResponse clubInfo)
    {
        return GetClubResponse.builder()
                .clubId(club.getId())
                .clubName(club.getName())
                .clubType(club.getClubType().getTitle())
                .introduction(club.getIntroduction())
                .hashTag(club.getHashtag().getTitle())
                .division(club.getDivision().getTitle())
                .college(club.getCollege().getTitle())
                .department(club.getDepartment().getTitle())
                .imageUrl(club.getImageUrl())
                .clubInfo(clubInfo)
                .build();

    }
}
