package com.example.movie_proj;

import com.example.movie_proj.service.adminUserService;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
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
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootTest
public class test {
    @Test
    public void recommendresult() throws TasteException {
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
        List<RecommendedItem> recommendations = recommender.recommend(3, 3);
        System.out.println(recommendations);
        System.out.println("hello world");
        for (RecommendedItem recommendation : recommendations) {
            System.out.println("hello world 1");
            System.out.println("推荐物品为"+recommendation.getItemID()+recommendation.getValue());
        }
    }
    @Test
    public void recommendresult2() throws TasteException, IOException {
        DataModel  model =new FileDataModel(new File("C:\\Users\\25097\\Desktop\\taste_preferences.txt"));
        System.out.println(model);
        UserSimilarity similarity =new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighborhood =new NearestNUserNeighborhood(2,similarity,model);
        Recommender recommender= new GenericUserBasedRecommender(model,neighborhood,similarity);
        List<RecommendedItem> recommendations =recommender.recommend(1, 3);
        for(RecommendedItem recommendation :recommendations){
            System.out.println(recommendation);
        }
    }
    @Test
    public void recommendresult3() throws TasteException, IOException {
        DataModel  model =new FileDataModel(new File("C:\\Users\\25097\\Desktop\\data.txt"));
        System.out.println(model);
        UserSimilarity similarity =new PearsonCorrelationSimilarity(model);
        UserNeighborhood neighborhood =new NearestNUserNeighborhood(2,similarity,model);
        Recommender recommender= new GenericUserBasedRecommender(model,neighborhood,similarity);
        List<RecommendedItem> recommendations =recommender.recommend(1, 3);
        for(RecommendedItem recommendation :recommendations){
            System.out.println(recommendation);
        }
    }
    @Test
    public void recommendresult4() throws TasteException {
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
        List<RecommendedItem> recommendations = recommender.recommend(1, 3);
        System.out.println(recommendations);
        System.out.println("hello world");
        for (RecommendedItem recommendation : recommendations) {
            System.out.println("hello world 1");
            System.out.println("推荐物品为"+recommendation.getItemID()+recommendation.getValue());
        }
    }
}

