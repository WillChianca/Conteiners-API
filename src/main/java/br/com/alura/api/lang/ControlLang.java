package br.com.alura.api.lang;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ControlLang {

    @Autowired
    private LangRepository repositor;

    @GetMapping("/lang")
    public List<Language> getLang()
    {
        List<Language> language = repositor.findByOrderByRanking();
        return language;
    }
    
    @PostMapping("/lang")
    public Language LogLang(@RequestBody Language lang)
    {
        Language saved = repositor.save(lang);
        return saved;
    }

    @GetMapping("/lang/{id}")
    public Language getLangbyId(@PathVariable String id)
    {
        return repositor.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/lang/{id}")
    public Language UpdateLang(@RequestBody Language language)
    {
        return repositor.save(language);
    }

    @DeleteMapping("/lang/{id}")
    public void DeleteLang(@PathVariable String id)
    { 
        repositor.deleteById(id);
    }
}
