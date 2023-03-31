package br.com.alura.api.lang;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LangRepository extends MongoRepository<Language, String> {
    List<Language> findByOrderByRanking();
}
