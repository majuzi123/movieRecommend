package com.web.movie.service.impl;

import com.web.movie.entity.MovieInfo;
import com.web.movie.mapper.MovieInfoMapper;
import com.web.movie.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {

    @Autowired(required = false)
    private MovieInfoMapper movieInfoMapper;

    @Override
    public List<MovieInfo> getNewMovies() {
        return movieInfoMapper.getNewMovies();
    }

}
