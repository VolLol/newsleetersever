package ru.newsletersever.enterypoints.http;

import ru.newsletersever.enterypoints.http.entities.newsletter.NewsLetterCreateEntity;
import ru.newsletersever.enterypoints.http.entities.newsletter.NewsLetterDeleteEntity;
import ru.newsletersever.enterypoints.http.entities.newsletter.NewsLetterOutEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class NewsLetterController {

    ArrayList <NewsLetterOutEntity> newsLetterList= new ArrayList<NewsLetterOutEntity>();
    @GetMapping("/newsletter")
    public ArrayList<NewsLetterOutEntity> getAllMailing (){
        newsLetterList.add(new NewsLetterOutEntity(1L,"newLetterName0","subject","text-text-text","to@mail.com"));
        newsLetterList.add(new NewsLetterOutEntity(2L,"newLetterName1","subject","text-text-text","to@mail.com"));
        newsLetterList.add(new NewsLetterOutEntity(3L,"newLetterName2","subject","text-text-text","to@mail.com"));
        return newsLetterList;
    }

    @PostMapping("/newsletter")
    public NewsLetterOutEntity createNewsletter(@Valid @RequestBody NewsLetterCreateEntity newsLetterIn){
        return new NewsLetterOutEntity(1L, newsLetterIn.getNewsLetterName(), newsLetterIn.getSubject(),newsLetterIn.getFrom(),newsLetterIn.getTo());
    }

    @PutMapping("/newsletter")
    public NewsLetterOutEntity updateMailingName (String newMailingName, @RequestBody NewsLetterOutEntity newsLetterOutEntity){
        newsLetterOutEntity.setNewsLetterName(newMailingName);
        return newsLetterOutEntity;
    }

    @DeleteMapping("/newsletter/{newsLetterId}")
    public NewsLetterDeleteEntity deleteEntity (@PathVariable Long newsLetterId){
        if(newsLetterId == 4L ) return new NewsLetterDeleteEntity("OK");
        return new NewsLetterDeleteEntity("NOT_Exist");
    }

}
