package com.potenday.kreamish.collection.service;

import com.potenday.kreamish.collection.dto.CollectionDto;
import com.potenday.kreamish.collection.entity.Collection;
import com.potenday.kreamish.collection.repository.CollectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CollectionServiceImpl implements CollectionService {

    private final CollectionRepository collectionRepository;

    public List<CollectionDto> getAllCollections() {
        List<Collection> allCollections = collectionRepository.findAll();

        return allCollections.stream()
            .map(CollectionDto::of)
            .collect(Collectors.toList());
    }

}
