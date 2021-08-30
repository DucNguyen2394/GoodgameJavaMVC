package com.goodgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goodgame.entity.VideoEntity;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

}
