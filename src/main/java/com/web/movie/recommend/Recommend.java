package com.web.movie.recommend;


import com.web.movie.entity.Comment;
import com.web.movie.entity.User;
import com.web.movie.service.CommentService;
import com.web.movie.service.MovieInfoService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Recommend {
    /**
     * 在给定username的情况下，计算其他用户和它的距离并排序
     * //@param username
     * @return
     */
    CommentService commentService;
    private Map<Double, String> computeNearestNeighbor(User user,List<User> userList) {
        Map<Double, String> distances = new TreeMap<>();

        User u1 = new User();
        for (User i:userList) {
            if (user.getUserId()==i.getUserId()) {
                u1 = i;
            }
        }

        for (int i = 0; i < userList.size(); i++) {
            User u2 = userList.get(i);

            if (u2.getUserId()!=user.getUserId()) {
                double distance = pearson_dis(commentService.getCommentsByUser(u1.getUserId()),  commentService.getCommentsByUser(u1.getUserId()));
                distances.put(distance, u2.getUserName());
            }

        }
       // System.out.println("该用户与其他用户的皮尔森相关系数 -> " + distances);
        return distances;
    }


    /**
     * 计算2个打分序列间的pearson距离
     * 选择公式四进行计算
     * @param rating1
     * @param rating2
     * @return
     */
    private double pearson_dis(List<Comment> rating1, List<Comment> rating2) {
        int n=rating1.size();
        List<Integer> rating1ScoreCollect = rating1.stream().map(A -> A.getGrading()).collect(Collectors.toList());
        List<Integer> rating2ScoreCollect = rating2.stream().map(A -> A.getGrading()).collect(Collectors.toList());

        double Ex= rating1ScoreCollect.stream().mapToDouble(x->x).sum();
        double Ey= rating2ScoreCollect.stream().mapToDouble(y->y).sum();
        double Ex2=rating1ScoreCollect.stream().mapToDouble(x->Math.pow(x,2)).sum();
        double Ey2=rating2ScoreCollect.stream().mapToDouble(y->Math.pow(y,2)).sum();
        double Exy= IntStream.range(0,n).mapToDouble(i->rating1ScoreCollect.get(i)*rating2ScoreCollect.get(i)).sum();
        double numerator=Exy-Ex*Ey/n;
        double denominator=Math.sqrt((Ex2-Math.pow(Ex,2)/n)*(Ey2-Math.pow(Ey,2)/n));
        if (denominator==0) return 0.0;
        return numerator/denominator;
    }


    public List<Comment> recommend(User user,List<User> userList) {
        //找到最近邻
        Map<Double, String> distances = computeNearestNeighbor(user,userList);
        String nearest = distances.values().iterator().next();
        //System.out.println("最近邻 -> " + nearest);

        //找到最近邻看过，但是我们没看过的电影，计算推荐
        User neighborRatings = new User();
        for (User i : userList) {
            if (nearest.equals(i.getUserName())) {
                neighborRatings = i;
            }
        }
        //System.out.println("最近邻看过的电影 -> " + neighborRatings.movieList);

        User userRatings = new User();
        for (User i :userList) {
            if (user.getUserName().equals(i.getUserName())) {
                userRatings = i;
            }
        }
        //System.out.println("用户看过的电影 -> " + userRatings.movieList);

        //根据自己和邻居的电影计算推荐的电影
        List<Comment> recommendationMovies = new ArrayList<>();
        for (Comment movie : commentService.getCommentsByUser(neighborRatings.getUserId())) {
            if (userRatings.find(movie.getMovieTitle(),commentService.getCommentsByUser(userRatings.getUserId())) == null) {
                recommendationMovies.add(movie);
            }
        }
        Collections.sort(recommendationMovies);
        return recommendationMovies;
    }
}

