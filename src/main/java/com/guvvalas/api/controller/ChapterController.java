package com.guvvalas.api.controller;

import com.guvvalas.api.model.Chapter;
import com.guvvalas.api.service.IChapterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
public class ChapterController {


    @Autowired
    private IChapterService chapterService;

    /**
     *
     * @return
     */
    @GetMapping("/chapters")
    public ResponseEntity<Mono<List<Chapter>>> getChapters(){
        log.info("getChapters--->");
        var response=Mono.fromCallable(()-> chapterService.getChapters()).onErrorResume(ex->{
            return Mono.error(ex);
        });
        return ResponseEntity.ok(response);
    }


    /**
     *
     * @return
     */
    @GetMapping("/chapter/{chapterId}")
    public ResponseEntity<Mono<Chapter>> getChapter(@PathVariable("chapterId") Integer chapterId){
        log.info("getChapters--->");
        var response=Mono.fromCallable(()-> chapterService.getChapter(chapterId)).onErrorResume(ex->{
            return Mono.error(ex);
        });
        return ResponseEntity.ok(response);
    }
    /**
     *
     * @param chapter
     * @return
     */
    @PostMapping("/chapter")
    public ResponseEntity<Mono<Void>> chapter(@RequestBody Chapter chapter){

        log.info("chapter--->");
        chapterService.saveChapter(chapter);
        return  ResponseEntity.ok(Mono.empty());
    }
}
