package com.clubber.ClubberServer.admin.service;

import static com.clubber.ClubberServer.util.fixture.AdminReviewFixture.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.clubber.ClubberServer.domain.admin.dto.UpdateAdminsReviewApprovedStatusResponse;
import com.clubber.ClubberServer.domain.admin.service.AdminReviewService;
import com.clubber.ClubberServer.domain.review.domain.ApprovedStatus;
import com.clubber.ClubberServer.domain.review.domain.Review;
import com.clubber.ClubberServer.domain.review.repository.ReviewRepository;
import com.clubber.ClubberServer.util.ServiceTest;
import com.clubber.ClubberServer.util.WithMockCustomUser;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.assertj.core.api.Assertions.assertThat;

public class AdminReviewServiceTest extends ServiceTest {

	@Autowired
	private AdminReviewService adminReviewService;

	@Autowired
	private ReviewRepository reviewRepository;

	@DisplayName("리뷰 승인을 수행한다")
	@WithMockCustomUser
	@Test
	void updateAdminsReviewApprove(){
		UpdateAdminsReviewApprovedStatusResponse updateAdminsReviewApprovedStatusResponse = adminReviewService.updateAdminsReviewsApprovedStatus(
			VALID_UPDATE_ADMINS_REVIEW_STATUS_REQEUST_APPROVE);

		List<Review> approvedReviews = reviewRepository.findAllById(updateAdminsReviewApprovedStatusResponse.getReviewIds());

		assertThat(approvedReviews)
			.allMatch(review -> review.getApprovedStatus() == ApprovedStatus.APPROVED);

	}

	@DisplayName("리뷰 거절을 수행한다")
	@WithMockCustomUser
	@Test
	void updateAdminsReviewReject(){
		UpdateAdminsReviewApprovedStatusResponse updateAdminsReviewApprovedStatusResponse = adminReviewService.updateAdminsReviewsApprovedStatus(
			VALID_UPDATE_ADMINS_REVIEW_STATUS_REQEUST_REJECT);

		List<Review> approvedReviews = reviewRepository.findAllById(updateAdminsReviewApprovedStatusResponse.getReviewIds());

		assertThat(approvedReviews)
			.allMatch(review -> review.getApprovedStatus() == ApprovedStatus.REJECTED);
	}

}