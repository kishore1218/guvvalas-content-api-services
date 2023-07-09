package com.guvvalas.api.repository;

import com.guvvalas.api.model.Chapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 */
@Slf4j
@Repository
public class ChapterRepository {


    private static final String COURSE_INSERT_SQL="INSERT INTO CHAPTER(CHAPTER_NAME,DESCRIPTION,SEQ,COURSE_ID,CHAPTER_CONTENT) VALUES(:aChapterName,:description,:seq,:courseId,:content)";

    private static final String GET_CHAPTER_SQL= "SELECT *FROM CHAPTER WHERE ID=:aChapterId";

    private static final String GET_ALL_CHAPTERS_SQL="SELECT *FROM CHAPTER";

    private static final String DELETE_CHAPTER_SQL="DELETE FROM CHAPTER WHERE ID=:aChapterId";

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     *
     * @param chapter
     */
    public void saveChapter(Chapter chapter){

        Map<String,Object> params=new HashMap<String,Object>();
        params.put("aChapterName",chapter.getName());
        params.put("description",chapter.getDescription());
        params.put("seq",chapter.getSequence());
        params.put("content",chapter.getContent());
        params.put("courseId",chapter.getCourseId());

        jdbcTemplate.update(COURSE_INSERT_SQL,params);
    }


    /**
     *
     * @param chapterId
     */
    public void deleteChapter(Integer chapterId){

        Map<String,Object> params=new HashMap<String,Object>();
        params.put("aChapterId",chapterId);
        jdbcTemplate.update(DELETE_CHAPTER_SQL,params);
    }


    /**
     *
     * @return
     */
    public List<Chapter> getChapters(){
        Map<String,Object> params=new HashMap<String,Object>();

        return jdbcTemplate.query(GET_ALL_CHAPTERS_SQL, params, new RowMapper<Chapter>() {

            /**
             *
             * @param rs
             * @param rowNum
             * @return
             * @throws SQLException
             */
            @Override
            public Chapter mapRow(ResultSet rs, int rowNum) throws SQLException {

                return Chapter.builder()
                        .id(rs.getInt("ID"))
                        .courseId(rs.getInt("COURSE_ID"))
                        .content(rs.getString("CHAPTER_CONTENT"))
                        .name(rs.getString("CHAPTER_NAME"))
                        .description(rs.getString("DESCRIPTION"))
                        .sequence(rs.getInt("SEQ"))
                        .isActive(rs.getBoolean("IS_ACTIVE"))
                        .isPublish(rs.getBoolean("IS_PUBLISH"))
                        .build();
            }
        });

    }

    /**
     *
     * @param chapterId
     * @return
     */
    public Chapter getChapter(Integer chapterId){
        Map<String,Object> params=new HashMap<String,Object>();
        params.put("aChapterId",chapterId);

        return jdbcTemplate.queryForObject(GET_ALL_CHAPTERS_SQL, params, new RowMapper<Chapter>() {

            /**
             *
             * @param rs
             * @param rowNum
             * @return
             * @throws SQLException
             */
            @Override
            public Chapter mapRow(ResultSet rs, int rowNum) throws SQLException {

                return Chapter.builder()
                        .id(rs.getInt("ID"))
                        .courseId(rs.getInt("COURSE_ID"))
                        .content(rs.getString("CHAPTER_CONTENT"))
                        .name(rs.getString("CHAPTER_NAME"))
                        .description(rs.getString("DESCRIPTION"))
                        .sequence(rs.getInt("SEQ"))
                        .isActive(rs.getBoolean("IS_ACTIVE"))
                        .isPublish(rs.getBoolean("IS_PUBLISH"))
                        .build();
            }
        });

    }
}
