package com.guvvalas.api.service;

import com.guvvalas.api.model.Chapter;
import com.guvvalas.api.repository.ChapterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ChapterService implements IChapterService{


    @Autowired
    private ChapterRepository chapterRepository;
    /**
     * @param chapter
     */
    @Override
    public void saveChapter(Chapter chapter) {
        chapterRepository.saveChapter(chapter);
    }

    /**
     * @return
     */
    @Override
    public List<Chapter> getChapters() {
        return chapterRepository.getChapters();
    }

    /**
     * @param chapterId
     * @return
     */
    @Override
    public Chapter getChapter(Integer chapterId) {
        return chapterRepository.getChapter(chapterId);
    }
}