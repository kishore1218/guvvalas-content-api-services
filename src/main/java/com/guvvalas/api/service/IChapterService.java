package com.guvvalas.api.service;

import com.guvvalas.api.model.Chapter;

import java.util.List;

/**
 *
 */
public interface IChapterService{

    /**
     *
     * @param chapter
     */
    public void saveChapter(Chapter chapter);

    /**
     *
     * @return
     */
    public List<Chapter> getChapters();


    /**
     *
     * @param chapterId
     * @return
     */
    public Chapter getChapter(Integer chapterId);
}
