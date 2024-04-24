package com.info.infoma.repository;

import com.info.infoma.domain.entity.CharacterBasicCache;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CharacterShortRepository extends PagingAndSortingRepository<CharacterBasicCache, String> {
}
