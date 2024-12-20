package kr.ac.kopo.moviereview.service;

import kr.ac.kopo.moviereview.dto.MovieDTO;
import kr.ac.kopo.moviereview.dto.PageRequestDTO;
import kr.ac.kopo.moviereview.dto.PageResultDTO;
import kr.ac.kopo.moviereview.entity.Movie;

import java.util.HashMap;
import java.util.Map;

public interface MovieService {

    Long register(MovieDTO movieDTO);

    PageResultDTO<MovieDTO, Object[]> getList(PageRequestDTO requestDTO); //목록 처리

    MovieDTO getMovie(Long mno);

    default MovieDTO entitiesToDTO(Movie movie, Double avg, Long reviewCnt){
        MovieDTO movieDTO = MovieDTO.builder()
                .mno(movie.getMno())
                .title(movie.getTitle())
                .regDate(movie.getRegDate())
                .modDate(movie.getModDate())
                .build();



        movieDTO.setAvg(avg);
        movieDTO.setReviewCnt(reviewCnt.intValue());



        return movieDTO;

    }

    default Map<String, Object> dtoToEntity(MovieDTO movieDTO){

        Map<String, Object> entityMap = new HashMap<>();

        Movie movie = Movie.builder()
                .mno(movieDTO.getMno())
                .title(movieDTO.getTitle())
                .build();

        entityMap.put("movie", movie);

        return entityMap;
    }

}
