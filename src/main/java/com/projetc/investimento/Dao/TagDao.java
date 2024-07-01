package com.projetc.investimento.Dao;

import com.projetc.investimento.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagDao extends JpaRepository<Tag, Long> {

    Boolean existsByTagName(String tagName);

}
