package com.example.movie_proj.service;

import com.example.movie_proj.dao.MvlistDao;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.example.movie_proj.dao.adminUserDao;
import com.example.movie_proj.model.movieList;
import com.example.movie_proj.model.user;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class recomService {
    @Autowired
    adminUserDao adminuserdao;
    @Autowired
    MvlistDao mvlistDao;
    public List<movieList> recomlist(String username) throws TasteException {
        //查询返回的username对应的id
        user user1=adminuserdao.findByUsername(username);
        //申请list空间存放电影列表
        List<movieList> movies=new ArrayList<>();
        //获取id
        Integer  id =user1.getId();
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("movies");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setServerName("localhost");
        JDBCDataModel dataModel= new MySQLJDBCDataModel(dataSource, "taste_preferences", "uid", "mid", "score", null);
        DataModel model=dataModel;
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(3, similarity, model);
        Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        List<RecommendedItem> recommendations = recommender.recommend(id, 10);
        for (RecommendedItem recommendation : recommendations) {
            long i=recommendation.getItemID();
            int movieid=(int) i;
            movies.add(mvlistDao.findrecomlist(movieid));
        }
        return movies;
    }
}