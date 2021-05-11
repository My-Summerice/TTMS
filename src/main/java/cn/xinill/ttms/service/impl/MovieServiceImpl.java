package cn.xinill.ttms.service.impl;

import cn.xinill.ttms.mapper.IMovieMapper;
import cn.xinill.ttms.pojo.Movie;
import cn.xinill.ttms.pojo.VOMovie;
import cn.xinill.ttms.pojo.VOMovieList;
import cn.xinill.ttms.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xinil
 * @Date: 2021/4/8 20:55
 */
@Service
public class MovieServiceImpl implements IMovieService {

    private IMovieMapper movieMapper;

    @Autowired(required = false)
    public void setMovieMapper(IMovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    @Override
    public int insertMovie(VOMovie voMovie) {
        Movie movie = new Movie();
        movie.setTitle(voMovie.getTitle());
        StringBuilder sb = new StringBuilder();

        //actor 演员
        for(String s : voMovie.getActor()){
            sb.append(s);
            sb.append(";");
        }
        movie.setActor(sb.toString());

        //type 电影类型
        sb = new StringBuilder();
        for(String s : voMovie.getType()){
            sb.append(s);
            sb.append(";");
        }
        movie.setType(sb.toString());

        //制片地区
        sb = new StringBuilder();
        for(String s : voMovie.getArea()){
            sb.append(s);
            sb.append(";");
        }
        movie.setArea(sb.toString());

        // 语言
        sb = new StringBuilder();
        for(String s : voMovie.getLanguage()){
            sb.append(s);
            sb.append(";");
        }
        movie.setLanguage(sb.toString());

        movie.setReleaseDate(voMovie.getReleaseDate());
        movie.setFilmlen(voMovie.getFilmlen());
        movie.setIntroduction(voMovie.getIntroduction());
        movie.setRate(voMovie.getRate());
        movie.setCover(voMovie.getCover());
        System.out.println(movie.toString());

        return movieMapper.insertMovie(movie);
    }

    @Override
    public VOMovieList getMovieList(String sortType, String sortRule, int start, int len) {
        VOMovieList movieList = new VOMovieList();

        //获取总电影数
        movieList.setSum(movieMapper.countMovie());

        //获取当前页电影信息
        List<Movie> list = movieMapper.getMovieList(sortType, sortRule, start, len);
        List<VOMovie> voMovieList = new ArrayList<>();
        for(Movie movie: list){
            VOMovie voMovie = new VOMovie();
            voMovie.setMid(movie.getMid());
            voMovie.setTitle(movie.getTitle());
            voMovie.setActor(movie.getTitle().split(";"));
            voMovie.setType(movie.getType().split(";"));
            voMovie.setArea(movie.getArea().split(";"));
            voMovie.setLanguage(movie.getLanguage().split(";"));
            voMovie.setReleaseDate(movie.getReleaseDate());
            voMovie.setFilmlen(movie.getFilmlen());
            voMovie.setIntroduction(movie.getIntroduction());
            voMovie.setRate(movie.getRate());
            voMovie.setCover("https://xinil.oss-cn-shanghai.aliyuncs.com/TTMS/"+movie.getCover());
            voMovieList.add(voMovie);
        }
        movieList.setDataSource(voMovieList);

        return movieList;
    }

    @Override
    public VOMovie getMovie(int mid) {
        Movie movie =  movieMapper.getMovie(mid);
        VOMovie voMovie = new VOMovie();
        voMovie.setTitle(movie.getTitle());
        voMovie.setActor(movie.getTitle().split(";"));
        voMovie.setType(movie.getType().split(";"));
        voMovie.setArea(movie.getArea().split(";"));
        voMovie.setLanguage(movie.getLanguage().split(";"));
        voMovie.setReleaseDate(movie.getReleaseDate());
        voMovie.setFilmlen(movie.getFilmlen());
        voMovie.setIntroduction(movie.getIntroduction());
        voMovie.setRate(movie.getRate());
        voMovie.setCover("https://xinil.oss-cn-shanghai.aliyuncs.com/TTMS/"+movie.getCover());
        return voMovie;
    }

    @Override
    public boolean deleteMovie(int mid) {
        return 1 == movieMapper.deleteMovie(mid);
    }
}
