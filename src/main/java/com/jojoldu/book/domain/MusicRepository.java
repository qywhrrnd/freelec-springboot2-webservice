package com.jojoldu.book.domain;

import com.jojoldu.book.domain.music.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}

